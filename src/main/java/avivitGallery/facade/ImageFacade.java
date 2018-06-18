package avivitGallery.facade;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import avivitGallery.Type;
import avivitGallery.dao.ImageDao;
import avivitGallery.exceptions.Image_Does_Not_Exists;
import avivitGallery.exceptions.Image_exists;
import avivitGallery.exceptions.Image_problem;
import avivitGallery.tables.ImageDetail;

@Component
public class ImageFacade {

	private final String CREATE = "CREATE", UPDATE = "UPDATE", GET = "GET";

	@Autowired
	ImageDao imgDao;

	public void createImage(ImageDetail img) throws Image_problem, Image_exists, Image_Does_Not_Exists {
		if (this.isNotProblematic(img, UPDATE))
			if (this.checkPresent(img, CREATE))
				imgDao.saveImage(img);
	}

	public void deleteImage(ImageDetail img) throws Image_problem, Image_Does_Not_Exists, Image_exists {
		if (this.isNotProblematic(img, UPDATE)) {
			if (this.checkPresent(img, GET))
				imgDao.deleteImage(img);
			else
				throw new Image_Does_Not_Exists(
						"The followong image does not exists(checked by image url). The operation not executed.");
		}

	}

	/**
	 * Update image. the name and URL i the image object must be the old ones. This
	 * in order to check the name and URL via DB.
	 * 
	 * @param img
	 *            ## instead of name and URL## all fields inside the object can be
	 *            updated.
	 * @param name
	 *            the new updated name.
	 * @param url
	 *            the new updated url
	 * @throws Image_problem
	 * @throws Image_exists
	 * @throws Image_Does_Not_Exists
	 */
	public void updateImage(ImageDetail img, String newName, String newUrl)
			throws Image_problem, Image_exists, Image_Does_Not_Exists {
		if (newName == null || newName.isEmpty())
			throw new Image_problem("The name must not be empty or null.");
		else if (newUrl == null || newUrl.isEmpty())
			throw new Image_problem("The URL must not be empty or null.");

		Optional<ImageDetail> presentByUrl = Optional.ofNullable(imgDao.getImageByUrl(newUrl));
		Optional<ImageDetail> presentByName = Optional.ofNullable(imgDao.getImageByName(newName));
		if (this.isNotProblematic(img, UPDATE)) {
			if (presentByUrl.isPresent() && !(img.getImageUrl().equals(newUrl)))
				throw new Image_exists("The image URL already exists.");
			if (presentByName.isPresent() && !(img.getName().equals(newName)))
				throw new Image_exists("The image name already exists");
		}
		img.setName(newName);
		img.setImageUrl(newUrl);
		imgDao.saveImage(img);
	}

	public ImageDetail getImageById(int id) throws Image_Does_Not_Exists, Image_problem, Image_exists {
		ImageDetail img = imgDao.getImageById(id);
		if (this.isNotProblematic(img, GET))
			if (this.checkPresent(img, GET))
				return img;
		return null; // not suppose to reach this line.

	}

	public ImageDetail getImageByName(String name) throws Image_Does_Not_Exists, Image_problem, Image_exists {
		if (name.isEmpty())
			throw new Image_problem("The name field must not be empty.");
		ImageDetail img = imgDao.getImageByName(name);
		if (this.isNotProblematic(img, GET))
			if (this.checkPresent(img, GET))
				return img;
		return null; // not suppose to reach this line.

	}

	public ImageDetail getImageByUrl(String url) throws Image_Does_Not_Exists, Image_problem, Image_exists {
		if (url.isEmpty())
			throw new Image_problem("The URL field must not be empty.");
		ImageDetail img = imgDao.getImageByUrl(url);
		if (this.isNotProblematic(img, GET))
			if (this.checkPresent(img, GET))
				return img;
		return null; // not suppose to reach this line.

	}

	public List<ImageDetail> getImagesList() throws Image_Does_Not_Exists {
		Optional<List<ImageDetail>> list = Optional.ofNullable(imgDao.getImageList());
		if (list.isPresent())
			if (list.get().size() > 0)
				return list.get();
		throw new Image_Does_Not_Exists("There are no images to present.");
	}

	public List<ImageDetail> getImagesByType(Type type) throws Image_Does_Not_Exists {
		Optional<List<ImageDetail>> list = Optional.ofNullable(imgDao.getImageListByType(type));
		if (list.isPresent())
			if (list.get().size() > 0)
				return list.get();
		throw new Image_Does_Not_Exists("There are no images to present by this type.");
	}

	// ====== private ====//
	/**
	 * 
	 * @param img
	 * @param method
	 *            have to be Either UPDATE or GET. "This method is either for create
	 *            and delete"
	 * @return
	 * @throws Image_problem
	 */
	private boolean isNotProblematic(ImageDetail img, String method) throws Image_problem {

		switch (method) {
		case UPDATE:
			if (img == null || img.getImageUrl() == null || img.getName() == null) {
				throw new Image_problem("Either the image is null or one of the following fields: url, name");
			} else if (img.getImageUrl().isEmpty() || img.getName().isEmpty()) {
				throw new Image_problem("Either the url field or the name field is empty");
			}
			break;
		case GET:
			if (img == null) {
				throw new Image_problem(
						"The following image dose not exists in the system. recheck the image parameters: id, name and URL");
			}
			break;

		default:
			break;
		}

		return true;
	}

	/**
	 * checks if the URL and image name exists. The method checks either for create,
	 * get, delete and update.
	 * 
	 * @param img
	 * @param method
	 *            have to be GET OR CREATE - those are types of checks
	 * @return
	 * @throws Image_exists
	 * @throws Image_Does_Not_Exists
	 */
	private boolean checkPresent(ImageDetail img, String method) throws Image_exists, Image_Does_Not_Exists {

		Optional<ImageDetail> presentByUrl = Optional.ofNullable(imgDao.getImageByUrl(img.getImageUrl()));
		Optional<ImageDetail> presentByName = Optional.ofNullable(imgDao.getImageByName(img.getName()));

		switch (method) {
		case CREATE:
			if (presentByUrl.isPresent())
				throw new Image_exists("The image already exists(checked by url)");

			if (presentByName.isPresent())
				throw new Image_exists("The following image name: (" + img.getName() + ") already exists");

			break;

		case GET:
			if (!(presentByUrl.isPresent()))
				throw new Image_Does_Not_Exists("The following image does not exists. please recheck the parameters.");
			break;

		}

		return true;
	}

}
