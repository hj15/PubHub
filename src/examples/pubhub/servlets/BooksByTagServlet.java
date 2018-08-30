package examples.pubhub.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import examples.pubhub.dao.TagDAO;
import examples.pubhub.model.Book;
import examples.pubhub.utilities.DAOUtilities;
import java.util.List;

/**
 * Servlet implementation class BooksByTagServlet
 */
@WebServlet("/BooksByTag")
public class BooksByTagServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				//Need to have the tag searched saved to the request
		
				String tag = request.getParameter("tag");
				
				//Grabs the list of books with searched tag from the Database	
				TagDAO dao = DAOUtilities.getTagDAO();
				
				List<Book> bookList = dao.getAllBooksForTag(tag);
				
				//bookList will be populated in a variable to be stored for session
				
				request.getSession().setAttribute("books", bookList);
				request.getSession().setAttribute("tag", tag);
				
				request.getRequestDispatcher("booksByTag.jsp").forward(request, response);	}
   
	
}
