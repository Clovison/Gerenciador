package br.com.alura.gerenciador.web;

import javax.servlet.http.Cookie;



public class Cookies {
	private Cookie[] cookies; 
	private String usuario;
	
	public Cookies(Cookie[] cookies) {
		
		 this.cookies = cookies;
		
	}
	
	public Cookies() {
		// TODO Auto-generated constructor stub
	}


	public String getUsuarioLogado() {
		
		
		if(this.cookies == null) {
			return null;
		}else{
		
		for(Cookie cookie : this.cookies){

			if(cookie.getName().equals("usuario.logado")){
				this.setUsuario(cookie.getValue()); 
				
			}
		}
		return this.usuario;
	}
	}
	
	
	public Cookie usuarioDeslogado(){
		
		for(Cookie cookie : this.cookies){

			if(cookie.getName().equals("usuario.logado")){
				cookie.setMaxAge(0);
				return cookie;
			}
		}
		return null;
	}
	
	public Cookie aumentaTempo(){
		
			
		for(Cookie cookie : this.cookies){

			if(cookie.getName().equals("usuario.logado")){
				cookie.setMaxAge(10*60);
				return cookie;
			}
		}
		return null;
	}

	public Cookie[] getCookies() {
		return cookies;
	}


	public void setCookies(Cookie[] cookies) {
		this.cookies = cookies;
	}


	public String getUsuario() {
		return usuario;
	}


	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	
	
}
