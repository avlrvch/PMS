package pms.dao;


import pms.models.Task;

import java.util.List;

public interface TaskDao extends GenericDao<Task> {
    List<Task> getAllTasksFromCurrentProject(Long projectId);
}
