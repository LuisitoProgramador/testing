import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;


public class StudentTest {
    private Student student;

    @BeforeEach
    public void setUp() {
        student = new Student("John Doe", "ola@gmail.com", 20);
    }
    
    @Test
    @DisplayName("Getters")
    public void testGetters() {
        assertEquals("John Doe", student.getName());
        assertEquals("ola@gmail.com", student.getEmail());
        assertEquals(20, student.getAge());
        
    }

    @Test
    @DisplayName("Setters")
    public void testSetters() {
        student.setName("Maria Silva");
        assertEquals("Maria Silva", student.getName());
        
        student.setEmail("admin@gmail.com");
        assertEquals("admin@gmail.com", student.getEmail());
        
        student.setAge(25);
        assertEquals(25, student.getAge());

    }
    
    @Test
    @DisplayName("Incorrect Name")
    public void testIncorrectName() {
        try{
            student.setName("");
            
        } catch (IllegalArgumentException e) {
            assertEquals("Name cannot be empty", e.getMessage());
        }
        
        assertThrows(IllegalArgumentException.class, () -> {
            student.setName(null);
        });
        
    }
    @Test
    @DisplayName("Incorrect Age")
    public void testIncorrectAge() {
        try{
            student.setAge(-10);
            
        } catch (IllegalArgumentException e) {
            assertEquals("Age must be between 0 and 120 years", e.getMessage());
        }
        try{
            student.setAge(150);

        } catch (IllegalArgumentException e) {
            assertEquals("Age must be between 0 and 120 years", e.getMessage());
        }

        assertThrows(IllegalArgumentException.class, () -> {
            student.setAge(-10);
        });
        
    }
    @Test
    @DisplayName("Incorrect Email")
    public void testIncorrectEmail() {
        try{
            student.setEmail("");
            
        } catch (IllegalArgumentException e) {
            assertEquals("Email must have a valid format", e.getMessage());
        }
        try{
            student.setEmail("ola.com");

        } catch (IllegalArgumentException e) {
            assertEquals("Email must have a valid format", e.getMessage());
        }
        assertThrows(IllegalArgumentException.class, () -> {
            student.setEmail("");
        });
        
    }
    
    @Test
    @DisplayName("Add grades")
    public void testAddGrades() {
        student.addGrade(8.5);
        student.addGrade(9.0);
        student.addGrade(7.5);
        
        assertEquals(3, student.getGrades().size());
        assertEquals(8.5, student.getGrades().get(0));
        assertEquals(9.0, student.getGrades().get(1));
        assertEquals(7.5, student.getGrades().get(2));
    }

    @Test
    @DisplayName("Add negative grade")
    public void testAddNegativeGrade() {
        assertThrows(IllegalArgumentException.class, () -> {
            student.addGrade(-8.5);
        }); 
    }
    
    @Test
    @DisplayName("Average calculation")
    public void testCalculateAverage() {
        student.addGrade(8.0);
        student.addGrade(9.0);
        student.addGrade(7.0);
        assertEquals(8.0, student.calculateAverage());
    }
    @Test
    @DisplayName("Status calculation")
    public void testCalculateStatus() {
        student.addGrade(5.0);
        student.addGrade(5.0);
        student.addGrade(5.0);
        assertEquals("Regular", student.getAcademicStatus());
    }
    
    
    
}
