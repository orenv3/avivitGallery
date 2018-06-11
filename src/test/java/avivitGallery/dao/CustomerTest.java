package avivitGallery.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import avivitGallery.tables.Customer;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CustomerTest {

	@Autowired
	private CustomerDao custDao;// = new CustomerDao();

	@Test
	public void contextLoads() {
	}

	@Test
	public void customerDao() {

		// ============ create customer ====================//
		Customer c = new Customer();
		c.setName("image1");
		c.setEmail("imag@email");
		c.setPhone(254545);
		custDao.saveCustomer(c);

		// ================ read customer ===========///
		// System.out.println("============ just cust ============");
		// System.out.println("customer c==> " + c);
		Customer nis = custDao.getCustomerByEmail("imag@email").get();
		System.out.println("============ get cust by email============");
		System.out.println("customer nis==> " + nis);
		Customer nisg = custDao.getCustomerByName("image1").get();
		System.out.println("============ get cust by name============");
		System.out.println("customer nis==> " + nisg);

		// ========== update with save. ===========//
		// nisg.setEmail("saveUpdate@email");

		nisg.setName("saveUpdate");
		System.out.println("customer nis==> " + nisg);
		custDao.saveCustomer(nisg);
	}
}
