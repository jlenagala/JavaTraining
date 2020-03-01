package tlp.javatraining.employeeservices.model;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import tlp.javatraining.employeeservices.commonmodel.Allocation;

import javax.persistence.*;
import java.util.List;

@Entity(name = "employee")
public class Employee {


    //fetch = FetchType.EAGER-----> get all the field of data and fetch relevent data only

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String city;
    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    List<Telephone> telephones;

    @OneToOne(cascade = CascadeType.ALL)
    Address addresses;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "employee_project", joinColumns = {
            @JoinColumn(name = "eid", referencedColumnName = "id")}, inverseJoinColumns = {
            @JoinColumn(name = "pid", referencedColumnName = "id")})
    @Fetch(value = FetchMode.SUBSELECT)
    public List<Project> projects;
    Allocation[] allocations;

    public Employee() {
    }

    public Allocation[] getAllocations() {
        return allocations;
    }

    public void setAllocations(Allocation[] allocations) {
        this.allocations = allocations;
    }

    public Employee(Allocation[] allocations) {
        this.allocations = allocations;
    }

    public List<Project> getProjects() {
        return projects;
    }

    public void setProjects(List<Project> projects) {
        this.projects = projects;
    }

    public List<Telephone> getTelephones() {
        return telephones;
    }

    public void setTelephones(List<Telephone> telephones) {
        this.telephones = telephones;
    }

    public Address getAddresses() {
        return addresses;
    }

    public void setAddresses(Address addresses) {
        this.addresses = addresses;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}