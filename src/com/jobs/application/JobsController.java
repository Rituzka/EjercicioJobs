package com.jobs.application;


import com.jobs.domain.AbsStaffMember;
import com.jobs.domain.Employee;
import com.jobs.domain.Volunteer;
import com.jobs.persistence.EmployeeRepository;

public class JobsController {

	private EmployeeRepository repository = new EmployeeRepository();

	
	
    public JobsController(){
		
	}
	
	public void createBossEmployee(String name, String address, String phone, double salaryPerMonth) throws Exception{		
		Employee boss = new Employee(name, address, phone,  salaryPerMonth, PaymentFactory.createPaymentRateBoss());
		boss.setTotalPaid(PaymentFactory.createPaymentRateBoss().pay(salaryPerMonth));
		repository.addMember(boss);
	
		
	}
	
	public void createEmployee(String name, String address, String phone, double salaryPerMonth) throws Exception{		
		Employee employee = new Employee(name, address, phone,  salaryPerMonth, PaymentFactory.createPaymentRateEmployee());
		employee.setTotalPaid(PaymentFactory.createPaymentRateEmployee().pay(salaryPerMonth));
		repository.addMember(employee);
	}

	public void createManagerEmployee(String name, String address, String phone, double salaryPerMonth) throws Exception{
		Employee manager = new Employee(name, address, phone,  salaryPerMonth, PaymentFactory.createPaymentRateManager());
		manager.setTotalPaid(PaymentFactory.createPaymentRateManager().pay(salaryPerMonth));
		repository.addMember(manager);
		
	}


	public void payAllEmployeers() {
		for(AbsStaffMember emp: repository.getAllMembers()) {
		 emp.getTotalPaid();
		}
	
	}

	public String getAllEmployees() {
		String allEmployees = "";
		for (AbsStaffMember emp: repository.getAllMembers()) {
		allEmployees = "Nombre: "+ emp.getName() +", Dirección: "+emp.getAddress()+", Teléfono: "+emp.getPhone()+", Salario: "+emp.getTotalPaid();
		
		System.out.println(allEmployees);
		}
		return allEmployees;
	}

	public void createVolunteer(String name, String adress, String phone, String description) throws Exception {
		AbsStaffMember volunteer = new Volunteer(name, adress, phone, description);
		repository.addMember(volunteer);
		
	}
	
	
	
}
