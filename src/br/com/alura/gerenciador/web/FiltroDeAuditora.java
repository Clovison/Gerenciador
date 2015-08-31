package br.com.alura.gerenciador.web;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.jasper.tagplugins.jstl.core.ForEach;

import br.com.alura.gerenciador.Usuario;


@WebFilter(urlPatterns="/*")
public class FiltroDeAuditora implements Filter {

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		    HttpServletRequest req = (HttpServletRequest) request;
		    HttpServletResponse resp = (HttpServletResponse) response;
		    String uri = req.getRequestURI();
		    String usuario = getUsuario(req);
		    
		    System.out.println("Usuário :"+ usuario +" acessando URI:" + uri);
		    
		   
		   
		         Cookies cookie = new  Cookies(req.getCookies());
		         if(cookie.getUsuarioLogado()!= null)
		    	 resp.addCookie(cookie.aumentaTempo());
		    	
		    	
		    System.out.println("Usuario:" +getUsuario(req));
		    
		    
		    chain.doFilter(request, response);
		
	}

	private String getUsuario(HttpServletRequest req) {
		
		Usuario usuario = (Usuario) req.getSession().getAttribute("usuarioLogado");
		if(usuario==null) return "<Deslogado>";
		return usuario.getEmail();
	}
	

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}

}
