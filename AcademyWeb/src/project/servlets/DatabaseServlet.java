package project.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.ejb.EJB;
import javax.naming.InitialContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import project.business.ShipperBeanLocal;
import project.entity.Shipper;

/**
 * Servlet implementation class DatabaseServlet
 */
@WebServlet("/DatabaseServlet")
@EJB(name="ejb/Shipper", beanInterface=ShipperBeanLocal.class)
public class DatabaseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DatabaseServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		try {
			InitialContext context = new InitialContext();
			ShipperBeanLocal bean = (ShipperBeanLocal)context.lookup("java:comp/env/ejb/Shipper");
			Shipper s = new Shipper();
			if(request.getParameter("txtShipper") != null &&
					request.getParameter("txtPhone") != null) {
				
				if(request.getParameter("txtId") != null) {
					s.setShipperid(Integer.parseInt(request.getParameter("txtId")));
				}
				s.setCompanyname(request.getParameter("txtShipper"));
				s.setPhone(request.getParameter("txtPhone"));
				bean.saveShipper(s);
			}
			
			List<Shipper> shippers = bean.retrieveAllShippers();
			for(Shipper sh : shippers) {
				out.println("<a href='EditShipper.jsp?id=" + sh.getShipperid() + "'>" +
							sh.getCompanyname() + "</a><br>");
			}
			
		} catch(Exception ex) {
			out.println("Exception occurred: " + ex.getMessage());
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