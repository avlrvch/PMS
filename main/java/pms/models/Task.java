package pms.models;

import javax.persistence.*;

@Entity
@Table(name = "tasks")
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "task_title")
    private String taskTitle;

    @Column(name = "task_description")
    private String taskDescription;

    @Column(name = "task_status")
    private TaskStatus taskStatus;

    @ManyToOne
    @JoinColumn(name = "projects_id")
    private Project project;

    @OneToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;

    public enum TaskStatus {
        NEW,IN_PROGRESS,DONE;
    }

    public Task() {
        taskStatus = TaskStatus.NEW;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTaskTitle() {
        return taskTitle;
    }

    public void setTaskTitle(String taskTitle) {
        this.taskTitle = taskTitle;
    }

    public String getTaskDescription() {
        return taskDescription;
    }

    public void setTaskDescription(String taskDescription) {
        this.taskDescription = taskDescription;
    }

    public TaskStatus getTaskStatus() {
        return taskStatus;
    }

    public void setTaskStatus(TaskStatus taskStatus) {
        this.taskStatus = taskStatus;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Task task = (Task) o;

        if (id != null ? !id.equals(task.id) : task.id != null) return false;
        if (taskTitle != null ? !taskTitle.equals(task.taskTitle) : task.taskTitle != null) return false;
        if (taskDescription != null ? !taskDescription.equals(task.taskDescription) : task.taskDescription != null)
            return false;
        if (taskStatus != task.taskStatus) return false;
        if (project != null ? !project.equals(task.project) : task.project != null) return false;
        return !(employee != null ? !employee.equals(task.employee) : task.employee != null);

    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (taskTitle != null ? taskTitle.hashCode() : 0);
        result = 31 * result + (taskDescription != null ? taskDescription.hashCode() : 0);
        result = 31 * result + (taskStatus != null ? taskStatus.hashCode() : 0);
        result = 31 * result + (project != null ? project.hashCode() : 0);
        result = 31 * result + (employee != null ? employee.hashCode() : 0);
        return result;
    }
}
