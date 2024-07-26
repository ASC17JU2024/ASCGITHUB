package com.demo;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

public class HRMain {

   private static HRCalendar calendar;

   public static void main(String[] args) throws Throwable {
      calendar = new HRCalendar(LocalDate.now());
      Scanner scanner = new Scanner(System.in);
      System.out.println("Welcome to the Interviewer Intake Computer System!\n\n");
      String lastOption = "";
      while (!lastOption.equalsIgnoreCase("x")) {
         lastOption = displayMenu(scanner);
      }
      System.out.println("\nExiting System...\n");
   }

   private static String displayMenu(Scanner scanner) throws Throwable {
      System.out.println("Please select an option:");
      System.out.println("1. Enter a Interviewer Appointment");
      System.out.println("2. View All Appointments");
      System.out.println("3. View Today's Appointments");
      System.out.println("X.  Exit System.");
      System.out.print("Option: ");
      String option = scanner.next();
      switch (option) {
         case "1": performInterviewerEntry(scanner);
                 return option;
         case "2": performAllAppointments();
                 return option;
         case "3": performTodayAppointments();
            return option;
         default: System.out.println("Invalid option, please re-enter.");
                  return option;
      }
   }

   private static void performInterviewerEntry(Scanner scanner) {
      scanner.nextLine();
      System.out.println("\n\nPlease Enter Appointment Info:");
      System.out.print("  Candidate Last Name: ");
      String lastName = scanner.nextLine();
      System.out.print("  Candidate First Name: ");
      String firstName = scanner.nextLine();
      System.out.print("  Appointment Date (M/d/yyyy h:m a): ");
      String when = scanner.nextLine();
      System.out.print("  Interviewer Last Name: ");
      String interviewer = scanner.nextLine();
      try {
         calendar.addAppointment(firstName, lastName, interviewer, when);
      } catch (Throwable t) {
         System.out.println("Error!  " + t.getMessage());
         return;
      }
      System.out.println("Candidate entered successfully.\n\n");
   }

   private static void performAllAppointments() throws Throwable {
      System.out.println("\n\nAll Appointments in System:");
      for (CandidateAppointment appointment : calendar.getAppointments()) {
         DateTimeFormatter formatter = DateTimeFormatter.ofPattern("M/d/yyyy hh:mm a");
         String apptTime = formatter.format(appointment.getAppointmentDateTime());
         System.out.println(String.format("%s:  %s, %s\t\tInterviewer: %s", apptTime, appointment.getCandidateFirstName(),
            appointment.getCandidateLastName(), appointment.getInterviewer().getName()));
      }
      System.out.println("\nPress any key to continue...");
      System.in.read();
      System.out.println("\n\n");
   }
   private static void performTodayAppointments() throws Throwable {
      System.out.println("\n\nAppointments for Today:");
      listAppointments(calendar.getTodayAppointments());
      System.out.println("\nPress any key to continue...");
      System.in.read();
      System.out.println("\n\n");
   }
   private static void listAppointments(List<CandidateAppointment> appointments) {
      for (CandidateAppointment appointment : appointments) {
         DateTimeFormatter formatter = DateTimeFormatter.ofPattern("M/d/yyyy hh:mm a");
         String apptTime = formatter.format(appointment.getAppointmentDateTime());
         System.out.println(String.format("%s:  %s, %s\t\tDoctor: %s", apptTime, appointment.getCandidateLastName(),
                 appointment.getCandidateFirstName(), appointment.getInterviewer().getName()));
      }
   }
}
