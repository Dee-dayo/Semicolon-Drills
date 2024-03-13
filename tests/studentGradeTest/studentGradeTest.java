package studentGradeTest;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import studentGrade.StudentGrade;
import ticTacToe.InvalidInputException;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class studentGradeTest {

    private StudentGrade pavicSchools;

    @BeforeEach
    public void setUp(){
        pavicSchools = new StudentGrade();
    }

    @Test
    public void testTeacherCanInputNumberOfStudents(){
        pavicSchools.setNoOfStudents(3);
        assertEquals(3, pavicSchools.getNoOfStudents());
    }

    @Test
    public void testTeacherCantInputNegativeNumberOfStudentsThrowsException(){
        assertThrows(InvalidInputException.class, ()-> pavicSchools.setNoOfStudents(-5));
    }

    @Test
    public void testTeacherCanInputNumberOfSubjects(){
        pavicSchools.setNoOfSubjects(3);
        assertEquals(3, pavicSchools.getNoOfSubjects());
    }

    @Test
    public void testTeacherCantInputNegativeNumberOfSubjectsThrowsException(){
        assertThrows(InvalidInputException.class, ()-> pavicSchools.setNoOfSubjects(-5));
    }

    @Test
    public void testArrayOfStudentScoresCreatedAfterTeacherInputNumberOfStudentScores(){
        pavicSchools.setNoOfStudents(3);
         pavicSchools.setNoOfSubjects(3);
         int[][] expected = new int[3][3];
        System.out.println(Arrays.deepToString(pavicSchools.getStudentScores()));

//         assertArrayEquals(expected, pavicSchools.getStudentScores());
    }
}
