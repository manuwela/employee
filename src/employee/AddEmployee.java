package employee;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AddEmployee {
	  
	public static void main(String[] args) {  
	      
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
						
		EmployeeDao dao=(EmployeeDao)context.getBean("d");  
	  
	    Employee e=new Employee();  
	    e.setFirstName("A");
	    e.setLastName("B");
	    e.setSalary(50000);  
	      
	    dao.saveEmployee(e);  
	      
	}  
}
