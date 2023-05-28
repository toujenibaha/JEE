package mvcModels;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import entities.Cclient;
import entities.Plannifier;
import entities.Ticket;

/**
 * Session Bean implementation class ticketService
 */
@Stateless
@LocalBean
@Transactional
public class ticketService {
	@PersistenceContext(unitName="ProjectCinema")
	private EntityManager em;
    public ticketService() {
  
    }
 public void deleteTicket(int idt) {
	 Ticket ticket = em.find(Ticket.class,idt);
	 em.remove(ticket);
 }
 public Ticket getTicket(int idf,int idc) {
  	TypedQuery<Ticket> query=em.createNamedQuery("Ticket.findTicket",Ticket.class);
  	query.setParameter(1,idf);
  	query.setParameter(2,idc);
  	Ticket ticket=query.getSingleResult();
  	return ticket;
}
 public Long countTicket(int idf,int idc) {
 	TypedQuery<Long> query=em.createNamedQuery("Ticket.count",Long.class);
 	query.setParameter(1,idf);
  	query.setParameter(2,idc);
  	Long l=query.getSingleResult();
  	return l;
}
 public void addTicket(Ticket t) {
    em.persist(t);
 }
}
