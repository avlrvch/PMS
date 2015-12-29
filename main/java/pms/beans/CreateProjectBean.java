package pms.beans;

import pms.services.ProjectService;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import java.io.Serializable;

@ViewScoped
@ManagedBean
public class CreateProjectBean implements Serializable {

    private String projectTitle;
    private String projectDescription;

    @EJB
    ProjectService projectService;

    public String createProject() {
        projectService.create(projectTitle, projectDescription);
        return "/pages/projects_dashboard.xhtml";
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
}
