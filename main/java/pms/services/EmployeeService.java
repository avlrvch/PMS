package pms.services;

import pms.dao.EmployeeDao;
import pms.models.Employee;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import java.util.List;

@Stateless
public class EmployeeService {

    @EJB
    EmployeeDao employeeDao;

    public void createEmployee(String name, String surname, String eMail,
                               Employee.EmployeePosition employeePosition){

        Employee employee = new Employee();
        employee.setName(name);
        employee.setSurname(surname);
        employee.seteMail(eMail);
        employee.setEmployeePosition(employeePosition);
        employeeDao.create(employee);
    }

    public Employee read(Long id){
        return employeeDao.read(id);
    }

    public void delete(Employee employee){
        employeeDao.delete(employee);
    }
    public List<Employee> getAllEmployees(){
        return employeeDao.getAll();
    }
}
