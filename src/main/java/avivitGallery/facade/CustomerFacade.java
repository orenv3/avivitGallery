package avivitGallery.facade;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import avivitGallery.dao.CustomerDao;

@Component
public class CustomerFacade {

	@Autowired
	CustomerDao cust;

}
