package com.stackroute.designpatterns.interpreter;

import java.util.HashSet;
import java.util.Set;

// Abstract expression interface
interface CourseExpression {
    boolean interpret(Set<String> completedCourses);
}

// Terminal expression
class Course implements CourseExpression {
    private String courseName;

    public Course(String courseName) {
        this.courseName = courseName;
    }

    @Override
    public boolean interpret(Set<String> completedCourses) {
        return completedCourses.contains(courseName);
    }
}

// Non-terminal expression
class AndExpression implements CourseExpression {
    private CourseExpression expression1;
    private CourseExpression expression2;

    public AndExpression(CourseExpression expression1, CourseExpression expression2) {
        this.expression1 = expression1;
        this.expression2 = expression2;
    }

    @Override
    public boolean interpret(Set<String> completedCourses) {
        return expression1.interpret(completedCourses) && expression2.interpret(completedCourses);
    }
}

// Client code
public class InterpreterExample {
    public static void main(String[] args) {
        // Define courses and prerequisites
        Course math101 = new Course("Math 101");
        Course physics101 = new Course("Physics 101");
        Course advancedMath = new Course("Advanced Math");
        Course quantumPhysics = new Course("Quantum Physics");

        // Define prerequisite expressions
        CourseExpression mathPrerequisite = new AndExpression(math101, physics101);
     
        
        CourseExpression advancedMathPrerequisite = new AndExpression(advancedMath, mathPrerequisite);
        CourseExpression quantumPhysicsPrerequisite = new AndExpression(quantumPhysics, advancedMathPrerequisite);

        // Student's completed courses
        Set<String> completedCourses = new HashSet<>();
        completedCourses.add("Math 101");
        completedCourses.add("Physics 101");

       
        
        
        
        // Check if the student is eligible for Quantum Physics
        boolean eligible = advancedMathPrerequisite.interpret(completedCourses);

        System.out.println("Is the student eligible for Advanced maths? " + eligible);
    }
}