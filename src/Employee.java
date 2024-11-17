import java.util.Objects;

public class Employee {
    private FullName fullName;
    private double salary;
    private int departmentNumber;
    private int id;



    public Employee(FullName fullName, int departmentNumber, double salary){
        this.fullName = fullName;
        this.departmentNumber = departmentNumber;
        this.salary = salary;
        Main.counter++;
        this.id = Main.counter;
    }

    public FullName getFullName() {
        return this.fullName;
    }

    public int getDepartmentNumber() {
        return this.departmentNumber;
    }

    public double getSalary() {
        return this.salary;
    }

    public int getId() {
        return this.id;
    }

    public void setDepartmentNumber(int departmentNumber) {
        this.departmentNumber = departmentNumber;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public boolean equals(Object other) {
        if (this.getClass() != other.getClass()) {
            return false;
        }
        Employee c = (Employee) other;
        return fullName.equals(c.fullName);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
    return "|Id: " + id + " " + fullName.toString() + "Отдел № " + departmentNumber + "|   Зарплата: " + salary + " рублей|";
    }
}