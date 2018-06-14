package avivitGallery.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import avivitGallery.Type;
import avivitGallery.exceptions.Image_Does_Not_Exists;
import avivitGallery.exceptions.Image_exists;
import avivitGallery.exceptions.Image_problem;
import avivitGallery.tables.ImageDetail;

@Service
public class ImageDao {

	@Autowired
	ImageRepo imageRepo;

	/**
	 * create and update method
	 * 
	 * @param image
	 */
	public void saveImage(ImageDetail image) throws Image_problem {
		imageRepo.save(image);
	}

	public <T> void deleteImage(T imageEntity) throws Image_problem {
		imageRepo.delete((ImageDetail) imageEntity);
	}

	public ImageDetail getImageById(int id) throws Image_Does_Not_Exists {
		return imageRepo.findById(id);
	}

	public ImageDetail getImageByName(String imageName) throws Image_Does_Not_Exists, Image_exists {
		return imageRepo.findByName(imageName);
	}

	public ImageDetail getImageByUrl(String imageUrl) throws Image_Does_Not_Exists, Image_exists {
		return imageRepo.findByImageUrl(imageUrl);
	}

	public List<ImageDetail> getImageList() throws Image_Does_Not_Exists {
		return (List<ImageDetail>) imageRepo.findAll();
	}

	public List<ImageDetail> getImageListByType(Type type) throws Image_Does_Not_Exists {
		return imageRepo.findByType(type);
	}

}
