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

@ViewScoped
@ManagedBean
public class EditTaskBean implements Serializable {

    private Task task;

    @EJB
    TaskService taskService;

    @PostConstruct
    public void doInit(){
        task = taskService.read(retreiveTaskIdFromExternalContext());
    }

    private Long retreiveTaskIdFromExternalContext() {
        ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
        return Long.valueOf(externalContext.getRequestParameterMap().get("taskId"));
    }

    public Task getTask() {
        return task;
    }

    public void setTask(Task task) {
        this.task = task;
    }
}
