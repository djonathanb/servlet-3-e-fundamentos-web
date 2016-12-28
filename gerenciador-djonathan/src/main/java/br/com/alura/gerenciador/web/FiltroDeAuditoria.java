package br.com.alura.gerenciador.web;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import br.com.alura.gerenciador.Usuario;

@WebFilter(urlPatterns = "/*")
public class FiltroDeAuditoria implements Filter {

	@Override
	public void destroy() {}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		String uri = httpRequest.getRequestURI();
		
		HttpSession session = httpRequest.getSession();
		Usuario usuarioLogado = (Usuario) session.getAttribute("usuarioLogado");
		String nomeUsuario = (usuarioLogado != null) ? usuarioLogado.getEmail() : "<deslogado>";
		
		System.out.println("Usuário " + nomeUsuario + " acessando a uri: " + uri);
		
		chain.doFilter(request, response);
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {}

}
