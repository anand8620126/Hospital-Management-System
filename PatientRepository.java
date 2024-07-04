package com.example.doctor_patient_platform.repository;



import com.example.doctor_patient_platform.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient, Long> {
}
