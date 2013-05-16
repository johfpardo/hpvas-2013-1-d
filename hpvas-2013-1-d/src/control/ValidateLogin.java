package control;

import dao.EmployeeDao;
import entity.Employee;
 

// <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
// #[regen=yes,id=DCE.D42D42A5-512A-C868-B654-32627A3A22E4]
// </editor-fold> 
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