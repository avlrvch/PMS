package pms.models;
import javax.persistence.*;

@Entity
@Table(name = "employees")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    private String surname;

    @Column(name = "eMail")
    private String eMail;

    @Column(name = "position")
    @Enumerated(EnumType.ORDINAL)
    private EmployeePosition employeePosition;

    @OneToOne(mappedBy = "employee", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Task task;

    @OneToOne(mappedBy = "projectLead",cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private Project project;

    public enum EmployeePosition {
        MANAGER,DEVELOPER;
    }

    public Employee() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String geteMail() {
        return eMail;
    }

    public void seteMail(String eMail) {
        this.eMail = eMail;
    }

    public EmployeePosition getEmployeePosition() {
        return employeePosition;
    }

    public void setEmployeePosition(EmployeePosition employeePosition) {
        this.employeePosition = employeePosition;
    }

    public Task getTask() {
        return task;
    }

    public void setTask(Task task) {
        this.task = task;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Employee employee = (Employee) o;

        if (id != null ? !id.equals(employee.id) : employee.id != null) return false;
        if (name != null ? !name.equals(employee.name) : employee.name != null) return false;
        if (surname != null ? !surname.equals(employee.surname) : employee.surname != null) return false;
        if (eMail != null ? !eMail.equals(employee.eMail) : employee.eMail != null) return false;
        if (employeePosition != employee.employeePosition) return false;
        if (task != null ? !task.equals(employee.task) : employee.task != null) return false;
        return !(project != null ? !project.equals(employee.project) : employee.project != null);

    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (surname != null ? surname.hashCode() : 0);
        result = 31 * result + (eMail != null ? eMail.hashCode() : 0);
        result = 31 * result + (employeePosition != null ? employeePosition.hashCode() : 0);
        result = 31 * result + (task != null ? task.hashCode() : 0);
        result = 31 * result + (project != null ? project.hashCode() : 0);
        return result;
    }
}
