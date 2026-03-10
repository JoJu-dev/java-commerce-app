package code.figueroa.listener;

import jakarta.servlet.annotation.WebListener;
import jakarta.servlet.http.HttpSessionEvent;
import jakarta.servlet.http.HttpSessionListener;

@WebListener
public class NumeroUsuariosListener implements HttpSessionListener {

	private static int numeroUsuariosOnline = 0;

	@Override
	public void sessionCreated(HttpSessionEvent se) {
	
		this.numeroUsuariosOnline++;
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent se) {
		this.numeroUsuariosOnline--;
		System.out.println("session destruida");
	}
	
	public static int obtenerNumeroUsuarios() {
		return numeroUsuariosOnline;
	}
	
}
