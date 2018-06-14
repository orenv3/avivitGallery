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
		if (this.isNotProblematic(img))
			if (this.checkPresent(img, CREATE))
				imgDao.saveImage(img);
	}

	public void deleteImage(ImageDetail img) throws Image_problem, Image_Does_Not_Exists, Image_exists {
		if (this.isNotProblematic(img)) {
			Optional<ImageDetail> presentByUrl = Optional.ofNullable(imgDao.getImageByUrl(img.getImageUrl()));
			if (presentByUrl.isPresent())
				imgDao.deleteImage(img);
			else
				throw new Image_Does_Not_Exists(
						"The followong image does not exists(checked by image url). The operation not executed.");
		}

	}

	public void updateImage(ImageDetail img) throws Image_problem, Image_exists, Image_Does_Not_Exists {
		if (this.isNotProblematic(img))
			if (this.checkPresent(img, UPDATE))
				imgDao.saveImage(img);
	}

	public ImageDetail getImageById(int id) throws Image_Does_Not_Exists, Image_problem, Image_exists {
		ImageDetail img = imgDao.getImageById(id);
		if (this.isNotProblematic(img))
			if (this.checkPresent(img, GET))
				return img;
		return null; // not suppose to reach this line.

	}

	public ImageDetail getImageByName(String name) throws Image_Does_Not_Exists, Image_problem, Image_exists {
		ImageDetail img = imgDao.getImageByName(name);
		if (this.isNotProblematic(img))
			if (this.checkPresent(img, GET))
				return img;
		return null; // not suppose to reach this line.

	}

	public ImageDetail getImageByUrl(String url) throws Image_Does_Not_Exists, Image_problem, Image_exists {
		ImageDetail img = imgDao.getImageByUrl(url);
		if (this.isNotProblematic(img))
			if (this.checkPresent(img, GET))
				return img;
		return null; // not suppose to reach this line.

	}

	public List<ImageDetail> getImagesList() throws Image_Does_Not_Exists {
		Optional<List<ImageDetail>> list = Optional.ofNullable(imgDao.getImageList());
		if (list.isPresent())
			if (list.get().size() > 0)
				return list.get();
		throw new Image_Does_Not_Exists("There are no images for presentaion.");
	}

	public List<ImageDetail> getImagesByType(Type type) throws Image_Does_Not_Exists {
		Optional<List<ImageDetail>> list = Optional.ofNullable(imgDao.getImageListByType(type));
		if (list.isPresent())
			if (list.get().size() > 0)
				return list.get();
		throw new Image_Does_Not_Exists("There are no images for presentaion.");
	}

	// ====== private ====//
	private boolean isNotProblematic(ImageDetail img) throws Image_problem {
		if (img == null || img.getImageUrl().equals(null) || img.getName().equals(null)) {
			throw new Image_problem("Either the image is null or one of the following fields: url, name");
		} else if (img.getImageUrl().isEmpty() || img.getName().isEmpty()) {
			throw new Image_problem("Either the url field or the name field is empty");
		}
		return true;
	}

	/**
	 * checks if the URL and image name exists. The method checks either for create
	 * and update.
	 * 
	 * @param img
	 * @param method
	 *            have to be UPDATE OR CREATE
	 * @return
	 * @throws Image_exists
	 * @throws Image_Does_Not_Exists
	 */
	private boolean checkPresent(ImageDetail img, String method) throws Image_exists, Image_Does_Not_Exists {
		Optional<ImageDetail> presentByUrl = Optional.ofNullable(imgDao.getImageByUrl(img.getImageUrl()));
		Optional<ImageDetail> presentByName = Optional.ofNullable(imgDao.getImageByName(img.getName()));

		if (method.equals(CREATE)) {
			if (presentByUrl.isPresent()) {
				throw new Image_exists("The following image already exists(checked by url)");
			}
			if (presentByName.isPresent())
				throw new Image_exists("The following image already exists(checked by name)");
		} else if (method.equals(UPDATE)) {
			if (img.getName().equals(presentByName.get().getName()))
				throw new Image_exists("The image name already exists");
		} else if (method.equals(GET)) {
			if (!(presentByUrl.isPresent()))
				throw new Image_Does_Not_Exists("The following image does not exists. please recheck the parameters.");
		}

		return true;
	}

}
