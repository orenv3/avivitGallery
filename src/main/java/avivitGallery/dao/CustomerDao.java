package avivitGallery.dao;

import java.util.List;
import java.util.Optional;

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

	public <T> void deleteCustomer(T entity ) {
		custRepo.delete((Customer) entity);
	}

	public Optional<Customer> getCustomerByEmail(String email) {
		return custRepo.findById(email);
	}

	public Optional<Customer> getCustomerByName(String name) {
		return Optional.ofNullable(custRepo.findByName(name));
	}

	public List<Customer> getAllCustomers() {
		return (List<Customer>) custRepo.findAll();
	}

}
