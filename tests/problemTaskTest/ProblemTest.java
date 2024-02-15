package problemTaskTest;

import org.junit.jupiter.api.Test;
import problemTask.Person;
import problemTask.Problem;
import problemTask.Type;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class ProblemTest {
    @Test
    public void testThatProblemCanBeCreated(){
        Problem newProblem = new Problem("SchoolFee", Type.FINANCIAL );
    }

    @Test
    public void personCanGenerateListOfProblem() {
        Person newPerson = new Person();
        assertEquals(0, newPerson.checkListOfProblems());
    }

    @Test
    public void personCanCreateProblem(){
        Person newPerson = new Person();
        Problem problem1 = new Problem("SchoolFee", Type.EDUCATION);
        newPerson.add(problem1);
        assertEquals(1, newPerson.checkListOfProblems());
    }

    @Test
    public void personCanCreateMoreThanOneProblem() {
        Person newPerson = new Person();
        newPerson.add(new Problem("Valentine's Gift", Type.FINANCIAL));
        newPerson.add(new Problem("SchoolFee", Type.EDUCATION));
        newPerson.add(new Problem("Barennes", Type.SPIRITUAL));
        assertEquals(3, newPerson.checkListOfProblems());
    }

    @Test
    public void personCreateProblem_personCanSolveProblem() {
        Person newPerson = new Person();
        Problem problem1 = new Problem("Valentine's Gift", Type.FINANCIAL);
        Problem problem2 = new Problem("SchoolFee", Type.EDUCATION);
        newPerson.add(problem1);
        newPerson.add(problem2);
        assertEquals(2, newPerson.checkListOfProblems());

        newPerson.solve(problem1);
        assertEquals(1,  newPerson.checkListOfProblems());
    }

    @Test
    public void personCreateProblem_personCanRecountProblem() {
        Person newPerson = new Person();
        Problem problem1 = new Problem("Valentine's Gift", Type.FINANCIAL);
        Problem problem2 = new Problem("SchoolFee", Type.EDUCATION);
        newPerson.add(problem1);
        newPerson.add(problem2);
        String expected = "Valentine's Gift: FINANCIAL\nSchoolFee: EDUCATION\n";
        assertEquals(expected, newPerson.recountProblems());
    }

    @Test
    public void personCanCreateProblem_solveProblem_RecountProblem() {
        Person newPerson = new Person();
        Problem problem1 = new Problem("Valentine's Gift", Type.FINANCIAL);
        Problem problem2 = new Problem("SchoolFee", Type.EDUCATION);
        newPerson.add(problem1);
        newPerson.add(problem2);
        String expected = "Valentine's Gift: FINANCIAL\nSchoolFee: EDUCATION\n";
        assertEquals(expected, newPerson.recountProblems());

        newPerson.solve(problem1);
        String newExpected = "SchoolFee: EDUCATION\n";
        assertEquals(newExpected, newPerson.recountProblems());
    }

    @Test
    public void personHaveProblem_cantSolveProblemHeDoesntHave() {
        Person newPerson = new Person();
        Problem problem1 = new Problem("Valentine's Gift", Type.FINANCIAL);
        Problem problem2 = new Problem("SchoolFee", Type.EDUCATION);
        newPerson.add(problem1);

        assertThrows(IllegalArgumentException.class, ()-> newPerson.solve(problem2));
    }

    @Test
    public void personHasSeveralProblems_testRecountContainsProblems() {
        Person newPerson = new Person();
        Problem problem1 = new Problem("Valentine's Gift", Type.FINANCIAL);
        Problem problem2 = new Problem("SchoolFee", Type.EDUCATION);
        newPerson.add(problem1);
        newPerson.add(problem2);

        boolean status = newPerson.recountProblemsTwo().contains(problem1);
        boolean status2 = newPerson.recountProblemsTwo().contains(problem2);
        assertTrue(status);
        assertTrue(status2);
        assertEquals(2, newPerson.checkListOfProblems());
    }
}
