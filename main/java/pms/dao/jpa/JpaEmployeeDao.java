package pms.dao.jpa;

import pms.dao.EmployeeDao;
import pms.models.Employee;

import javax.ejb.Stateless;

@Stateless
public class JpaEmployeeDao extends JpaGenericDao<Employee> implements EmployeeDao {

}
