package avivitGallery.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import avivitGallery.Type;
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
	public void saveImage(ImageDetail image) {
		imageRepo.save(image);
	}

	public <T> void deleteImage(T imageEntity) {
		imageRepo.delete((ImageDetail) imageEntity);
	}

	public ImageDetail getImageById(int id) {
		return imageRepo.findById(id);
	}
	public ImageDetail getImageByName(String imageName) {
		return imageRepo.findByName(imageName);
	}

	public ImageDetail getImageByUrl(String imageUrl) {
		return imageRepo.findByImageUrl(imageUrl);
	}

	public List<ImageDetail> getImageList() {
		return  (List<ImageDetail>) imageRepo.findAll();
	}

	public List<ImageDetail> getImageListByType(Type type) {
		return imageRepo.findByType(type.toString());
	}

}
