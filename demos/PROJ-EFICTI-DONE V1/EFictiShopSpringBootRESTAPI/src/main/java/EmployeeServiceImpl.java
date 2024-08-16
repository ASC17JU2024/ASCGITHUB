import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl {
	// Dependency Injection (spring framework creates the Repository internally and injects the instance into your app
		@Autowired
		private EmployeeRepository employeeRepository;
}
