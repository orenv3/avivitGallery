package avivitGallery.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import avivitGallery.Type;
import avivitGallery.tables.ImageDetail;

@Service
public class ImageDao {

	@Autowired
	ImageRepo imageRepo;

	public void saveImage(ImageDetail image) {
		imageRepo.save(image);
	}

	public void deleteImage(ImageDetail image) {
		imageRepo.delete(image);
	}

	public Optional<ImageDetail> getImage(String imageName) {
		return imageRepo.findById(imageName);
	}

	public List<ImageDetail> getImageList() {
		return  (List<ImageDetail>) imageRepo.findAll();
	}

	public List<ImageDetail> getImageListByType(Type type) {
		return imageRepo.findByType(type);
	}

}
