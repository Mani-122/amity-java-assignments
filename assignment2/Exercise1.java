import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Professor {
    private String name;
    private String employeeId;
    private String specialization;

    public Professor() {
    }

    public Professor(String name, String employeeId, String specialization) {
        this.name = name;
        this.employeeId = employeeId;
        this.specialization = specialization;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    @Override
    public String toString() {
        return "Name: " + name + ", ID: " + employeeId + ", Specialization: " + specialization;
    }
}

class Department {
    private String deptName;
    private String hodName;
    private List<Professor> professors;

    public Department() {
        this.professors = new ArrayList<>();
    }

    public Department(String deptName, String hodName) {
        this.deptName = deptName;
        this.hodName = hodName;
        this.professors = new ArrayList<>();
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public String getHodName() {
        return hodName;
    }

    public void setHodName(String hodName) {
        this.hodName = hodName;
    }

    public List<Professor> getProfessors() {
        return professors;
    }

    public void setProfessors(List<Professor> professors) {
        this.professors = professors;
    }

    public void addProfessor(Professor p) {
        professors.add(p);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Department: ").append(deptName).append("\n");
        sb.append("HOD: ").append(hodName).append("\n");
        sb.append("Professors:\n");
        for (int i = 0; i < professors.size(); i++) {
            sb.append(professors.get(i).toString());
            if (i < professors.size() - 1) {
                sb.append("\n");
            }
        }
        return sb.toString();
    }
}

public class Exercise1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter Department details (deptName,hodName)");
        String[] deptDetails = sc.nextLine().split(",");
        Department dept = new Department(deptDetails[0].trim(), deptDetails[1].trim());

        System.out.println("Enter number of professors");
        int n = Integer.parseInt(sc.nextLine().trim());

        System.out.println("Enter professor details (name,employeeId,specialization)");
        for (int i = 0; i < n; i++) {
            String[] profDetails = sc.nextLine().split(",");
            Professor p = new Professor(profDetails[0].trim(), profDetails[1].trim(), profDetails[2].trim());
            dept.addProfessor(p);
        }

        System.out.println();
        System.out.println(dept);
    }
}
