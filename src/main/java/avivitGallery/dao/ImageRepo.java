package avivitGallery.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import avivitGallery.Type;
import avivitGallery.tables.ImageDetail;

public interface ImageRepo extends CrudRepository<ImageDetail, String> {

	List<ImageDetail> findByType(Type type);
}
