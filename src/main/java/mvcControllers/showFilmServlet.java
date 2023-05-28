package mvcControllers;

import java.io.IOException;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entities.Cclient;
import entities.Film;
import entities.Plannifier;
import mvcModels.clientService;
import mvcModels.filmService;
import mvcModels.planService;
import mvcModels.ticketService;

/**
 * Servlet implementation class showFilmServlet
 */
@WebServlet("/showFilmServlet")
public class showFilmServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@EJB
	private filmService filmservice;
	@EJB
    private planService planservice;
	@EJB
	private clientService clientservice;
	@EJB
	private ticketService ticketservice;
	public showFilmServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String para=request.getParameter("idfilm");
		int idf=Integer.parseInt(para);
		String user=(String)request.getSession().getAttribute("loginUser");
		String mdp=(String)request.getSession().getAttribute("pwd");
		Film f=filmservice.getFilm(idf);
		request.getSession().setAttribute("idf",f.getIdfilm());
		request.setAttribute("title",f.getTitle());
		request.setAttribute("descript",f.getDescription());
		request.setAttribute("trailer",f.getLink());
		request.setAttribute("image",f.getImg());
        if(user==null && mdp==null) {
    	    request.setAttribute("button","enregistrer reservation");
        }else {
    		Cclient c=clientservice.getClient(user,mdp);
    		System.out.println(c.getIdclient());
    		Long count=ticketservice.countTicket(idf,c.getIdclient());
    		if(count==0) {
        	    request.setAttribute("button","enregistrer reservation");
    		}else {
        	    request.setAttribute("button","annuler reservation");
    		}
        }
        List<Plannifier> p=planservice.getPlan(idf);
        request.setAttribute("plans",p);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
