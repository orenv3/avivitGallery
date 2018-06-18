/**
 * 
 */
package avivitGallery.facade;

import java.util.List;

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

		Customer customer = new Customer();

		/// =-=-=-=- create customer ==-=-=-= -=-= //
		/////////////////////////////////////////////////////////////////////////////////
		// build customer
		// checked email duplication. do not create if the email exists
		// checked customer null and default new customer()
		// name duplication is allow
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
		// System.out.println("==================new customer ============= ");
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
		// System.out.println("================== name duplication ============= ");
		// customer.setName("custName2");
		// customer.setEmail("update@email");
		// try {
		// custFacade.createCustomer(customer);
		// } catch (Customer_problem | Customer_Not_Exists e) {
		// e.printStackTrace();
		// }

		/// =-=-=-=- update customer ==-=-=-= -=-= //
		/////////////////////////////////////////////////////////////////////////////////
		// checked update customer - regular
		// checked email duplication / null & empty
		// name duplication is allow
		//////////////////////////////////////////////////////////

		customer = new Customer();
		// customer.setName("custNameToUpdate");
		// customer.setEmail("custEmail@gmail2update");
		// customer.setPhone(555555);

		// try {
		// custFacade.createCustomer(customer);
		// } catch (Customer_problem | Customer_Not_Exists e) {
		// e.printStackTrace();
		// }

		// try {
		// customer = custFacade.getCustomerByName("custNameToUpdate");
		// } catch (Customer_problem | Customer_Not_Exists e1) {
		// e1.printStackTrace();
		// }
		// customer.setName("33" + customer.getName());
		// customer.setPhone(5005);
		// try {
		// custFacade.updateCustomer(customer, customer.getEmail());
		// } catch (Customer_problem e) {
		// e.printStackTrace();
		// }

		// customer.setName("test" + customer.getName());
		// try {
		// custFacade.updateCustomer(customer, "custEmail@gmail4update");
		// } catch (Customer_problem e) {
		// e.printStackTrace();
		// }
		// customer = new Customer();
		// customer.setName("custName2");
		// try {
		// custFacade.updateCustomer(customer, "this@update");
		// } catch (Customer_problem e) {
		// e.printStackTrace();
		// }

		// ================ get customers by name ====== / /
		///////////////////////////////////////////////////////////////
		// checked list - regular
		// checked not in the list
		// checked name empty / null
		////////////////////////////////////////////////////

		List<Customer> list = null;
		// try {
		// list = custFacade.getCustomersByName("not in the list");
		// } catch (Customer_problem | Customer_Not_Exists e1) {
		// e1.printStackTrace();
		// }
		// for (Customer cust : list) {
		// System.out.println("==>" + cust);
		// }

		// ================ get customers by email ====== / /
		///////////////////////////////////////////////////////////////
		// checked list - regular ////////////////////////
		// checked not in the list ///////////////////////
		// checked name empty / null//////////////////////
		////////////////////////////////////////////////////

		list = null;
		// try {
		// customer = custFacade.getCustomerByEmail(null); // "" / not in the list /
		// System.out.println(" ==> " + customer);
		// } catch (Customer_problem | Customer_Not_Exists e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// }

		// -=-=-=-=-=-=-=-=- get all customers =-=-=-=-=-
		//
		// try {
		// list = custFacade.getAllCustomers();
		// } catch (Customer_problem e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// }

		// for (Customer cust : list) {
		// System.out.println("==>" + cust);
		// }

		// =-=-=-=-========== delete customer ====== //
		/////////////////////////////////////////////////////////
		// check regular deletion
		// checked customer not exists
		// checked customer null

		// try {
		// customer = custFacade.getCustomerByEmail("update@email");
		// } catch (Customer_problem | Customer_Not_Exists e) {
		// e.printStackTrace();
		// }

		// try {
		// custFacade.deleteCustomer(null);
		// } catch (Customer_problem | Customer_Not_Exists e) {
		// e.printStackTrace();
		// }
	}

}
