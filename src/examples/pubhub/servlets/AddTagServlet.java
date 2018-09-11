package examples.pubhub.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import examples.pubhub.dao.BookDAO;
import examples.pubhub.dao.TagDAO;
import examples.pubhub.model.Book;
import examples.pubhub.model.Tag;
import examples.pubhub.utilities.DAOUtilities;

/**
 * Servlet implementation class AddTagServlet
 */
/*
@WebServlet("/AddTag")
public class AddTagServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		boolean isSuccess = false;
		String isbn13 = request.getParameter("isbn13");
		
		String tag = request.getParameter("tag");
				
		BookDAO bookDAO = DAOUtilities.getBookDAO();
		Book book = bookDAO.getBookByISBN(isbn13);
		
		TagDAO tagDAO = DAOUtilities.getTagDAO();
		
		
		if(book != null) {
			Tag tagObj = new Tag(isbn13, tag);
			isSuccess = tagDAO.addTag(tagObj);
		} else {
			//Book of isbn13 not found. Adding failed
			isSuccess = false;
		}
		

		if(isSuccess){
			request.getSession().setAttribute("message", "Tag successfully added");
			request.getSession().setAttribute("messageClass", "alert-success");
			response.sendRedirect("AddTagDetails?isbn13=" + isbn13);
		}else {
			request.getSession().setAttribute("message", "There was a problem adding this tag");
			request.getSession().setAttribute("messageClass", "alert-danger");
			request.getRequestDispatcher("addTagDetails.jsp").forward(request, response);
		}
		
	}

}
*/