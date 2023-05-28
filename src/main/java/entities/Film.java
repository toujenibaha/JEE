package entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the film database table.
 * 
 */
@Entity
@NamedQueries({@NamedQuery(name="Film.findAll", query="SELECT f FROM Film f"),
	@NamedQuery(name="Film.getFilmById", query="SELECT f FROM Film f where f.idfilm=?1")})
public class Film implements Serializable {
	private static final long serialVersionUID = 1L;

	@Lob
	private String description;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idfilm;

	private String img;

	private String link;

	private String title;

	public Film() {
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getIdfilm() {
		return this.idfilm;
	}

	public void setIdfilm(int idfilm) {
		this.idfilm = idfilm;
	}

	public String getImg() {
		return ("multimedia/films/"+this.img);
	}

	public void setImg(String img) {
		this.img = img;
	}

	public String getLink() {
		return this.link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

}