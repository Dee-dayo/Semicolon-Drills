package problemTask;

public class Problem {
    private String name;
    private Type type;
    private boolean isSolved = false;

    public Problem (String name, Type type) {
        this.name = name;
        this.type = type;
    }

    public boolean checkStatus(){
        return isSolved;
    }
    public String getName() { return name; }
    public Type getType() {return type; }

}