### Part 1: Testing the `add` Methods  

1. Create a class named `AddMethodsTest`.
2. Write unit tests for each version of the `add` method. Ensure you test the following scenarios:
   - `add(10, 20)` should return 30.
   - `add(10, 20, 30)` should return 60.
   - `add(10.5, 20.1)` should return 30.6.
   - `add("Hello", 20)` should return "Hello 20".

### Part 2: Testing the `Student` Class  

1. Create a class named `StudentTest`.
2. Write unit tests for the `Student` class. Your tests should cover:
   - The `getAnnualFee` method correctly calculates the annual fee.
   - The `getTotalMarks` method correctly sums the marks.
   - The `getAverage` method correctly calculates the average of the marks.
   - The `getResult` method returns "pass" if all marks are above 60, and "fail" otherwise.

### Part 3: Some more Testing 😊  

1. For an additional challenge, write a test in `StudentTest` to:
   - Verify the student with the highest total marks is correctly identified.
   - Ensure the student with the least monthly fee is correctly identified.
    - Check that the scholarship eligibility is correctly determined for each student.
    - Display the name, total marks, average marks, result, and scholarship eligibility for each student.
    

2. As a developer, implement code to pass the tests given below:

``` java
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class StudentTest {

    private Student student1, student2, student3;

    @BeforeEach
    void setUp() {
        // Initialize student instances with different marks and fees
        student1 = new Student(1, "Student One", "City A", 70, 80, 90, 1000.0f, false);
        student2 = new Student(2, "Student Two", "City B", 85, 90, 95, 800.0f, false);
        student3 = new Student(3, "Student Three", "City C", 60, 70, 80, 1200.0f, false);
    }

    @Test
    void testHighestTotalMarks() {
        // Assuming a static method findStudentWithHighestTotalMarks exists and returns a Student object
        Student highestMarksStudent = Student.findStudentWithHighestTotalMarks(Arrays.asList(student1, student2, student3));
        assertEquals(student2, highestMarksStudent, "Student with the highest total marks should be Student Two");
    }

    @Test
    void testLeastMonthlyFee() {
        // Assuming a static method findStudentWithLeastMonthlyFee exists and returns a Student object
        Student leastFeeStudent = Student.findStudentWithLeastMonthlyFee(Arrays.asList(student1, student2, student3));
        assertEquals(student2, leastFeeStudent, "Student with the least monthly fee should be Student Two");
    }

    @Test
    void testScholarshipEligibility() {
        // Assuming a method isEligibleForScholarship exists for each student instance
        student1.setIsEligibleForScholarship(student1.isEligibleForScholarship());
        student2.setIsEligibleForScholarship(student2.isEligibleForScholarship());
        student3.setIsEligibleForScholarship(student3.isEligibleForScholarship());

        assertTrue(student2.isEligibleForScholarship(), "Student Two should be eligible for a scholarship based on predefined criteria");
        assertFalse(student1.isEligibleForScholarship(), "Student One should not be eligible for a scholarship based on predefined criteria");
        assertFalse(student3.isEligibleForScholarship(), "Student Three should not be eligible for a scholarship based on predefined criteria");
    }
}
```