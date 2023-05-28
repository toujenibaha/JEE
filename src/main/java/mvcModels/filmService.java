package mvcModels;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import entities.Cclient;
import entities.Film;

/**
 * Session Bean implementation class clientService
 */
@Stateless
@LocalBean
public class filmService {

	@PersistenceContext(unitName="ProjectCinema")
	private EntityManager em;
    public filmService() {
     
    }
    public List<Film> getAllFilms(){
   	 List<Film> films=new ArrayList<Film>();
   	 TypedQuery<Film> query=em.createNamedQuery("Film.findAll",Film.class);
   	 films=query.getResultList();
   	 return films;
    }
    public Film getFilm(int idf) {
    	Film filme;
      	TypedQuery<Film> query=em.createNamedQuery("Film.getFilmById",Film.class);
      	query.setParameter(1,idf);
      	filme=query.getSingleResult();
      	return filme;
    }
}
