package mvcModels;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import entities.Cclient;


@Stateless
@LocalBean

public class clientService {
	@PersistenceContext(unitName="ProjectCinema")
	private EntityManager em;
	
    public clientService() {
      
    }
    public List<Cclient> getAllPlans(){
     	 List<Cclient> clients=new ArrayList<Cclient>();
     	 TypedQuery<Cclient> query=em.createNamedQuery("Cclient.findAll",Cclient.class);
     	 clients=query.getResultList();
     	 return clients;
      }
   public Cclient getClient(String nom,String mdp) {
     	TypedQuery<Cclient> query=em.createNamedQuery("Cclient.findClient",Cclient.class);
     	query.setParameter(1,nom);
     	query.setParameter(2,mdp);
     	Cclient client=query.getSingleResult();
     	return client;
   }
   public Long countClient(String nom,String mdp) {
    	TypedQuery<Long> query=em.createNamedQuery("Cclient.count",Long.class);
    	query.setParameter(1,nom);
     	query.setParameter(2,mdp);
     	Long l=query.getSingleResult();
     	return l;
   }
   public Long countClientByName(String nom) {
   	TypedQuery<Long> query=em.createNamedQuery("Cclient.countByName",Long.class);
   	query.setParameter(1,nom);
    Long l=query.getSingleResult();
    return l;
  }
   public Long countClientByPwd(String mdp) {
	   	TypedQuery<Long> query=em.createNamedQuery("Cclient.countByPwd",Long.class);
	   	query.setParameter(1,mdp);
	    Long l=query.getSingleResult();
	    return l;
	  }
   public Long countClientByAddress(String add) {
	   	TypedQuery<Long> query=em.createNamedQuery("Cclient.countByAddress",Long.class);
	   	query.setParameter(1,add);
	    Long l=query.getSingleResult();
	    return l;
	  }
   public Long countClientByPhone(String tel) {
	   	TypedQuery<Long> query=em.createNamedQuery("Cclient.countByPhone",Long.class);
	   	query.setParameter(1,tel);
	    Long l=query.getSingleResult();
	    return l;
	  }
   public void addClient(Cclient c) {
	   em.persist(c);
   }
   public void modifyClient(Cclient c,int id,String val){
	   Cclient client = em.find(Cclient.class,id);
	   client.setMdp(val);
	   em.merge(client);
	   client = em.find(Cclient.class,c.getIdclient());
	   System.out.println("After update:"+client.getUsername()+" "+c.getMdp());
    }
}
