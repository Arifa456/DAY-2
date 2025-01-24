package com.ASS2;

import java.io.*;
import java.util.*;

class Patient {
    private int patientId;
    private String patientName;
    private String ailment;

    public Patient(int patientId, String patientName, String ailment) {
        this.patientId = patientId;
        this.patientName = patientName;
        this.ailment = ailment;
    }

    public int getPatientId() { return patientId; }
    public String getPatientName() { return patientName; }
    public String getAilment() { return ailment; }

    @Override
    public String toString() {
        return "Patient [ID=" + patientId + ", Name=" + patientName + ", Ailment=" + ailment + "]";
    }
}

class Doctor {
    private int doctorId;
    private String doctorName;
    private String specialization;

    public Doctor(int doctorId, String doctorName, String specialization) {
        this.doctorId = doctorId;
        this.doctorName = doctorName;
        this.specialization = specialization;
    }

    public int getDoctorId() { return doctorId; }
    public String getDoctorName() { return doctorName; }
    public String getSpecialization() { return specialization; }

    @Override
    public String toString() {
        return "Doctor [ID=" + doctorId + ", Name=" + doctorName + ", Specialization=" + specialization + "]";
    }
}

class Appointment {
    private int appointmentId;
    private Patient patient;
    private Doctor doctor;
    private String appointmentDate;

    public Appointment(int appointmentId, Patient patient, Doctor doctor, String appointmentDate) {
        this.appointmentId = appointmentId;
        this.patient = patient;
        this.doctor = doctor;
        this.appointmentDate = appointmentDate;
    }

    public int getAppointmentId() { return appointmentId; }
    public Patient getPatient() { return patient; }
    public Doctor getDoctor() { return doctor; }
    public String getAppointmentDate() { return appointmentDate; }

    @Override
    public String toString() {
        return "Appointment [ID=" + appointmentId + ", Patient=" + patient.getPatientName() + ", Doctor=" + doctor.getDoctorName() + ", Date=" + appointmentDate + "]";
    }
}

public class a16 {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        try {
            Patient patient1 = new Patient(1, "Alice", "Fever");
            Doctor doctor1 = new Doctor(101, "Dr. Smith", "General Medicine");
            Appointment appointment1 = new Appointment(1001, patient1, doctor1, "2025-01-25");

            System.out.println("Appointment Scheduled: " + appointment1);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
