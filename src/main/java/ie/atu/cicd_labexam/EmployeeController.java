package ie.atu.cicd_labexam;

import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
    private List<Employee>list=new ArrayList<>();
    private EmployeeService myService;

    public EmployeeController(EmployeeService myService) {
        this.myService = myService;
    }

    @PostMapping("/addEmployee")
    public List<Employee>newEmployee(@Valid @RequestBody Employee employee)
    {
        list = myService.addEmployee(employee);
        return list;
    }

    @GetMapping("/{employeeCode}")
    public List<Employee> getEmployee(@PathVariable String employeeCode)
    {
        list=myService.getEmployee(employeeCode);
        return list;

    }

    @PutMapping("/{employeeCode}")
    public List<Employee> updateEmployee(@PathVariable String employeeCode, @RequestBody Employee employee)
    {
        list=myService.updateEmployee(employeeCode,employee);
        return list;
    }

    @DeleteMapping("/{employeeCode}")
    public  List<Employee>deleteEmployee(@PathVariable String employeeCode)
    {
        list=myService.deleteEmployee(employeeCode);
        return list;
    }


}
