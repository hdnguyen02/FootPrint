package footprint.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="Thumbnail")
public class Thumbnail {
	@Id
	@Column(name="idThumbnail")
	private Long idThumbnail; 
	
	@Column(name="name")
	private String name; 
	
	@ManyToOne
	@JoinColumn(name="idProduct")
	private Product product;
}
