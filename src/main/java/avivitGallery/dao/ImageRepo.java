package avivitGallery.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import avivitGallery.tables.ImageDetail;

public interface ImageRepo extends CrudRepository<ImageDetail, String> {

	List<ImageDetail> findByType(String type);

	ImageDetail findByImageUrl(String url);

	ImageDetail findByName(String name);

	ImageDetail findById(int id);

}
