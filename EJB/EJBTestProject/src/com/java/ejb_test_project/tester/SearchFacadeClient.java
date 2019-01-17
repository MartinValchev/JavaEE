package com.java.ejb_test_project.tester;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.java.ejb_test_project.stateful.ShopperCountBean;
import com.java.ejb_test_project.stateful.ShopperCountLocal;
import com.java.ejb_test_project.stateless.SearchFacadeLocal;

@WebServlet(name = "SearchFacadeClient", urlPatterns = { "/SearchFacadeClient" })
public class SearchFacadeClient extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4627580332159581312L;

	@EJB
	SearchFacadeLocal searchFacade;

	@EJB
	ShopperCountLocal shopperCount;

	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		try {
			out.println("<html>");
			out.println("<head>");
			out.println("<title>Servlet SearchFacadeClient</title>");
			out.println("</head>");
			out.println("<body>");
			out.println("<h1> Starting Search Facade test ... </h1>");
			out.println("<h1>SearchFacade Lookup</h1>");
			out.println("<h1>Searching wines</h1>");
			List<String> winesList = searchFacade.wineSearch("Red");
			out.println("<h1>Printing wines list</h1>");
			for (String wine : winesList) {
				out.println("<h1>" + wine + "</h1>");
				out.println("Printing Shopper Count after incrementing it ...");
				shopperCount.incrementShopperCount();
				out.println("<h1>" + shopperCount.getShopperCount() + "</h1>");
				out.println("</body>");
				out.println("</html>");
			}
		} finally {
			out.close();
		}
	}
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse
	response)
	throws ServletException, IOException {
	processRequest(request, response);
	}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse
	response)
	throws ServletException, IOException {
	processRequest(request, response);
	}
	@Override
	public String getServletInfo() {
	return "Short description";
	}
}
