package examples.pubhub.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RemoveTagDetailsServlet
 */
@WebServlet("/RemoveTagDetails")
public class RemoveTagDetailsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String isbn13 = request.getParameter("isbn13");
		
		request.getSession().setAttribute("isbn13", isbn13);

		request.getRequestDispatcher("removeTagDetails.jsp").forward(request, response);
	}
}
