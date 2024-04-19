package com.stackroute.designpatterns.strategypattern;
// Strategy interface
interface GradingStrategy {
    double calculateGrade(double[] scores);
}

// Concrete strategy: Standard Grading
class StandardGrading implements GradingStrategy {
    @Override
    public double calculateGrade(double[] scores) {
        double total = 0;
        for (double score : scores) {
            total += score;
        }
        return total / scores.length;
    }
}

// Concrete strategy: Weighted Grading
class WeightedGrading implements GradingStrategy {
    private double[] weights;

    public WeightedGrading(double[] weights) {
        this.weights = weights;
    }

    @Override
    public double calculateGrade(double[] scores) {
        if (scores.length != weights.length) {
            throw new IllegalArgumentException("Number of scores must match the number of weights");
        }

        double total = 0;
        for (int i = 0; i < scores.length; i++) {
            total += scores[i] * weights[i];
        }

        double totalWeight = 0;
        for (double weight : weights) {
            totalWeight += weight;
        }

        return total / totalWeight;
    }
}

// Context
class Course {
    private GradingStrategy gradingStrategy;

    public void setGradingStrategy(GradingStrategy gradingStrategy) {
        this.gradingStrategy = gradingStrategy;
    }

    public double calculateGrade(double[] scores) {
        return gradingStrategy.calculateGrade(scores);
    }
}

// Client code
public class StrategyExample {
    public static void main(String[] args) {
        double[] standardGrades = {90, 85, 92, 88};
        double[] weightedGrades = {90, 85, 92, 88};

        Course course = new Course();

        // Using standard grading strategy
        course.setGradingStrategy(new StandardGrading());
        double standardGrade = course.calculateGrade(standardGrades);
        System.out.println("Standard Grade: " + standardGrade);
        
        

        // Using weighted grading strategy
        double[] weights = {0.3, 0.2, 0.3, 0.2};
        course.setGradingStrategy(new WeightedGrading(weights));
        
        double weightedGrade = course.calculateGrade(weightedGrades);
        System.out.println("Weighted Grade: " + weightedGrade);
    }
}