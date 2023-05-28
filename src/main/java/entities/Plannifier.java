package entities;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Time;
import java.util.Date;


/**
 * The persistent class for the plannifier database table.
 * 
 */
@Entity
@NamedQueries({@NamedQuery(name="Plannifier.findAll", query="SELECT p FROM Plannifier p"),
	@NamedQuery(name="Plannifier.getFilmPlan",query="SELECT p FROM Plannifier p where p.filmIdfilm=?1")})
public class Plannifier implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_plan")
	private int idPlan;

	@Temporal(TemporalType.DATE)
	private Date dateP;

	@Column(name="film_idfilm")
	private int filmIdfilm;

	private Time heure;

	@Column(name="salle_idsalle")
	private int salleIdsalle;

	//bi-directional many-to-one association to Agent
	@ManyToOne
	private Agent agent;

	public Plannifier() {
	}

	public int getIdPlan() {
		return this.idPlan;
	}

	public void setIdPlan(int idPlan) {
		this.idPlan = idPlan;
	}

	public Date getDateP() {
		return this.dateP;
	}

	public void setDateP(Date dateP) {
		this.dateP = dateP;
	}

	public int getFilmIdfilm() {
		return this.filmIdfilm;
	}

	public void setFilmIdfilm(int filmIdfilm) {
		this.filmIdfilm = filmIdfilm;
	}

	public Time getHeure() {
		return this.heure;
	}

	public void setHeure(Time heure) {
		this.heure = heure;
	}

	public int getSalleIdsalle() {
		return this.salleIdsalle;
	}

	public void setSalleIdsalle(int salleIdsalle) {
		this.salleIdsalle = salleIdsalle;
	}

	public Agent getAgent() {
		return this.agent;
	}

	public void setAgent(Agent agent) {
		this.agent = agent;
	}

}