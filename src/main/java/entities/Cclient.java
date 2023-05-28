package entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the cclient database table.
 * 
 */
@Entity
@NamedQueries({@NamedQuery(name="Cclient.findAll",query="SELECT c FROM Cclient c"),
	@NamedQuery(name="Cclient.findClient",query="SELECT c FROM Cclient c where c.username=?1 and c.mdp=?2"),
	@NamedQuery(name="Cclient.count",query="SELECT count(c) FROM Cclient c where c.username=?1 and c.mdp=?2"),
	@NamedQuery(name="Cclient.countByName",query="SELECT count(c) FROM Cclient c where c.username=?1"),
	@NamedQuery(name="Cclient.countByPwd",query="SELECT count(c) FROM Cclient c where c.mdp=?1"),
	@NamedQuery(name="Cclient.countByPhone",query="SELECT count(c) FROM Cclient c where c.phone=?1"),
	@NamedQuery(name="Cclient.countByAddress",query="SELECT count(c) FROM Cclient c where c.adresse=?1")})
public class Cclient implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idclient;

	private String adresse;

	private String mdp;

	private String phone;

	private String username;

	//bi-directional many-to-one association to Ticket
	@OneToMany(mappedBy="cclient", fetch=FetchType.EAGER)
	private List<Ticket> tickets;

	public Cclient() {
	}

	public int getIdclient() {
		return this.idclient;
	}

	public void setIdclient(int idclient) {
		this.idclient = idclient;
	}

	public String getAdresse() {
		return this.adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getMdp() {
		return this.mdp;
	}

	public void setMdp(String mdp) {
		this.mdp = mdp;
	}

	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public List<Ticket> getTickets() {
		return this.tickets;
	}

	public void setTickets(List<Ticket> tickets) {
		this.tickets = tickets;
	}

	public Ticket addTicket(Ticket ticket) {
		getTickets().add(ticket);
		ticket.setCclient(this);

		return ticket;
	}

	public Ticket removeTicket(Ticket ticket) {
		getTickets().remove(ticket);
		ticket.setCclient(null);

		return ticket;
	}

}