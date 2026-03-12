package code.figueroa.filter.login;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

import code.figueroa.controllers.servlet.user.*;
import code.figueroa.models.usuario.Usuario;
import code.figueroa.services.login.LoginServices;
import code.figueroa.services.login.LoginServicesImpl;


@WebFilter({"/Usuario/*","/DashboardServlet","/FilterSession"})//Rutas url donde se aplica el filtro 1 - n
public class FilterSession extends HttpFilter implements Filter {//El paquete que se importa es del jakarta.servlet
       
   
    public FilterSession() {
        super();
        
    }
	
	public void destroy() {
		
	}

	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		System.out.println("Filtro Ejecutado");
		LoginServices getSessionLogin = new LoginServicesImpl(); 
		
		Usuario sesionU =  getSessionLogin.getSessionUserName((HttpServletRequest)request, "usuario");
		
		if(sesionU != null) {
		
		chain.doFilter(request, response);
		
		}else {
			 ((HttpServletResponse)response).sendRedirect(((HttpServletRequest)request).getContextPath() + "/login.jsp");
	}



	}
}
