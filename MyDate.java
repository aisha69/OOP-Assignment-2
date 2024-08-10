

// MyDate Class
class MyDate {
    private int year;
    private int month;
    private int day;

    public MyDate(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    @Override
    public String toString() {
        return year + "-" + month + "-" + day;
    }
}

// Person Class
class Person {
    private String name;
    private String address;
    private String phoneNumber;
    private String emailAddress;

    public Person(String name, String address, String phoneNumber, String emailAddress) {
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.emailAddress = emailAddress;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + ": " + name;
    }
}

// Student Class
class Student extends Person {
    private StudentStatus status;

    public Student(String name, String address, String phoneNumber, String emailAddress, StudentStatus status) {
        super(name, address, phoneNumber, emailAddress);
        this.status = status;
    }

    @Override
    public String toString() {
        return super.toString() + ", Status: " + status;
    }
}

// Employee Class
class Employee extends Person {
    private String office;
    private double salary;
    private MyDate dateHired;

    public Employee(String name, String address, String phoneNumber, String emailAddress, String office, double salary, MyDate dateHired) {
        super(name, address, phoneNumber, emailAddress);
        this.office = office;
        this.salary = salary;
        this.dateHired = dateHired;
    }

    @Override
    public String toString() {
        return super.toString() + ", Office: " + office + ", Salary: $" + salary + ", Date Hired: " + dateHired;
    }
}

// Faculty Class
class Faculty extends Employee {
    private String officeHours;
    private String rank;

    public Faculty(String name, String address, String phoneNumber, String emailAddress, String office, double salary, MyDate dateHired, String officeHours, String rank) {
        super(name, address, phoneNumber, emailAddress, office, salary, dateHired);
        this.officeHours = officeHours;
        this.rank = rank;
    }

    @Override
    public String toString() {
        return super.toString() + ", Office Hours: " + officeHours + ", Rank: " + rank;
    }
}

// Staff Class
class Staff extends Employee {
    private String title;

    public Staff(String name, String address, String phoneNumber, String emailAddress, String office, double salary, MyDate dateHired, String title) {
        super(name, address, phoneNumber, emailAddress, office, salary, dateHired);
        this.title = title;
    }

    @Override
    public String toString() {
        return super.toString() + ", Title: " + title;
    }
}

// FullTime Class
class FullTime extends Staff {
    public FullTime(String name, String address, String phoneNumber, String emailAddress, String office, double salary, MyDate dateHired, String title) {
        super(name, address, phoneNumber, emailAddress, office, salary, dateHired, title);
    }

    public double getEarnings() {
        return super.salary;
    }

    @Override
    public String toString() {
        return super.toString() + ", Earnings: $" + getEarnings();
    }
}

// PartTime Class
class PartTime extends Staff {
    private double hourlyRate;
    private int hoursWorked;

    public PartTime(String name, String address, String phoneNumber, String emailAddress, String office, double salary, MyDate dateHired, String title, double hourlyRate, int hoursWorked) {
        super(name, address, phoneNumber, emailAddress, office, salary, dateHired, title);
        this.hourlyRate = hourlyRate;
        this.hoursWorked = hoursWorked;
    }

    public double getEarnings() {
        return hourlyRate * hoursWorked;
    }

    @Override
    public String toString() {
        return super.toString() + ", Hourly Rate: $" + hourlyRate + ", Hours Worked: " + hoursWorked + ", Earnings: $" + getEarnings();
    }
}

// Main Class to Test the Program
public class Main {
    public static void main(String[] args) {
        MyDate hireDate = new MyDate(2023, 5, 15);

        Person person = new Person("Alice", "123 Main St", "555-1234", "alice@example.com");
        Student student = new Student("Bob", "456 Elm St", "555-5678", "bob@example.com", StudentStatus.JUNIOR);
        Employee employee = new Employee("Charlie", "789 Oak St", "555-9012", "charlie@example.com", "Room 101", 50000, hireDate);
        Faculty faculty = new Faculty("Dave", "321 Maple St", "555-3456", "dave@example.com", "Room 202", 60000, hireDate, "9am-5pm", "Professor");
        Staff staff = new Staff("Eve", "654 Pine St", "555-7890", "eve@example.com", "Room 303", 40000, hireDate, "Manager");
        FullTime fullTime = new FullTime("Frank", "987 Cedar St", "555-6543", "frank@example.com", "Room 404", 55000, hireDate, "Supervisor");
        PartTime partTime = new PartTime("Grace", "159 Spruce St", "555-3210", "grace@example.com
