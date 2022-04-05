package presentation;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import model.Libro;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import controller.AutoreLibroController;
import controller.LibroController;


@WebServlet("/deleteAutoreLibro")
public class DeleteAutoreLibro extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private AutoreLibroController controller;
	
	public DeleteAutoreLibro() throws ClassNotFoundException, SQLException {
		super();
		controller=AutoreLibroController.getController();
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			int idDaCancellare=Integer.parseInt(request.getParameter("deleteId"));
			int nRecordCancellati=controller.deleteAutoreLibro(idDaCancellare);
			if(nRecordCancellati==1)
				request.setAttribute("avvisoMessaggio", "Relazione cancellata con successo");
			else
				request.setAttribute("avvisoMessaggio", "Anomalia, cancellati "+nRecordCancellati+" records.");
			
		}catch(Exception e) {
			e.printStackTrace();
			request.setAttribute("avvisoMessaggio", e.getMessage());
		}
		
		request.getRequestDispatcher("listaLibri").forward(request, response);
	}

}