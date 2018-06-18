package avivitGallery.facade;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import avivitGallery.dao.CustomerDao;
import avivitGallery.exceptions.Customer_Not_Exists;
import avivitGallery.exceptions.Customer_problem;
import avivitGallery.tables.Customer;

@Component
public class CustomerFacade {

	private final String UPDATE = "UPDATE", GET = "GET", CREATE = "CREATE";
	@Autowired
	CustomerDao custDao;

	public void createCustomer(Customer customer) throws Customer_problem, Customer_Not_Exists {
		if (this.isNotProblematic(customer, UPDATE))
			if (this.isPresent(customer, CREATE))
				custDao.saveCustomer(customer);
	}

	public void deleteCustomer(Customer customer) throws Customer_problem, Customer_Not_Exists {
		if (this.isNotProblematic(customer, GET))
			if (this.isPresent(customer, GET))
				custDao.deleteCustomer(customer);
	}

	public void updateCustomer(Customer customer, String newEmail) throws Customer_problem {
		if (newEmail == null || newEmail.isEmpty())
			throw new Customer_problem("The email must not be empty or null.");

		Optional<Customer> presentByEmail = Optional.ofNullable(custDao.getCustomerByEmail(newEmail));

		if (this.isNotProblematic(customer, UPDATE)) {
			if (presentByEmail.isPresent() && !(customer.getEmail().equals(newEmail)))
				throw new Customer_problem("The image email already exists.");
		}

		custDao.saveCustomer(customer);
	}

	public Customer getCustomerByEmail(String email) throws Customer_problem, Customer_Not_Exists {
		if (email == null || email.isEmpty())
			throw new Customer_problem("The email field must not be empty or null.");
		Customer customer = custDao.getCustomerByEmail(email);

		if (this.isNotProblematic(customer, GET))
			if (this.isPresent(customer, GET))
				return customer;
		return null; // not suppose to reach this line.
	}

	public List<Customer> getCustomersByName(String name) throws Customer_problem, Customer_Not_Exists {
		if (name == null || name.isEmpty())
			throw new Customer_problem("The name field must not be empty or null.");
		Optional<List<Customer>> customerList = Optional.ofNullable(custDao.getCustomersByName(name));
		if (customerList.isPresent())
			if (customerList.get().size() > 0)
				return customerList.get();
		throw new Customer_problem("There are no customers to present via this name: " + name);
	}

	public List<Customer> getAllCustomers() throws Customer_problem {
		Optional<List<Customer>> list = Optional.ofNullable(custDao.getAllCustomers());
		if (list.isPresent())
			if (list.get().size() > 0)
				return list.get();
		throw new Customer_problem("There are no customers to present.");
	}

	// ====== private ====//
	/**
	 * 
	 * @param cust
	 * @param method
	 *            have to be Either UPDATE or GET. "this method is either for create
	 *            and delete"
	 * @return
	 * @throws Customer_problem
	 */
	private boolean isNotProblematic(Customer cust, String method) throws Customer_problem {
		switch (method) {
		case UPDATE:
			if (cust == null || cust.getEmail() == null) {
				throw new Customer_problem("Either the Customer is null or email field is null");
			} else if (cust.getEmail().isEmpty()) {
				throw new Customer_problem("The name field is empty");
			}
			break;
		case GET:
			if (cust == null) {
				throw new Customer_problem(
						"The following Customer dose not exists in the system. recheck the email parameter.");
			}
			break;

		default:
			break;
		}

		return true;
	}

	/**
	 * checks if the customer exists via email check. The method checks it for all
	 * relevant method(get, create etc.
	 * 
	 * @param cust
	 * @param method
	 *            have to be GET OR CREATE - those are types of checks
	 * @return
	 * @throws Customer_Not_Exists
	 * @throws Customer_problem
	 */
	private boolean isPresent(Customer cust, String method) throws Customer_Not_Exists, Customer_problem {

		Optional<Customer> presentByEmail = Optional.ofNullable(custDao.getCustomerByEmail(cust.getEmail()));

		switch (method) {
		case CREATE:
			if (presentByEmail.isPresent())
				throw new Customer_problem("The customer already exists(checked by email). No need to add it. ");
			break;

		case GET:
			if (!(presentByEmail.isPresent()))
				throw new Customer_Not_Exists(
						"The following customer does not exists. please recheck the email or name parameters.");
			break;

		}

		return true;
	}
}
