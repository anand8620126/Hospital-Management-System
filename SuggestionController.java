package com.example.doctor_patient_platform.controller;



import com.example.doctor_patient_platform.entity.Doctor;
import com.example.doctor_patient_platform.entity.Patient;
import com.example.doctor_patient_platform.service.DoctorService;
import com.example.doctor_patient_platform.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

        import java.util.List;

@RestController
@RequestMapping("/suggestions")
public class SuggestionController {
    @Autowired
    private PatientService patientService;

    @Autowired
    private DoctorService doctorService;

    @GetMapping("/{patientId}")
    public ResponseEntity<?> suggestDoctors(@PathVariable Long patientId) {
        Patient patient = patientService.getPatientById(patientId);

        if (patient == null) {
            return ResponseEntity.badRequest().body("Patient not found");
        }

        String speciality = null;
        switch (patient.getSymptom()) {
            case "Arthritis":
            case "Back Pain":
            case "Tissue injuries":
                speciality = "Orthopaedic";
                break;
            case "Dysmenorrhea":
                speciality = "Gynecology";
                break;
            case "Skin infection":
            case "Skin burn":
                speciality = "Dermatology";
                break;
            case "Ear pain":
                speciality = "ENT";
                break;
            default:
                return ResponseEntity.badRequest().body("Invalid symptom");
        }

        List<Doctor> doctors = doctorService.findDoctorsByCityAndSpeciality(patient.getCity(), speciality);

        if (doctors.isEmpty()) {
            if (!patient.getCity().equals("Delhi") && !patient.getCity().equals("Noida") && !patient.getCity().equals("Faridabad")) {
                return ResponseEntity.ok("We are still waiting to expand to your location");
            } else {
                return ResponseEntity.ok("There isn’t any doctor present at your location for your symptom");
            }
        }

        return ResponseEntity.ok(doctors);
    }
}
