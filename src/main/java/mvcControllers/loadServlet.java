package mvcControllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entities.Cclient;
import entities.Film;
import mvcModels.filmService;

/**
 * Servlet implementation class loadServlet
 */
@WebServlet("/loadServlet")
public class loadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
      
	@EJB
	private filmService filmservice;
    public loadServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getAttribute("confirmation")==null){
			System.out.println("no message here");
		}else {
			System.out.println("message here:"+request.getAttribute("message"));			
		}
		List<Film> films=new ArrayList<Film>();
		films=filmservice.getAllFilms();
		request.setAttribute("myData",films);
		if(request.getSession().getAttribute("loginUser")==null){
        	request.setAttribute("message",null);
        	request.setAttribute("display","none");
        	request.setAttribute("up_btn","se connecter");
        }else{
            request.setAttribute("message",request.getSession().getAttribute("loginUser"));
            request.setAttribute("display","inline-block");
        	request.setAttribute("up_btn","se deconnecter");
        }
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
}