package avivitGallery.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import avivitGallery.Type;
import avivitGallery.tables.ImageDetail;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ImageTest {

	@Autowired
	ImageDao imageDao;
	
	@Test
	public void contextLoads() {
	}
	
	@Test
	public void ImageDaoTest() {
		
		
		//==== create image ===//
		ImageDetail image = new ImageDetail();
		for (int i = 0; i <5; i++) {
			image.setImageUrl("imageURL"+i);
			image.setName("imageName"+i);
			image.setType(Type.SPRING);
			
		}
		System.out.println("================ read all ============");
	}
}
