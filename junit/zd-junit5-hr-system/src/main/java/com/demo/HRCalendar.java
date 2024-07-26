package com.demo;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

public class HRCalendar {

   private List<CandidateAppointment> appointments;
   private LocalDate today;

   public HRCalendar() {
         this.today = today;
      this.appointments = new ArrayList<>();
   }

   public HRCalendar(LocalDate today) {
         this.today = today;
      this.appointments = new ArrayList<>();
   }

   public void addAppointment(String candidateFirstName, String candidateLastName, String interviewerKey,
                              String dateTime) {
      Interviewer interviewer = Interviewer.valueOf(interviewerKey.toUpperCase());
      LocalDateTime localDateTime = DateTimeConverter.convertStringToDateTime(dateTime, today);
      CandidateAppointment appointment = new CandidateAppointment(candidateFirstName, candidateLastName,
         localDateTime, interviewer);
      appointments.add(appointment);
   }

   public List<CandidateAppointment> getAppointments() {
      return this.appointments;
   }
   public List<CandidateAppointment> getTodayAppointments() {
      return appointments.stream()
              .filter(appt -> appt.getAppointmentDateTime().toLocalDate().equals(today))
              .collect(Collectors.toList());
   }

   public boolean hasAppointment(LocalDate date) {
      return appointments.stream()
              .anyMatch(appt -> appt.getAppointmentDateTime().toLocalDate().equals(date));
   }
}
