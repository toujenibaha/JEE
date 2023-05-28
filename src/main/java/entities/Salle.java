package entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the salle database table.
 * 
 */
@Entity
@NamedQuery(name="Salle.findAll", query="SELECT s FROM Salle s")
public class Salle implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idsalle;

	private int capacité;

	public Salle() {
	}

	public int getIdsalle() {
		return this.idsalle;
	}

	public void setIdsalle(int idsalle) {
		this.idsalle = idsalle;
	}

	public int getCapacité() {
		return this.capacité;
	}

	public void setCapacité(int capacité) {
		this.capacité = capacité;
	}

}