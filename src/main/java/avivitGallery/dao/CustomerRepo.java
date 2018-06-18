package avivitGallery.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import avivitGallery.tables.Customer;

@Repository
public interface CustomerRepo extends CrudRepository<Customer, String> {

	List<Customer> findByName(String name);

	Customer findByEmail(String email);
}
