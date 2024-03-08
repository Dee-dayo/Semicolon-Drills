package employee;

public abstract class Employee {
    private final String firstName;
    private final String lastName;
    private final String SocialSecurityNumber;

    public Employee(String firstName, String lastName, String SocialSecurityNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.SocialSecurityNumber = SocialSecurityNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }
    public String getSocialSecurityNumber() {
        return SocialSecurityNumber;
    }

    @Override
    public String toString(){
        return String.format("%s %s%nSocial Security Number: %s", getFirstName(), getLastName(), getSocialSecurityNumber());
    }

    public abstract double earnings();
}
