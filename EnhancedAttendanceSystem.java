 import java.util.HashMap;
import java.util.Map;

class Employee {
    private String name;
    private boolean isCheckedIn;

    public Employee(String name) {
        this.name = name;
        this.isCheckedIn = false;
    }

    public String getName() {
        return name;
    }

    public boolean isCheckedIn() {
        return isCheckedIn;
    }

    public void checkIn() {
        isCheckedIn = true;
        System.out.println(name + " checked in at " + getCurrentTime());
    }

    public void checkOut() {
        isCheckedIn = false;
        System.out.println(name + " checked out at " + getCurrentTime());
    }

    private String getCurrentTime() {
        // Implement logic to get the current time
        return "12:00 PM"; // Placeholder for current time
    }
}

public class EnhancedAttendanceSystem {
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

    private Map<String, Employee> employeeMap;

    public EnhancedAttendanceSystem() {
        this.employeeMap = new HashMap<>();
    }

    public void addEmployee(Employee employee) {
        employees.add(employee);
        employeeMap.put(employee.getName(), employee);
    }

    public void markAttendance(String detectedPerson, boolean isCheckIn) {
        Employee employee = employeeMap.get(detectedPerson);

        if (employee != null) {
            if (isCheckIn) {
                employee.checkIn();
            } else {
                employee.checkOut();
            }
        } else {
            System.out.println("Undetected. Person is not from the organization.");
        }
    }

    public static void main(String[] args) {
        EnhancedAttendanceSystem attendanceSystem = new EnhancedAttendanceSystem();

        // Add employees to the system
        attendanceSystem.addEmployee(new Employee("John Doe"));
        attendanceSystem.addEmployee(new Employee("Alice Smith"));

        // Simulate check-in
        attendanceSystem.markAttendance("John Doe", true);

        // Simulate check-out
        attendanceSystem.markAttendance("John Doe", false);
    }
}
