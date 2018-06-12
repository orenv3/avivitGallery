package avivitGallery.dao;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

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
		
		
		// ============================= create image ===//
		
		ImageDetail image = new ImageDetail();
//		for (int i = 8; i <12; i++) {
//			image.setImageUrl("imageURL"+i);
//			image.setName("imageName"+i);
//			image.setType(Type.SPRING);
//			imageDao.saveImage(image);
//		}
		// ================================ get all images ===////
		
		System.out.println("================ read all ============");
		List<ImageDetail> l = imageDao.getImageList();
		for (ImageDetail img : l) {
			System.out.println(img);
		}
		
		
	}
}
