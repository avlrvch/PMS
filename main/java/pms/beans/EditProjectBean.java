package pms.beans;

import pms.models.Project;
import pms.services.ProjectService;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import java.io.Serializable;

@ViewScoped
@ManagedBean
public class EditProjectBean implements Serializable {

    private Project project;

    @EJB
    ProjectService projectService;


    @PostConstruct
    public void doInit(){
        project = projectService.read(retreiveProjectIdFromExternalContext());
    }

    public String editProject(){
        projectService.update(project);
        return "/pages/projects_dashboard.xhtml";
    }

    private Long retreiveProjectIdFromExternalContext() {
        ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
        return Long.valueOf(externalContext.getRequestParameterMap().get("projectId"));
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }
}
