package presentation;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Libro;

import java.io.IOException;
import java.sql.SQLException;

import controller.AutoreController;
import controller.LibroController;

@WebServlet("/insertAutore")
public class InsertAutore extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private AutoreController controller;
	
	public InsertAutore() throws ClassNotFoundException, SQLException {
		super();
		controller=AutoreController.getController();
	}

	
	//Solitamente usato per richiedere dati al server
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String nome=request.getParameter("nome");
			String cognome=request.getParameter("cognome");
			String nazionalita=request.getParameter("nazionalita");
						
			boolean nRigheAggiornate=controller.insertAutore(nome, cognome, nazionalita);
			
			if(nRigheAggiornate==true)
				request.setAttribute("avvisoMessaggio", "Autore inserito con successo");
			else
				request.setAttribute("avvisoMessaggio", "Anomalia, non inserito.");
			
		}catch(Exception e) {
			e.printStackTrace();
			request.setAttribute("avvisoMessaggio", e.getMessage());
		}
		
		request.getRequestDispatcher("listaAutori").forward(request, response);
	}
}
