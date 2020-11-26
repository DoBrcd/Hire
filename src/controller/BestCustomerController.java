package controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/stats")
public class BestCustomerController extends BaseController {

	BestCustomerController()
	{
		super();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		if(isAuthenticated(req, resp))
		{
			if(!employeeService.canAccessStats(getEmployee(req)))
				redirectToHome(req, resp);
			else
			{
				resp.setContentType("text/html");
				PrintWriter out = resp.getWriter();
				out.println("<html>");
				out.println("<head><title>Hello World Best Customer</title></head>");
				out.println("<body>");
				out.println("<h1>Hello World test !</h1>");
				out.println("</body></html>");
			}
		}
	}
}
