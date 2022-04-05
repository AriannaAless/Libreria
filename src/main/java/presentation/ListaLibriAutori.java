package presentation;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Autore;
import model.AutoreLibro;
import model.Libro;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import controller.AutoreController;
import controller.AutoreLibroController;

@WebServlet ("/listaAutoriLibri")
public class ListaLibriAutori extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    private AutoreLibroController controller;
    
    public ListaLibriAutori() throws ClassNotFoundException, SQLException {
        super();
        controller = AutoreLibroController.getController();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<AutoreLibro> listaAutoriLibri;
		try {
			listaAutoriLibri = controller.getAllAutoriLibri();
			request.setAttribute("listaAutoriLibri", listaAutoriLibri);
			
			} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		request.getRequestDispatcher("listaAutoriLibri.jsp").forward(request, response);
		
		
		}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
