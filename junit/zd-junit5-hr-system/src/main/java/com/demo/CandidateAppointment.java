package com.demo;

import java.time.LocalDateTime;

public class CandidateAppointment {

   private String candidateFirstName;
   private String candidateLastName;
   private LocalDateTime appointmentDateTime;
   private Interviewer interviewer;

   public CandidateAppointment(String candidateFirstName, String candidateLastName, LocalDateTime appointmentDateTime, Interviewer interviewer) {
      this.candidateFirstName = candidateFirstName;
      this.candidateLastName = candidateLastName;
      this.appointmentDateTime = appointmentDateTime;
      this.interviewer = interviewer;
   }

   public String getCandidateFirstName() {
      return candidateFirstName;
   }

   public String getCandidateLastName() {
      return candidateLastName;
   }

   public LocalDateTime getAppointmentDateTime() {
      return appointmentDateTime;
   }

   public Interviewer getInterviewer() {
      return interviewer;
   }
}
