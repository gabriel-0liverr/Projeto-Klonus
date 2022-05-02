package ads.projetointegrador.klonus.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ads.projetointegrador.klonus.action.Action;


public class Controller extends HttpServlet{
	
	private static final long serialVersionUID = 1L;

	@Override @SuppressWarnings("deprecation")
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String resource = req.getRequestURI().substring(req.getContextPath().length()+1);		
	
		System.out.println(resource);
		
		String responsePath = null;
		try {
			Class<?> resourceClass = 
					Class.forName("ads.projetointegrador.klonus.action."+resource);
			Action resourceAction = (Action) resourceClass.newInstance();
			responsePath = resourceAction.execute(req, resp);
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
			e.printStackTrace();
		}
		
		String justPath = responsePath.substring(responsePath.indexOf(":")+1);
		String redirection = responsePath.substring(0, responsePath.indexOf(":"));
		if(redirection.equals("forward")) {
			RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/" + justPath);
			rd.forward(req, resp);
		}else {
			resp.sendRedirect(justPath);
		}

	}
}
