package pms.beans;

import pms.services.TaskService;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import java.io.Serializable;


@ViewScoped
@ManagedBean
public class CreateTaskBean implements Serializable {

    private String taskTitle;
    private String taskDescription;

    @EJB
    TaskService taskService;

    public String createTask(){
        Long projectId = Long.valueOf(FacesContext.getCurrentInstance()
                .getExternalContext()
                .getRequestParameterMap().get("projectId"));
        taskService.createTask(taskTitle,taskDescription,projectId);
        return "/pages/tasks_dashboard.xhtml";
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
}
