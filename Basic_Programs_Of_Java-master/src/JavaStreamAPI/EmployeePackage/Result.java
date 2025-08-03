package JavaStreamAPI.EmployeePackage;

public class Result {
    private int empId;
    private int empMarks;

    public Result(int empId, int empMarks) {
        this.empId = empId;
        this.empMarks = empMarks;
    }

    @Override
    public String toString() {
        return "Result{" +
                "empId=" + empId +
                ", empMarks=" + empMarks +
                '}';
    }
}
