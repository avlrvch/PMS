package pms.beans;

import pms.models.Project;
import pms.services.ProjectService;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import java.io.Serializable;
import java.util.List;

/*
This bean would write all projects from database after his creation
into List of projects that allows to output them in datatable on projects_dashboard.xhtml
 */

@ViewScoped
@ManagedBean
public class ProjectsDashboardBean implements Serializable {

    private List<Project> projects;

    @EJB
    ProjectService projectService;

    @PostConstruct
    public void doInit(){
        projects = projectService.getAll();
    }

    public String deleteProject(Project project){
        projectService.delete(project);
        projects.remove(project);
        return null;
    }

    public List<Project> getProjects() {
        return projects;
    }

    public void setProjects(List<Project> projects) {
        this.projects = projects;
    }

}
