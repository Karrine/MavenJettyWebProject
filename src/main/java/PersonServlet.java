
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.PersonDAO;
import entities.Person;
import util.ConnectionManager;


public class PersonServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public PersonServlet() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String name =  (String)request.getSession().getAttribute("name");
		String email = (String)request.getSession().getAttribute("email");

		PersonDAO personDAO = new PersonDAO();
		Person person = new Person(name, email);
		personDAO.createPerson(person);
		personDAO.close();
		response.sendRedirect("entryAdded.jsp");
	}

}
