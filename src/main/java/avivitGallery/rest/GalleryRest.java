package avivitGallery.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import avivitGallery.exceptions.Image_Does_Not_Exists;
import avivitGallery.exceptions.Image_exists;
import avivitGallery.exceptions.Image_problem;
import avivitGallery.facade.ImageFacade;
import avivitGallery.tables.ImageDetail;

@CrossOrigin(origins = "*")
@RequestMapping(value = "/GalleryRest")
@RestController
public class GalleryRest {

	@Autowired
	ImageFacade imageFacade;

	@RequestMapping(value = "/createImage", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> createImage(@RequestBody ImageDetail image) {

		try {
			imageFacade.createImage(image);
		} catch (Image_problem | Image_exists | Image_Does_Not_Exists e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).contentType(MediaType.TEXT_PLAIN).body(e.getMessage());
		}
		return ResponseEntity.ok("The image created successfully");

	}

	@RequestMapping(value = "/deleteImage", method = RequestMethod.DELETE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> deleteImage(@RequestBody ImageDetail image) {

		try {
			imageFacade.deleteImage(image);
		} catch (Image_problem | Image_Does_Not_Exists | Image_exists e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).contentType(MediaType.TEXT_PLAIN).body(e.getMessage());
		}
		return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.TEXT_PLAIN)
				.body("The Image deleted successfully");

	}

	@RequestMapping(value = "/updateImage/{imageName}/{imageEmail}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> updateImage(@RequestBody ImageDetail image,
			@PathVariable("imageName") String imageName, @PathVariable("imageEmail") String imageEmail) {

		try {
			imageFacade.updateImage(image, imageName, imageEmail);
		} catch (Image_problem | Image_exists | Image_Does_Not_Exists e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).contentType(MediaType.TEXT_PLAIN).body(e.getMessage());
		}
		return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.TEXT_PLAIN)
				.body("The image updated successfully.");

	}

	@RequestMapping(value = "/getImageById/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity getImageById(@PathVariable("id") int id) {
		ImageDetail image = new ImageDetail();
		try {
			image = imageFacade.getImageById(id);
		} catch (Image_Does_Not_Exists | Image_problem | Image_exists e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).contentType(MediaType.TEXT_PLAIN).body(e.getMessage());
		}

		return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON).body(image);

	}
}
