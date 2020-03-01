package tlp.javatraining.employeeservices.commonmodel;

public class Allocation {
    private Integer id;
    private Integer empId;
    private String start;
    private String end;
    private String projectCode;

    public Allocation() {
    }

    public Allocation(Integer id, Integer empId, String start, String end, String projectCode) {
        this.id = id;
        this.empId = empId;
        this.start = start;
        this.end = end;
        this.projectCode = projectCode;
    }

    public Integer getEmpId() {
        return empId;
    }

    public void setEmpId(Integer empId) {
        this.empId = empId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public String getEnd() {
        return end;
    }

    public void setEnd(String end) {
        this.end = end;
    }

    public String getProjectCode() {
        return projectCode;
    }

    public void setProjectCode(String projectCode) {
        this.projectCode = projectCode;
    }
}
