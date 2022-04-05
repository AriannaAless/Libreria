package presentation;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Libro;

import java.io.IOException;
import java.sql.SQLException;

import controller.AutoreLibroController;
import controller.LibroController;

@WebServlet("/insertAutoreLibro")
public class InsertAutoreLibro extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private AutoreLibroController controller;
	
	public InsertAutoreLibro() throws ClassNotFoundException, SQLException {
		super();
		controller=AutoreLibroController.getController();
	}

	
	//Solitamente usato per richiedere dati al server
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			int a_id=Integer.parseInt(request.getParameter("a_id"));
			int l_id=Integer.parseInt(request.getParameter("l_id"));
			
			boolean nRigheAggiornate=controller.insertAutoreLibro(a_id, l_id);
			
			if(nRigheAggiornate==true)
				request.setAttribute("avvisoMessaggio", "Relazione inserita con successo");
			else
				request.setAttribute("avvisoMessaggio", "Anomalia, non inserita.");
			
		}catch(Exception e) {
			e.printStackTrace();
			request.setAttribute("avvisoMessaggio", e.getMessage());
		}
		
		request.getRequestDispatcher("listaAutoriLibri").forward(request, response);
	}
}
