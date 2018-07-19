package com.loggin.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

/**
 * Servlet implementation class Servlet
 */
@WebServlet("/Servlet")
public class Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Servlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    //on recupere les données qui se trouve dans les champs de saisie  lors du premier chargement de la page
    String login = request.getParameter("txtLoging");
    String password = request.getParameter("txtPassword");
    
    //test l'etat des données lors du premier chargement de la page
    if (login == null) login= "";
    if (password == null) password= "";
	
	//creons notre session qui nous servira de modele
    HttpSession session = request.getSession(true);
    session.setAttribute("login", login);
    session.setAttribute("password", password);
    
    request.getRequestDispatcher("Login.jsp").forward(request, response);
	}
	
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// on recupere les parametres inseres dans les deux inputs
    String login = request.getParameter("txtLoging");
	String password = request.getParameter("txtPassword");
	
	//creons notre session qui nous servira de modele
    HttpSession session = request.getSession(true);
    session.setAttribute("login", login);
    session.setAttribute("password", password);
	
	if (login.equals("papa") && password.equals("mama")){
		request.getRequestDispatcher("/Connected.jsp").forward(request, response);
		session.setAttribute("isConnected", true);
	}else {
		request.getRequestDispatcher("/Login.jsp").forward(request, response);
		session.setAttribute("isConnected", false);
	}
		
	}

}
