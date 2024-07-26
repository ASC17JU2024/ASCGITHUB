import com.demo.CandidateAppointment;
import com.demo.HRCalendar;
import com.demo.Interviewer;
import org.junit.jupiter.api.Test;

import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Locale;

import static org.junit.jupiter.api.Assertions.*;

class HRCalendarShouldTest {

   @Test
   void allowEntryOfAnAppointment() {
      HRCalendar calendar = new HRCalendar();
      calendar.addAppointment("Aaa", "Bbb", "bee",
         "01/01/2024 2:00 pm");
      List<CandidateAppointment> appointments = calendar.getAppointments();
      assertNotNull(appointments);
      assertEquals(1, appointments.size());
      CandidateAppointment enteredAppt = appointments.get(0);
      assertEquals("Aaa", enteredAppt.getCandidateFirstName());
      assertEquals("Bbb", enteredAppt.getCandidateLastName());
      assertSame(Interviewer.BEE, enteredAppt.getInterviewer());
//      assertNotSame(Interviewer.BEE, enteredAppt.getInterviewer());
      assertNotSame(Interviewer.DEE, enteredAppt.getInterviewer());
      assertEquals("1/1/2024 02:00 PM",
         enteredAppt.getAppointmentDateTime().format(DateTimeFormatter.ofPattern("M/d/yyyy hh:mm a", Locale.US)));
   }
}