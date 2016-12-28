package br.com.alura.gerenciador.web;

import javax.servlet.http.Cookie;

public class Cookies {

	private Cookie[] cookies;

	public Cookies(Cookie[] cookies) {
		this.cookies = (cookies != null) ? cookies : new Cookie[0];
	}

	public Cookie getUsuarioLogado() {
		for (Cookie cookie : cookies) {
			if (cookie.getName().equals("usuarioLogado")) {
				return cookie;
			}
		}

		return null;
	}

}
