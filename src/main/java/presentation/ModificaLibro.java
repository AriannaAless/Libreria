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

@WebServlet("/modificaLibro")
public class ModificaLibro extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private LibroController controller;
	
	public ModificaLibro() throws ClassNotFoundException, SQLException {
		super();
		controller=LibroController.getController();
	}

	//Solitamente usato per richiedere dati al server
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			int idDaModificare=Integer.parseInt(request.getParameter("modificaId"));
			Libro lib = controller.getLibroById(idDaModificare);
			request.setAttribute("id", lib.getId());
			request.setAttribute("titolo", lib.getTitolo());
			request.setAttribute("prezzo", lib.getPrezzo());
			request.setAttribute("pagine", lib.getPagine());
			
		}catch(Exception e) {
			e.printStackTrace();
			request.setAttribute("avvisoMessaggio", e.getMessage());
		}
		
		request.getRequestDispatcher("ModificaLibro.jsp").forward(request, response);
	}
	
	//Solitamente usato per richiedere dati al server
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			int id = Integer.parseInt(request.getParameter("id"));
			String titolo=request.getParameter("titolo");
			Float prezzo=Float.parseFloat(request.getParameter("prezzo"));
			int pagine =Integer.parseInt(request.getParameter("pagine"));
						
			int nRigheAggiornate=controller.updateLibro(id, titolo, prezzo, pagine);
			
			if(nRigheAggiornate==1)
				request.setAttribute("avvisoMessaggio", "Libro aggiornato con successo");
			else
				request.setAttribute("avvisoMessaggio", "Anomalia, aggiornati "+nRigheAggiornate+" records.");
			
		}catch(Exception e) {
			e.printStackTrace();
			request.setAttribute("avvisoMessaggio", e.getMessage());
		}
		
		request.getRequestDispatcher("listaLibri").forward(request, response);
	}
}
