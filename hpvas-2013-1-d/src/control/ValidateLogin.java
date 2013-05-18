package control;

import dao.EmployeeDao;
import entity.Employee;
 

public class ValidateLogin {
    private EmployeeDao eD=new EmployeeDao();
    public ValidateLogin () {
    }

    public boolean CheckLogin (Employee employee) {
        Employee e = eD.read(employee);
        if(employee.getLogin().equals(e.getLogin())
                && employee.getPassword().equals(e.getPassword()))
            return true;
        return false;
    }
}