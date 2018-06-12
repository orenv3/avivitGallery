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
	private CustomerDao custDao;

	@Test
	public void contextLoads() {
	}

	@Test
	public void customerDao() {

		// ============ create customer ====================//
		Customer c = new Customer();
//		c.setName("image1");
//		c.setEmail("imag@email");
//		c.setPhone(254545);
//		custDao.saveCustomer(c);

		// ================ get customer by email and by name ===========///
//		Customer nis = custDao.getCustomerByEmail("imag@email").get();
//		System.out.println("============ get cust by email============");
//		System.out.println("customer nis==> " + nis);
//		Customer nisg = custDao.getCustomerByName("image1").get();
//		System.out.println("============ get cust by name============");
//		System.out.println("customer nisg==> " + nisg);

		// ========== update with save. ===========//
		// nisg.setEmail("saveUpdate@email");

//		nisg.setName("saveUpdate");
//		System.out.println("customer nisg with update==> " + nisg);
//		custDao.saveCustomer(nisg);
		
			c= custDao.getCustomerByName("customer3").get();
					custDao.deleteCustomer(c);
		for (int i = 1; i < 4; i++) {
			c.setName("customer"+i);
			c.setEmail("customer@email"+i);
			c.setPhone(254545+i);
			
			custDao.saveCustomer(c);
		}
		
		System.out.println("============ getAllCustomers ============");
		
		System.out.println(custDao.getAllCustomers());
		
		// ================= delete customer =============// 
		
//		for (int i = 1; i <= 3; i++) {
//			c= custDao.getCustomerByName("customer"+i).get();
//					custDao.deleteCustomer(c);
//		}
	}
}
