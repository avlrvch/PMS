package pms.models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "projects")
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "project_title")
    private String projectTitle;

    @Column(name = "project_description")
    private String projectDescription;

    @OneToMany(mappedBy = "project", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Task> tasks;

    @OneToOne
    @JoinColumn(name = "employee_id")
    private Employee projectLead;

    public Project() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProjectTitle() {
        return projectTitle;
    }

    public void setProjectTitle(String projectTitle) {
        this.projectTitle = projectTitle;
    }

    public String getProjectDescription() {
        return projectDescription;
    }

    public void setProjectDescription(String projectDescription) {
        this.projectDescription = projectDescription;
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }

    public Employee getProjectLead() {
        return projectLead;
    }

    public void setProjectLead(Employee projectLead) {
        this.projectLead = projectLead;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Project project = (Project) o;

        if (id != null ? !id.equals(project.id) : project.id != null) return false;
        if (projectTitle != null ? !projectTitle.equals(project.projectTitle) : project.projectTitle != null)
            return false;
        if (projectDescription != null ? !projectDescription.equals(project.projectDescription) : project.projectDescription != null)
            return false;
        if (tasks != null ? !tasks.equals(project.tasks) : project.tasks != null) return false;
        if (projectLead != null ? !projectLead.equals(project.projectLead) : project.projectLead != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (projectTitle != null ? projectTitle.hashCode() : 0);
        result = 31 * result + (projectDescription != null ? projectDescription.hashCode() : 0);
        result = 31 * result + (tasks != null ? tasks.hashCode() : 0);
        result = 31 * result + (projectLead != null ? projectLead.hashCode() : 0);
        return result;
    }
}
