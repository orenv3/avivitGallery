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
		
		
		// ============================= create image ===//
		
		ImageDetail image = new ImageDetail();
//		for (int i = 8; i <12; i++) {
//			image.setImageUrl("imageURL"+i);
//			image.setName("imageName"+i);
//			image.setType(Type.SPRING);
//			imageDao.saveImage(image);
//		}
		// ================================ get all images ===////
		
		// System.out.println("================ read all ============");
		// List<ImageDetail> l = imageDao.getImageList();
		// for (ImageDetail img : l) {
		// System.out.println(img);
		// }

		// ===================== checking delete + get by name / by id / by url ====

		// System.out.println("==============get by name==============");
		// image = imageDao.getImageByName("imageName4");
		// System.out.println("==============>" + image);
		// imageDao.deleteImage(image);
		//
		// System.out.println("==============get by id==============");
		// image = imageDao.getImageById(9);
		// System.out.println("==============>" + image);
		// imageDao.deleteImage(image);
		//
		// System.out.println("==============get by url==============");
		// image = imageDao.getImageByUrl("imageURL9");
		// System.out.println("==============>" + image);
		image = imageDao.getImageByUrl("imageName13");
		imageDao.deleteImage(image);

		image.setImageUrl("imageURL1");
		image.setName("imageName1");
		image.setType(Type.AUTUMN);
		imageDao.saveImage(image);

		image.setImageUrl("imageURL2");
		image.setName("imageName2");
		image.setType(Type.WINTER);
		imageDao.saveImage(image);

		image.setImageUrl("imageURL3");
		image.setName("imageName3");
		image.setType(Type.WINTER);
		imageDao.saveImage(image);

		// ============================ check update ===== //
		// image = imageDao.getImageByName("imageName11");
		// image.setName("this is update image");
		// image.setType(Type.NO_TYPE);
		// System.out.println("===set type var ==> " + image.getType());
		// imageDao.saveImage(image);


				}
}
