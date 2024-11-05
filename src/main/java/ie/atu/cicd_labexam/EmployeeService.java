package ie.atu.cicd_labexam;

import jakarta.validation.Valid;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeService {
    private List<Employee>myList = new ArrayList<>();

    public List<Employee> getEmployee(@PathVariable String employeeCode)
    {
        return myList;
    }

    public List<Employee> addEmployee(@Valid Employee employee) {
        myList.add(employee);
        return myList;
    }

    public List<Employee> updateEmployee(@PathVariable String employeeCode, @RequestBody Employee employee)
    {
        for (Employee e : myList){
            if( e.getEmployeeCode().equals(employeeCode)){
                myList.remove(e);
            }
        }
        myList.add(employee);
        return myList;
    }

    public List<Employee> deleteEmployee(@PathVariable String employeeCode) {
        for (Employee e : myList){
            if( e.getEmployeeCode().equals(employeeCode)){
                myList.remove(e);
            }
        }
        return myList;
    }
}
