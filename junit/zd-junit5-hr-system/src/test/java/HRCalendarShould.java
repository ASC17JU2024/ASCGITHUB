
// In JUnit, the order of execution of test methods is not guaranteed by default. They could be executed in any order. This is by design, as each test method should be independent and not rely on the state left by other tests.

// However, if you really need to specify an order for your test methods, you can do so using the `@TestMethodOrder` annotation at the class level. 

import com.demo.CandidateAppointment;
import com.demo.HRCalendar;
import com.demo.Interviewer;
import org.junit.jupiter.api.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Locale;

import static org.junit.jupiter.api.Assertions.*;
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class HRCalendarShould {
   private HRCalendar calendar;

   @BeforeAll
   static void testClassSetup() {
      System.out.println("Executed BEFORE ALL tests");
      // Add setup logic for the entire test class here.
      // This could include initializing shared resources,
      // setting up a database connection, etc.
   }
//
   @BeforeEach
   void testMethodSetUp() {
      System.out.println("Executed BEFORE EACH test");
      // Add setup logic for each test method here.
      calendar = new HRCalendar(LocalDate.of(2018, 8, 26));
   }
   @Order(1)
   @Test
   void allowEntryOfAnAppointment() {
      System.out.println("1 allowEntryOfAnAppointment()");
//      HRCalendar calendar = new HRCalendar();
      calendar.addAppointment("Aaa", "Bbb", "bee",
              "09/01/2018 2:00 pm");
      List<CandidateAppointment> appointments = calendar.getAppointments();
      assertNotNull(appointments);
      assertEquals(1, appointments.size());
      CandidateAppointment enteredAppt = appointments.get(0);
      assertEquals("Aaa", enteredAppt.getCandidateFirstName());
      assertEquals("Bbb", enteredAppt.getCandidateLastName());
      assertEquals(Interviewer.BEE, enteredAppt.getInterviewer());

      assertEquals("9/1/2018 02:00 PM",
              enteredAppt.getAppointmentDateTime().format(DateTimeFormatter.ofPattern("M/d/yyyy hh:mm a", Locale.US)));
   }

   @Order(2)
   @Test
   void returnTrueForHasAppointmentsIfThereAreAppointments() {
      System.out.println("2 returnTrueForHasAppointmentsIfThereAreAppointments()");
//      HRCalendar calendar = new HRCalendar(LocalDate.now());
      calendar.addAppointment("Aaa", "Bbb", "bee",
              "09/01/2018 2:00 pm");
      assertTrue(calendar.hasAppointment(LocalDate.of(2018, 9, 1)));
   }
   @Order(3)
   @Test
   void returnFalseForHasAppointmentsIfThereAreNoAppointments() {
      System.out.println("3 returnFalseForHasAppointmentsIfThereAreNoAppointments()");
//      HRCalendar calendar = new HRCalendar(LocalDate.now());
      assertFalse(calendar.hasAppointment(LocalDate.of(2018, 9, 1)));
   }
   @Order(4)
   @Test
   void returnCurrentDaysAppointments() {
      System.out.println("4 returnCurrentDaysAppointments()");
      HRCalendar calendar = new HRCalendar(LocalDate.now());
      calendar.addAppointment("Den", "Denny", "dee",
              "03/22/2024 2:00 pm");
      calendar.addAppointment("Den", "Denny", "dee",
              "03/22/2024 2:00 pm");
      calendar.addAppointment("Den", "Denny", "dee",
              "09/01/2018 2:00 pm");
      assertEquals(2, calendar.getTodayAppointments().size());
   }
//
   @AfterAll
   static void testClassTearDown() {
      System.out.println("Executed AFTER ALL tests");
      // Add tear down logic for the entire test class here.
      // This could include closing database connections, releasing resources, etc.
   }
//
   @AfterEach
   void testMethodTearDown() {
      System.out.println("Executed AFTER EACH test");
      // Add tear down logic for each test method here.

   }
}