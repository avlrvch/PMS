package pms.services;

import pms.dao.ProjectDao;
import pms.models.Project;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import java.util.List;

@Stateless
public class ProjectService {

    @EJB
    ProjectDao projectDao;

    public void create(String projectTitle, String projectDescription) {
        Project project = new Project();
        project.setProjectTitle(projectTitle);
        project.setProjectDescription(projectDescription);
        projectDao.create(project);
    }

    public Project read(Long id) {
        return projectDao.read(id);
    }

    public void update(Project project) {
        projectDao.update(project);
    }

    public void delete(Project project) {
        projectDao.delete(project);
    }

    public List<Project> getAll() {
        return projectDao.getAll();
    }
}
