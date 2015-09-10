package employee;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.cassandra.core.CassandraOperations;

public class EmployeeContext {

    private static EmployeeContext instance = null;
    private ApplicationContext context = null;
    private CassandraOperations cassandraOps = null;
    
    private static Object mutex= new Object();

    private EmployeeContext() {
    	setContext(new ClassPathXmlApplicationContext("applicationContext.xml"));
    	setCassandraOps((CassandraOperations) getContext().getBean("cqlTemplate"));    	
    }
 
    public static EmployeeContext getInstance(){
        if(instance==null){
            synchronized (mutex){
                if(instance==null) instance= new EmployeeContext();
            }
        }
        return instance;
    }

	public ApplicationContext getContext() {
		return context;
	}

	public void setContext(ApplicationContext context) {
		this.context = context;
	}

	public CassandraOperations getCassandraOps() {
		return cassandraOps;
	}

	public void setCassandraOps(CassandraOperations cassandraOps) {
		this.cassandraOps = cassandraOps;
	}
}
