package JavaStreamAPI;

import java.util.Objects;

public class Employee {
    private int empId;
    private String empName;
    private int deptId;
    private String status="active";
    private int salary;

    public int getEmpId() {
        return empId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Employee employee)) return false;
        return getEmpId() == employee.getEmpId() && getDeptId() == employee.getDeptId() && getSalary() == employee.getSalary() && Objects.equals(getEmpName(), employee.getEmpName()) && Objects.equals(getStatus(), employee.getStatus());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getEmpId(), getEmpName(), getDeptId(), getStatus(), getSalary());
    }

    public void setEmpId(int empId) {
        this.empId = empId;
    }

    public String getEmpName() {
        return empName;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "empId=" + empId +
                ", empName='" + empName + '\'' +
                ", deptId=" + deptId +
                ", status='" + status + '\'' +
                ", salary=" + salary +
                '}';
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public int getDeptId() {
        return deptId;
    }

    public void setDeptId(int deptId) {
        this.deptId = deptId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public Employee(int empId, String empName, int deptId, String status, int salary) {
        super();
        this.empId = empId;
        this.empName = empName;
        this.deptId = deptId;
        this.status = status;
        this.salary = salary;
    }
}
