package com.stackroute.solidprinci;

//TreatmentService interface
interface TreatmentService {
 void treat();
}

//Concrete implementation of TreatmentService: SurgeryService
class SurgeryService implements TreatmentService {

	public void treat() {
		  System.out.println("Performing surgery");
		
	}

	
  
 
}

//Another concrete implementation of TreatmentService: MedicationService
class MedicationService implements TreatmentService {
 
 public void treat() {
	  System.out.println("Providing medicines");
	
}
}

//Patient class that depends on TreatmentService using Constructor Injection
class Patient {
 private final TreatmentService treatmentService;

 // Constructor Injection
 public Patient(TreatmentService treatmentService) {
     this.treatmentService = treatmentService;
 }

 public void receiveTreatment() {
     System.out.println("Patient is receiving treatment:");
     treatmentService.treat();
 }
}

//Hospital class responsible for treating patients
class Hospital {
 private final TreatmentService treatmentService;

 // Constructor Injection
 public Hospital(TreatmentService treatmentService) {
     this.treatmentService = treatmentService;
 }

 public void admitPatient(Patient patient) {
     System.out.println("Patient admitted to the hospital.");
     patient.receiveTreatment();
 }
}

//Client code
public class SampleDI {
 public static void main(String[] args) {
     // Creating instances of TreatmentService
     TreatmentService surgeryService = new SurgeryService();
     TreatmentService medicationService = new MedicationService();

     // Treating a patient with SurgeryService
     Patient patient1 = new Patient(surgeryService);
     Hospital hospital1 = new Hospital(surgeryService);
     hospital1.admitPatient(patient1);

     
     
//     
//     // Treating a patient with MedicationService
//     Patient patient2 = new Patient(medicationService);
//     Hospital hospital2 = new Hospital(medicationService);
//     hospital2.admitPatient(patient2);
 }
}