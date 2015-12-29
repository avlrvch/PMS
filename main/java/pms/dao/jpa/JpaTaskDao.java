package pms.dao.jpa;

import pms.dao.TaskDao;
import pms.models.Task;

import javax.ejb.Stateless;
import java.util.List;

@Stateless
public class JpaTaskDao extends JpaGenericDao<Task> implements TaskDao {

    private static final String READ_ALL_QUERY_PATTERN_FROM_CURRENT_PROJECT =
            "SELECT e FROM %s e WHERE project_id = %s";

    @Override
    public List<Task> getAllTasksFromCurrentProject(Long projectId) {
        String query = String.format(READ_ALL_QUERY_PATTERN_FROM_CURRENT_PROJECT, Task.class.getSimpleName(), projectId);
        return em.createQuery(query)
                .getResultList();
    }
}
