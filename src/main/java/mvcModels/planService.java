package mvcModels;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import entities.Film;
import entities.Plannifier;

/**
 * Session Bean implementation class planService
 */
@Stateless
@LocalBean
public class planService {

	@PersistenceContext(unitName="ProjectCinema")
	private EntityManager em;
    public planService() {
        // TODO Auto-generated constructor stub
    }
    public List<Plannifier> getAllPlans(){
      	 List<Plannifier> plans=new ArrayList<Plannifier>();
      	 TypedQuery<Plannifier> query=em.createNamedQuery("Plannifier.findAll",Plannifier.class);
      	 plans=query.getResultList();
      	 return plans;
       }
    public List<Plannifier> getPlan(int idf) {
      	TypedQuery<Plannifier> query=em.createNamedQuery("Plannifier.getFilmPlan",Plannifier.class);
      	query.setParameter(1,idf);
      	List<Plannifier> plan=query.getResultList();
      	return plan;
    }
}
