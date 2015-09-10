package employee;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {

    ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
	
	EmployeeDao dao=(EmployeeDao)context.getBean("d");  
    
	@RequestMapping("/addEmployee")
    public void addEmployee(@RequestParam(value="firstname", defaultValue="") String firstname,
    						@RequestParam(value="lastname", defaultValue="") String lastname,
    						@RequestParam(value="id") int id) {
        Employee e=new Employee();  
        e.setFirstName("A");
        e.setLastName("B");
        e.setSalary(50000);  
          
        dao.saveEmployee(e);          
    }
	
	@RequestMapping("/deleteEmployee")
    public void deleteEmployee(@RequestParam(value="id") int id) {
        Employee e = dao.getById(id);
        dao.deleteEmployee(e);
	}
	
	@RequestMapping("/listEmployees")
    public List<Employee> listEmployees() {
        List<Employee> list = dao.getEmployees();
        return list;
	}
	
	@RequestMapping("/deleteEmployee")
    public void updateEmployee(@RequestParam(value="id") int id,
    						   @RequestParam(value="salary") int salary) {
        Employee e = dao.getById(id);
        e.setSalary(salary);
        dao.updateEmployee(e);
	}
}