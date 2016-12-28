package br.com.alura.gerenciador.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/controller")
public class Controller extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public Controller() {
		System.out.println("Instanciando uma Servlet do tipo Controller " + this);
	}
	
	@Override
	public void init() throws ServletException {
		super.init();
		System.out.println("Inicializando uma Servlet do tipo Controller " + this);
	}
	
	@Override
	public void destroy() {
		super.destroy();
		System.out.println("Destruindo uma Servlet do tipo Controller " + this);
	}
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		String tarefa = (String) req.getParameter("tarefa");
		
		if (tarefa == null) {
			throw new IllegalArgumentException("Tarefa não informada");
		}
		
		tarefa = "br.com.alura.gerenciador.web." + tarefa;
		
		try {
			Class<?> classe = Class.forName(tarefa);
			Tarefa instancia = (Tarefa) classe.newInstance();
			
			String pagina = instancia.executa(req, resp);
			
			if (pagina != null) {
				req.getRequestDispatcher(pagina).forward(req, resp);;
			}
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
			throw new ServletException(e);
		}
	}
	
}
