package controller;
 
import java.sql.SQLException;
import java.util.List;

import model.Autore;
import model.AutoreLibro;
import model.Libro;
import repository.Database;
 
public class AutoreLibroController {
 
	private static AutoreLibroController instance;
 
	private Database db;
 
	public AutoreLibroController() throws ClassNotFoundException, SQLException {
		db = Database.getDatabase();
	}
 
	public static AutoreLibroController getController() throws ClassNotFoundException, SQLException {
		if (instance == null) {
			instance = new AutoreLibroController();
		}
		return instance;
	}	
 
	public List<AutoreLibro> getAllAutoriLibri() throws SQLException{
		return db.getAllAutoriLibri();
	}
	
	public boolean insertAutoreLibro(int a_id, int l_id) throws SQLException{
		AutoreLibro daInserire=new AutoreLibro();
		
		daInserire.setAlAutoreId(a_id);
		daInserire.setAlLibroId(l_id);;
		
		
		
		return db.insertAutoreLibro(daInserire);
	}
	
	public int deleteAutoreLibro(int id) throws SQLException{
		AutoreLibro daCancellare=new AutoreLibro();
		daCancellare.setAlAutoreId(id);
		
		return db.deleteAutoreLibro(daCancellare);
	}
}
 