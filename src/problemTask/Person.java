package problemTask;

import java.util.ArrayList;
import java.util.Arrays;

public class Person {

    public static ArrayList<Problem> listOfProblems;

    public Person() {
        listOfProblems = new ArrayList<>();
    }

    public int checkListOfProblems() {
       return listOfProblems.size();
    }

    public void add(Problem problem) {
        listOfProblems.add(problem);
    }

    public void solve(Problem problem) {
        if (listOfProblems.contains(problem)) {
            listOfProblems.remove(problem);
        } else {
            throw new IllegalArgumentException("No Problem Found");
        }
    }

    public ArrayList<Problem> recountProblemsTwo () {
        return listOfProblems;
    }

    public String recountProblems() {
        return toString(listOfProblems);
    }

    private String toString(ArrayList<Problem> problem) {
        String problems = "";
        for (int index = 0; index < listOfProblems.size(); index++) {
            problems += listOfProblems.get(index).getName() + ": " + listOfProblems.get(index).getType() + "\n";
        }
        return problems;
    }
}
