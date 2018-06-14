package avivitGallery.dao;

import java.util.Calendar;
import java.util.Date;

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
		// for (int i = 8; i <12; i++) {
		// image.setImageUrl("imageURL"+i);
		// image.setName("imageName"+i);
		// image.setType(Type.SPRING);
		// imageDao.saveImage(image);
		// }
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
		// image = imageDao.getImageByUrl("imageURL3");
		// imageDao.deleteImage(image);

		Calendar cal = Calendar.getInstance();
		Date date = cal.getTime();

		// image = new ImageDetail("imageName1", Type.AUTUMN, date, "imageURL1");

		// --=-=-=-=-=-=-=-=- update image details -=-=-=-=- =- =-=-= =-//

		// image = imageDao.getImageByName("imageName1");
		// image.setImageUrl("imageURL1");
		// imageDao.saveImage(image);

		// image = new ImageDetail("imageName2", Type.SPRING, date, "imageURL2");
		// try {
		// imageDao.saveImage(image);
		// } catch (Image_problem e) {
		// e.printStackTrace();
		// }
		// image = new ImageDetail("imageName3", Type.SPRING, date, "imageURL3");
		// try {
		// imageDao.saveImage(image);
		// } catch (Image_problem e) {
		// e.printStackTrace();
		// }
		// image = new ImageDetail("imageName4", Type.AUTUMN, date, "imageURL4");
		// try {
		// imageDao.saveImage(image);
		// } catch (Image_problem e) {
		// e.printStackTrace();
		// }
		//
		// System.out.println("=============== by type ======");
		// try {
		// System.out.println(" spring==> " + imageDao.getImageListByType(Type.SPRING));
		// } catch (Image_Does_Not_Exists e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// }
		// try {
		// System.out.println(" autm==> " + imageDao.getImageListByType(Type.AUTUMN));
		// } catch (Image_Does_Not_Exists e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// }
		// image = new ImageDetail("imageName3", Type.WINTER, date, "imageURL3");
		// image = imageDao.getImageByName("imageName3");
		// image.setImageUrl("imageURL3");
		// imageDao.saveImage(image);

		// ============================ check update ===== //
		// image = imageDao.getImageByName("imageName11");
		// image.setName("this is update image");
		// image.setType(Type.NO_TYPE);
		// System.out.println("===set type var ==> " + image.getType());
		// imageDao.saveImage(image);

		// ============== test list by type and list of all images ======= //

		// System.out.println("============ imageDao.getImageList() ==============");
		// List<ImageDetail> list = imageDao.getImageList();
		// for (ImageDetail img : list) {
		// System.out.println("==> " + img);
		// }

		// System.out.println("============ imageDao.getImageListByType(Type.WINTER)
		// ==============");
		// list = imageDao.getImageListByType(Type.WINTER);
		// for (ImageDetail img : list) {
		// System.out.println("==> " + img);
		// }

	}
}
