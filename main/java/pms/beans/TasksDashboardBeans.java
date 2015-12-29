package pms.beans;

import pms.models.Task;
import pms.services.TaskService;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import java.io.Serializable;
import java.util.List;

@ViewScoped
@ManagedBean
public class TasksDashboardBeans implements Serializable {

    private List<Task> tasksOfCurrentProject;

    @EJB
    TaskService taskService;

    @PostConstruct
    public void doInit(){
        tasksOfCurrentProject = taskService.getAllTasksFromCurrentProject(retreiveTaskIdFromExternalContext());
    }

    private Long retreiveTaskIdFromExternalContext() {
        ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
        return Long.valueOf(externalContext.getRequestParameterMap().get("projectId"));
    }

    public void deleteTask(Task task){
        taskService.delete(task);
    }

    public List<Task> getTasksOfCurrentProject() {
        return tasksOfCurrentProject;
    }

    public void setTasksOfCurrentProject(List<Task> tasksOfCurrentProject) {
        this.tasksOfCurrentProject = tasksOfCurrentProject;
    }
}
