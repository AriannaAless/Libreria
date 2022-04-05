package presentation;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Libro;

import java.io.IOException;
import java.sql.SQLException;
import controller.LibroController;

@WebServlet("/insertLibro")
public class InsertLibro extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private LibroController controller;
	
	public InsertLibro() throws ClassNotFoundException, SQLException {
		super();
		controller=LibroController.getController();
	}

	
	//Solitamente usato per richiedere dati al server
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String titolo=request.getParameter("titolo");
			Float prezzo=Float.parseFloat(request.getParameter("prezzo"));
			int pagine =Integer.parseInt(request.getParameter("pagine"));
						
			boolean nRigheAggiornate=controller.insertLibro(titolo, prezzo, pagine);
			
			if(nRigheAggiornate==true)
				request.setAttribute("avvisoMessaggio", "Libro inserito con successo");
			else
				request.setAttribute("avvisoMessaggio", "Anomalia, non inserito.");
			
		}catch(Exception e) {
			e.printStackTrace();
			request.setAttribute("avvisoMessaggio", e.getMessage());
		}
		
		request.getRequestDispatcher("listaLibri").forward(request, response);
	}
}
