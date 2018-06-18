/**
 * 
 */
package avivitGallery.facade;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import avivitGallery.tables.Customer;

/**
 * @author Vinogura Oren
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class CustomerFacadeTest {

	@Autowired
	CustomerFacade custFacade;

	@Test
	public void contextLoads() {
	}

	@Test
	public void testFacade() {

		Customer customer = null;

		/// =-=-=-=- create customer ==-=-=-= -=-= //
		/////////////////////////////////////////////////////////////////////////////////
		// build customer
		// checked email duplication. do not create if the email exists
		// checked customer null and default new customer()
		//////////////////////////////////////////////////////////////////////////////////////////

		//
		// for (int i = 4; i < 5; i++) {
		// customer = new Customer();
		// customer.setName("custName" + i);
		// customer.setEmail("custEmail@gmail" + i);
		// customer.setPhone(50000 + i);
		// try {
		// } catch (Customer_problem | Customer_Not_Exists e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// }
		// System.out.println("==================new custommre ============= ");
		// customer = new Customer();
		// try {
		// custFacade.createCustomer(customer);
		// } catch (Customer_problem | Customer_Not_Exists e1) {
		// // TODO Auto-generated catch block
		// e1.printStackTrace();
		// }
		//
		// System.out.println("================== null custommre ============= ");
		// customer = null;
		// try {
		// custFacade.createCustomer(customer);
		// } catch (Customer_problem | Customer_Not_Exists e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// }
	}

}
