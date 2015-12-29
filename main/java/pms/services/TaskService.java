package pms.services;

import pms.dao.TaskDao;
import pms.models.Employee;
import pms.models.Task;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import java.util.List;

@Stateless
public class TaskService {

    @EJB
    TaskDao taskDao;

    @EJB
    ProjectService projectDao;


    public void createTask(String title, String description, Long project_Id){
        Task task = new Task();
        task.setTaskTitle(title);
        task.setTaskDescription(description);
        task.setProject(projectDao.read(project_Id));
        taskDao.create(task);
    }

    public Task read(Long id) {
        return taskDao.read(id);
    }

    public void update(Task task) {
        taskDao.update(task);
    }

    public void delete(Task task) {
        taskDao.delete(task);
    }

    public List<Task> getAll() {
        return taskDao.getAll();
    }

    public void assignTask(Task task,Employee employee) {
        task.setEmployee(employee);
        task.setTaskStatus(Task.TaskStatus.IN_PROGRESS);
        update(task);
    }

    public List<Task> getProjectTasks(Long projectId) {
        List<Task> tasks = getAll();
        for (Task task:getAll()){
            if (!task.getProject().getId().equals(projectId)) tasks.remove(task);
        }
        return tasks;
    }
    public List<Task> getAllTasksFromCurrentProject(Long projectId) {
        return taskDao.getAllTasksFromCurrentProject(projectId);
    }
}
