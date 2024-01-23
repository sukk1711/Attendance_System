import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Employee {
    private String name;

    public Employee(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

public class AttendanceSystem {
    private List<Employee> employees;

    public AttendanceSystem() {
        this.employees = new ArrayList<>();
    }

    public void addEmployee(Employee employee) {
        employees.add(employee);
    }

    public void markAttendance(String detectedPerson) {
        boolean isEmployee = false;
        for (Employee employee : employees) {
            if (employee.getName().equalsIgnoreCase(detectedPerson)) {
                isEmployee = true;
                System.out.println("Welcome, " + detectedPerson + "! Attendance marked.");
                break;
            }
        }

        if (!isEmployee) {
            System.out.println("Undetected. Person is not from the organization.");
        }
    }

    public static void main(String[] args) {
        AttendanceSystem attendanceSystem = new AttendanceSystem();

        // Add employees to the system
        attendanceSystem.addEmployee(new Employee("John Doe"));
        attendanceSystem.addEmployee(new Employee("Alice Smith"));

        // Simulate detection
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter detected person's name: ");
        String detectedPerson = scanner.nextLine();

        // Mark attendance
        attendanceSystem.markAttendance(detectedPerson);
    }
}
