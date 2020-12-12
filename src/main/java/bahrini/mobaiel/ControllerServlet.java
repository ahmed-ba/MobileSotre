package bahrini.mobaiel;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class ControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private MobileDAO mobileDAO;

	public void init() {
		String jdbcURL = getServletContext().getInitParameter("jdbcURL");
		String jdbcUsername = getServletContext().getInitParameter("jdbcUsername");
		String jdbcPassword = getServletContext().getInitParameter("jdbcPassword");

		mobileDAO = new MobileDAO(jdbcURL, jdbcUsername, jdbcPassword);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getServletPath();

		try {
			if ("/new".equals(action)) {
				showNewForm(request, response);
			} else if ("/insert".equals(action)) {
				insertMobile(request, response);
			} else if ("/delete".equals(action)) {
				deleteMobile(request, response);
			} else if ("/edit".equals(action)) {
				showEditForm(request, response);
			} else if ("/update".equals(action)) {
				updateMobile(request, response);
			} else {
				listMobile(request, response);
			}
		} catch (SQLException ex) {
			throw new ServletException(ex);
		}
	}

	private void listMobile(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		List<Mobile> listMobile = mobileDAO.listAllMobile();
		request.setAttribute("listMobile", listMobile);
		RequestDispatcher dispatcher = request.getRequestDispatcher("MobileList.jsp");
		dispatcher.forward(request, response);
	}

	private void showNewForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("MobileForm.jsp");
		dispatcher.forward(request, response);
	}

	private void showEditForm(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("mobile_id"));
		Mobile existingMobile = mobileDAO.getMobile(id);
		RequestDispatcher dispatcher = request.getRequestDispatcher("MobileForm.jsp");
		request.setAttribute("mobile", existingMobile);
		dispatcher.forward(request, response);

	}

	private void insertMobile(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException {
		String refernce = request.getParameter("refrence");
		String brand = request.getParameter("brand");
		float price = Float.parseFloat(request.getParameter("price"));

		Mobile newMobile = new Mobile(refernce, brand, price);
		mobileDAO.insertMobile(newMobile);
		response.sendRedirect("list");
	}

	private void updateMobile(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException {
		int id = Integer.parseInt(request.getParameter("mobile_id"));
		String refrence = request.getParameter("refrence");
		String brand = request.getParameter("brand");
		float price = Float.parseFloat(request.getParameter("price"));

		Mobile mobile = new Mobile(id, refrence, brand, price);
		mobileDAO.updateMobile(mobile);
		response.sendRedirect("list");
	}

	private void deleteMobile(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));

		Mobile mobile = new Mobile(id);
		mobileDAO.deleteMobile(mobile);
		response.sendRedirect("list");

	}

}
