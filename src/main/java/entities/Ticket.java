package entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the ticket database table.
 * 
 */
@Entity
@NamedQueries({@NamedQuery(name="Ticket.findAll",query="SELECT t FROM Ticket t"),
	@NamedQuery(name="Ticket.findTicket",query="SELECT t FROM Ticket t where t.filmIdfilm=?1 and t.cclient.idclient=?2"),
	@NamedQuery(name="Ticket.count",query="SELECT count(t) FROM Ticket t where t.filmIdfilm=?1 and t.cclient.idclient=?2")})
public class Ticket implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idTicket;

	@Column(name="film_idfilm")
	private int filmIdfilm;

	//bi-directional many-to-one association to Cclient
	@ManyToOne
	@JoinColumn(name="Client_idClient")
	private Cclient cclient;

	public Ticket() {
	}

	public int getIdTicket() {
		return this.idTicket;
	}

	public void setIdTicket(int idTicket) {
		this.idTicket = idTicket;
	}

	public int getFilmIdfilm() {
		return this.filmIdfilm;
	}

	public void setFilmIdfilm(int filmIdfilm) {
		this.filmIdfilm = filmIdfilm;
	}

	public Cclient getCclient() {
		return this.cclient;
	}

	public void setCclient(Cclient cclient) {
		this.cclient = cclient;
	}

}