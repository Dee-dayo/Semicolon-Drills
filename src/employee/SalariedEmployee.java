package employee;

public class SalariedEmployee extends Employee {
    private double weeklySalary;

    public SalariedEmployee(String firstName, String lastName, String SocialSecurityNumber, double weeklySalary) {
        super(firstName, lastName, SocialSecurityNumber);

        if (weeklySalary < 0.00) throw new IllegalArgumentException("Weekly salary must be >0 0.0");
        this.weeklySalary = weeklySalary;
    }

    public void setWeeklySalary(double weeklySalary) {
        if (weeklySalary < 0.00) throw new IllegalArgumentException("Weekly salary must be >0 0.0");
        this.weeklySalary = weeklySalary;
    }

    public double getWeeklySalary() {
        return weeklySalary;
    }

    @Override
    public double earnings() {
        return weeklySalary;
    }

    @Override
    public String toString(){
        return String.format("Salaried employee: %s%n%s: $%,.2f", super.toString(), "Weeklysalary", getWeeklySalary());
    }
}
