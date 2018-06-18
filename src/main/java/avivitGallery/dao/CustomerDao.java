package avivitGallery.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import avivitGallery.tables.Customer;

@Service
public class CustomerDao {

	@Autowired
	private CustomerRepo custRepo;

	/**
	 * create and update method
	 * 
	 * @param image
	 */
	public void saveCustomer(Customer cust) {
		custRepo.save(cust);
	}

	public <T> void deleteCustomer(T entity) {
		custRepo.delete((Customer) entity);
	}

	public Customer getCustomerByEmail(String email) {
		return custRepo.findByEmail(email);
	}

	public List<Customer> getCustomersByName(String name) {
		return custRepo.findByName(name);
	}

	public List<Customer> getAllCustomers() {
		return (List<Customer>) custRepo.findAll();
	}

}
