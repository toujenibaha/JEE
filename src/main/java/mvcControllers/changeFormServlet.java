package mvcControllers;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entities.Cclient;
import mvcModels.clientService;


@WebServlet("/changeFormServlet")
public class changeFormServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@EJB
    private clientService clientservice;
    public changeFormServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		    String user=(String)request.getSession().getAttribute("loginUser");
		    String mdp=(String)request.getSession().getAttribute("pwd");
		    Cclient c=clientservice.getClient(user, mdp);
		    request.setAttribute("nom",c.getUsername());
		    request.setAttribute("motDePasse",c.getMdp());
		    request.setAttribute("adresseMail",c.getAdresse());
		    request.setAttribute("telephone",c.getPhone());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
