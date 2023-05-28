package entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the agent database table.
 * 
 */
@Entity
@NamedQuery(name="Agent.findAll", query="SELECT a FROM Agent a")
public class Agent implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idAgent;

	private String agentlogin;

	private String agentMDP;

	//bi-directional many-to-one association to Plannifier
	@OneToMany(mappedBy="agent", fetch=FetchType.EAGER)
	private List<Plannifier> plannifiers;

	public Agent() {
	}

	public int getIdAgent() {
		return this.idAgent;
	}

	public void setIdAgent(int idAgent) {
		this.idAgent = idAgent;
	}

	public String getAgentlogin() {
		return this.agentlogin;
	}

	public void setAgentlogin(String agentlogin) {
		this.agentlogin = agentlogin;
	}

	public String getAgentMDP() {
		return this.agentMDP;
	}

	public void setAgentMDP(String agentMDP) {
		this.agentMDP = agentMDP;
	}

	public List<Plannifier> getPlannifiers() {
		return this.plannifiers;
	}

	public void setPlannifiers(List<Plannifier> plannifiers) {
		this.plannifiers = plannifiers;
	}

	public Plannifier addPlannifier(Plannifier plannifier) {
		getPlannifiers().add(plannifier);
		plannifier.setAgent(this);

		return plannifier;
	}

	public Plannifier removePlannifier(Plannifier plannifier) {
		getPlannifiers().remove(plannifier);
		plannifier.setAgent(null);

		return plannifier;
	}

}