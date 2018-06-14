package avivitGallery.tables;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import avivitGallery.Type;

@Entity
public class ImageDetail {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@Column
	private String name;

	@Column
	private String type;

	@Column
	private String imageUrl;

	@Column
	private String dateCreated;

	public ImageDetail() {

	}

	public ImageDetail(int id, String name, Type type, Date dateCreated) {
		super();
		this.id = id;
		this.name = name;
		this.type = type.toString();
		this.dateCreated = dateCreated;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Type getType() {
		return Type.valueOf(type);
	}

	public void setType(Type type) {
		this.type = type.toString();
	}

	public Date getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public String getImageUrl() {
		return this.imageUrl;
	}

	@Override
	public String toString() {
		return "ImageDetail [id=" + id + ", name=" + name + ", type=" + type + ", dateCreated=" + dateCreated + "]";
	}

}
