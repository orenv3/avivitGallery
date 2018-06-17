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

import avivitGallery.tables.ImageDetail;

/**
 * @author Vinogura Oren
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class imageFacadeTest {

	@Autowired
	ImageFacade imageFacade;

	@Test
	public void contextLoads() {
	}

	/**
	 * @throws java.lang.Exception
	 */
	// @BeforeClass
	// public static void setUpBeforeClass() throws Exception {
	// System.out.println("//=>>=>>=>>=>>==== test starts
	// ===>>=>>=.>>=>>=>>=>>=.>>===//");
	// }

	/**
	 * @throws java.lang.Exception
	 */
	// @AfterClass
	// public static void tearDownAfterClass() throws Exception {
	// System.out.println("//=>>=>>=>>=>>==== test ends
	// ===>>=>>=.>>=>>=>>=>>=.>>===//");
	// }

	@Test
	public void testFacade() {

		/// =====-=-=-=-=-= create image and exceptions ==== =-=-=-=//
		// created successfully
		// checked name or url null
		// checked name or url duplication
		// checked image null

		// for (int i = 5; i <= 6; i++) {
		// ImageDetail image = new ImageDetail();
		// image.setImageUrl("imageURL" + i);
		// image.setName("imageName" + i);
		// image.setType(Type.SUMMERTIME);
		// image.setDateCreated(new Date());
		// try {
		// imageFacade.createImage(image);
		// } catch (Image_problem | Image_exists | Image_Does_Not_Exists e) {
		// e.printStackTrace();
		// }
		// }
		ImageDetail image = new ImageDetail();
		// image.setImageUrl("imageURL2");
		// image.setName("imageName22222");
		// try {
		// imageFacade.createImage(image);
		// } catch (Image_problem | Image_exists | Image_Does_Not_Exists e) {
		// e.printStackTrace();
		// }

		// ==- =- =- =- =- = get by id =-=-=-= = =-= //
		// work good with id
		// checked with bigger id

		// System.out.println("=================test update and get by
		// id===============");
		// = -= -= -= -= -= -== get by ID =- =- =- =- = =- =- = -= =- //
		// checked id not in DB
		// image = new ImageDetail();
		// try {
		// image = imageFacade.getImageById(53);
		// } catch (Image_Does_Not_Exists | Image_problem | Image_exists e) {
		// e.printStackTrace();
		// }

		// ======-=-=-=-=- update =-=-==-=-=-=-=- // /
		// checked duplication name and URL
		// checked empty and null
		//
		//
		// System.out.println("== befor update> " + image);
		// // image.setImageUrl("imageURL4");
		// // image.setName("sNOT to del");
		// image.setType(Type.WINTER);
		// try {
		// imageFacade.updateImage(image, image.getName(), image.getImageUrl());
		// } catch (Image_problem | Image_exists | Image_Does_Not_Exists e) {
		// e.printStackTrace();
		// }

		// -= -= - =- =-=- get image by name\URL -= -= -= -= =- //
		// checked empty and null not good
		// checked not in the DB
		// System.out.println("================ empty =========");
		// try {
		// // imageFacade.getImageByName("");
		// imageFacade.getImageByUrl("");
		// } catch (Image_Does_Not_Exists | Image_problem | Image_exists e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// }
		//
		// System.out.println("=============== not in DB ============");
		// try {
		// // imageFacade.getImageByName("not in DB");
		// imageFacade.getImageByUrl("not in DB");
		// } catch (Image_Does_Not_Exists | Image_problem | Image_exists e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// }
		// System.out.println("=============== good ============");
		// try {
		// // image = imageFacade.getImageByName("imageName4");
		// image = imageFacade.getImageByUrl("imageURL6");
		// System.out.println(image);
		// } catch (Image_Does_Not_Exists | Image_problem | Image_exists e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// }

		// =-= -=- =- =- =- delete image =-= -=- =- -=-= //

		//
		// try {
		// System.out.println("================ null image =========== ");
		// imageFacade.deleteImage(null);
		// } catch (Image_problem | Image_Does_Not_Exists | Image_exists e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// }
		// try {
		// System.out.println("================ new --> null inside the image image
		// =========== ");
		// imageFacade.deleteImage(image);
		// } catch (Image_problem | Image_Does_Not_Exists | Image_exists e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// }
		// try {
		// System.out.println("================ NOT IN DB =========== ");
		// image.setId(8);
		// image.setName("bsbssb");
		// image.setImageUrl("bsbssb");
		// imageFacade.deleteImage(image);
		// } catch (Image_problem | Image_Does_Not_Exists | Image_exists e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// }

		// try {
		// image = imageFacade.getImageByName("imageName7");
		// } catch (Image_Does_Not_Exists | Image_problem | Image_exists e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// }
		// try {
		// imageFacade.deleteImage(image);
		// } catch (Image_problem | Image_Does_Not_Exists | Image_exists e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// }

		List<ImageDetail> list = null;
		// =- =-=-=-=-=-=- check list of images and list by type -=-===-=-=-=-=- //
		// checked all
		// try {
		// System.out.println("======================== all =====================");
		// list = imageFacade.getImagesList();
		// } catch (Image_Does_Not_Exists e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// }
		//
		// for (ImageDetail img : list) {
		// System.out.println("==> " + img);
		// }
		//
		// try {
		// System.out.println("======================== SPRING =====================");
		// list = imageFacade.getImagesByType(null);
		// } catch (Image_Does_Not_Exists e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// }
		// for (ImageDetail img : list) {
		// System.out.println("==> " + img);
		// }
	}

}
