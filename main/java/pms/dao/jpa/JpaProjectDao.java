package pms.dao.jpa;


import pms.dao.ProjectDao;
import pms.models.Project;

import javax.ejb.Stateless;

@Stateless
public class JpaProjectDao extends JpaGenericDao<Project> implements ProjectDao {

}

