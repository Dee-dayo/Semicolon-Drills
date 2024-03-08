package employee;

public class CommissionEmployee extends Employee {
    private double grossSales;
    private double commissionRate;

    public CommissionEmployee(String firstName, String lastName, String SocialSecurityNumber, double grossSales, double commissionRate) {
        super(firstName, lastName, SocialSecurityNumber);

        if (commissionRate <= 0.0 || commissionRate >= 1.0) throw new IllegalArgumentException("Commission rate must be > 0.0 and < 1.0");
        if (grossSales < 0.0) throw new IllegalArgumentException("Gross sales must be >= 0.0");
        this.grossSales = grossSales;
        this.commissionRate = commissionRate;
    }

    public void setCommissionRate(double commissionRate){
        if (commissionRate <= 0.0 || commissionRate >= 1.0) throw new IllegalArgumentException("Commission rate must be > 0.0 and < 1.0");
        this.commissionRate = commissionRate;
    }

    public double getCommissionRate(){
        return this.commissionRate;
    }

    public void setGrossSales(double grossSales){
        if (grossSales < 0.0) throw new IllegalArgumentException("Gross sales must be >= 0.0");
        this.grossSales = grossSales;
    }

    public double getGrossSales(){
        return this.grossSales;
    }

    @Override
    public double earnings(){
        return getCommissionRate() * getGrossSales();
    }

    @Override
    public String toString(){
        return String.format("%s: %s%n%s: $%,.2f; %s: %.2f", "Commission employee", super.toString(), "gross sales", getGrossSales(), "commission rate", getCommissionRate());
    }
}
