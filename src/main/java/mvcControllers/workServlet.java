package mvcControllers;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import entities.Cclient;
import entities.Ticket;
import mvcModels.clientService;
import mvcModels.filmService;
import mvcModels.planService;
import mvcModels.ticketService;


@WebServlet("/workServlet")
public class workServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@EJB
	private filmService filmservice;
	@EJB
    private planService planservice;
	@EJB
    private clientService clientservice;
	@EJB
    private ticketService ticketservice;
	private boolean namePermission; 
    public workServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");		
		if(action!=null && action.equals("Rechercher Client"))
		{
			String login = request.getParameter("name");
			String  pass=request.getParameter("password");
			Long detailsClient=clientservice.countClient(login, pass);
			HttpSession session = request.getSession(true);
            if(detailsClient==0){
               String erreur = "Login ou mot de pass invalid";
     		   request.setAttribute("message", erreur);
     		   request.getRequestDispatcher("connection.jsp").forward(request, response);
            }else {
               session.setAttribute("loginUser",login);
 			   session.setAttribute("pwd",pass);
               request.setAttribute("message",request.getSession().getAttribute("loginUser"));
         	   request.getRequestDispatcher("protoacceuil.jsp").forward(request, response);
            }
	  }else if(action!=null && action.equals("enregistrer reservation")) {
		  Object user2=request.getSession().getAttribute("loginUser");
		  if(user2==null) {
			  String erreur = "Connect yourself with us first!";
    		  request.setAttribute("message", erreur);
    		  request.getRequestDispatcher("connection.jsp").forward(request, response);
		  }else {
	         request.getRequestDispatcher("paiement.jsp").forward(request, response);		  
		  }
	  }else if(action!=null && action.equals("annuler reservation")){
		   String user=(String)request.getSession().getAttribute("loginUser");
 		   String mdp=(String)request.getSession().getAttribute("pwd");
 		   int idf=(int)request.getSession().getAttribute("idf");
 		   Cclient client=clientservice.getClient(user,mdp);
           int idc=client.getIdclient();
           Ticket t=ticketservice.getTicket(idf, idc);
           ticketservice.deleteTicket(t.getIdTicket());
           request.setAttribute("confirmation","deletion of ticket was successful");
	       request.getRequestDispatcher("protoacceuil.jsp").forward(request, response);		  
	  }
		  String act=request.getParameter("up_button");
	        if(act!=null && act.equals("se connecter")) {
	 	       request.getRequestDispatcher("connection.jsp").forward(request, response);		  
	        }else if(act!=null && act.equals("se deconnecter")){
	        	request.getSession().setAttribute("loginUser",null);
	 			request.getSession().setAttribute("pwd",null);
	 	        request.getRequestDispatcher("protoacceuil.jsp").forward(request, response);		  
	        }	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action=request.getParameter("action");
		if(action!=null && action.equals("enregistrer ticket")) {
  		    String user=(String)request.getSession().getAttribute("loginUser");
  		    String mdp=(String)request.getSession().getAttribute("pwd");
		    Object idfilm=request.getSession().getAttribute("idf");
            int idf=(int)idfilm;
            Cclient client=clientservice.getClient(user,mdp);
            int idc=client.getIdclient();
            Ticket t=new Ticket();
            t.setCclient(client);
            t.setFilmIdfilm(idf);
            ticketservice.addTicket(t);
            request.setAttribute("confirmation","Reservation was succeful");
    		request.getRequestDispatcher("paiement.jsp").forward(request, response);		  	  
        }else if(action!=null && action.equals("create acc")) {
        	Cclient c=new Cclient();
    		String nom = request.getParameter("name");
    		String pwd = request.getParameter("password");
    		String tele = request.getParameter("phone");
    		String mail = request.getParameter("email");
    		Long a=clientservice.countClientByName(nom);
    		Long b=clientservice.countClientByPwd(pwd);
    		Long d=clientservice.countClientByAddress(mail);
    		Long e=clientservice.countClientByPhone(tele);
    		if(a==0 && b==0 && d==0 && e==0) {
    			c.setAdresse(mail);
    			c.setMdp(pwd);
    			c.setPhone(tele);
    			c.setUsername(nom);
    			clientservice.addClient(c);
        		request.setAttribute("message","Account succefully created");
        		request.getRequestDispatcher("connection.jsp").forward(request, response);
    		}else {
    			if(a!=0) {
        			request.setAttribute("usernameVerify","Username already Exists");
        		}
    			if(b!=0) {
        			request.setAttribute("passwordVerify","Password already Exists");
        		}
    			if(d!=0) {
        			request.setAttribute("adressVerify","Address is already being used");
        		}
    			if(e!=0) {
        			request.setAttribute("phoneVerify","Phone Number is already being used");
        		}
    			request.getRequestDispatcher("inscription.jsp").forward(request, response);
    		}
        }else if(action!=null && action.equals("modifyAcc")) {
        	    String user=(String)request.getSession().getAttribute("loginUser");
  		        String mdp=(String)request.getSession().getAttribute("pwd");
        	    Cclient c=clientservice.getClient(user, mdp);
        	    System.out.println(c.getUsername());
        	    System.out.println(c.getMdp());
        	    System.out.println(c.getAdresse());
        	    System.out.println(c.getPhone());
        		String nom = request.getParameter("name");
        	    System.out.println(nom);
        		String pwd = request.getParameter("password");
        		String tele = request.getParameter("phone");
        		String mail = request.getParameter("email");
        		Long a=clientservice.countClientByName(nom);
        		Long b=clientservice.countClientByPwd(pwd);
        		Long d=clientservice.countClientByAddress(mail);
        		Long e=clientservice.countClientByPhone(tele);
        		boolean namePermission=false;
        		boolean pwdPermission=false;
        		boolean adressPermission=false;
        		boolean phonePermission=false;
        		if(a==0 && b==0 && d==0 && e==0) {
        			c.setAdresse(mail);
        			c.setMdp(pwd);
        			c.setPhone(tele);
        			c.setUsername(nom);
        			clientservice.modifyClient(c,c.getIdclient(),c.getMdp());
        			request.getSession().setAttribute("loginUser",null);
        			request.getSession().setAttribute("pwd",null);
            		request.setAttribute("message","Account succefully modified,log in again");
            		request.getRequestDispatcher("connection.jsp").forward(request, response);
        		}else {
        			if(a==1){
                         if(nom.equals(c.getUsername())){
                        	 namePermission=true;
                         }else{
                 			request.setAttribute("nameVerif","name is currently in use for another account");
                        	namePermission=false;
                         }
        			}else if(a==0){
                   	 namePermission=true;
        			}
        			if(b==1){
            			if(pwd.equals(c.getMdp())){
            				pwdPermission=true;
            			}else{
            				request.setAttribute("pwdVerif","password is currently in use for another account");
                        	namePermission=false;
            			}
            		}else if(b==0){
            			pwdPermission=true;
            		}
        			if(d==1){
            			if(mail.equals(c.getAdresse())){
            				adressPermission=true;
            			}else {
            				request.setAttribute("mailVerif","mail is currently in use for another account");
                        	adressPermission=false;
            			}
            		}else if(d==0){
        				adressPermission=true;
            		}
        			if(e==1){
                        if(tele.equals(c.getPhone())) {
                        	phonePermission=true;
                        }else {
            				request.setAttribute("phoneVerif","phone is currently in use for another account");
                        	phonePermission=false;
                        }
        			}else if(e==0) {
                    	phonePermission=true;
        			}
        		  if(namePermission==true && pwdPermission==true && adressPermission==true && phonePermission==true) {
        			  request.getSession().setAttribute("loginUser",nom);
        			  request.getSession().setAttribute("pwd",pwd);
        			  c.setAdresse(mail);
        			  c.setMdp(mdp);
        			  c.setPhone(tele);
        			  c.setUsername(nom);
          			 clientservice.modifyClient(c,c.getIdclient(),c.getMdp());
              		  request.setAttribute("message","Account succefully modified,log in again");
              		  request.getRequestDispatcher("connection.jsp").forward(request, response);
        		  }else {
              		  request.getRequestDispatcher("changement.jsp").forward(request, response);
        		  }
        		} 
        }
	}

}
