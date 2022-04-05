package repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Autore;
import model.AutoreLibro;
import model.Libro;

public class Database {

	private static Database instance;
	private Connection con;

	private final static String DB_URL = "jdbc:mysql://localhost:3306/generation";
	private final static String DB_USER = "app_generation";
	private final static String DB_PASSWORD = "generation_2022";
	private final static String DB_DRIVER = "com.mysql.cj.jdbc.Driver";

	private Database() throws SQLException, ClassNotFoundException {
		//costruttore che ottiene connessione al database
		Class.forName(DB_DRIVER);
		con = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
	}

	public static Database getDatabase() throws ClassNotFoundException, SQLException {
		if (instance == null) {
			instance = new Database();
		}
		return instance;
	}

	

	

	public List<Libro> getAllLibri() throws SQLException {
		String sql = "SELECT id, titolo, prezzo, pagine "
				+ "FROM generation.libro";
		PreparedStatement istruzione = con.prepareStatement(sql);
		ResultSet risultatiQuery = istruzione.executeQuery();
		List<Libro> listaLibri = new ArrayList<>();
		while(risultatiQuery.next()) {//sto dicendo fallo finchè c'è qualcosa dopo .next()
			//Per ogni recordo crea un nuovo oggetto studente
			Libro libro = new Libro();
			//Ci imposto dentro le varie colonne della sua riga
			libro.setId(risultatiQuery.getInt("id"));
			libro.setTitolo(risultatiQuery.getString("titolo"));
			libro.setPrezzo(risultatiQuery.getDouble("prezzo"));
			libro.setPagine(risultatiQuery.getInt("pagine"));
			
			//Lo aggiungo alla lista degli studenti
			listaLibri.add(libro);
		}//fine while
		return listaLibri;
		
	}
	
	public Libro getLibroById(int id) throws SQLException{
		String sql="SELECT id, titolo, prezzo, pagine "
				+ " FROM generation.libro "
				+ " WHERE id=? ; ";
		
		PreparedStatement istruzione= con.prepareStatement(sql);		
		istruzione.setInt(1, id);
		
		//executeQuery si usa per le SELECT
		ResultSet risultatiQuery=istruzione.executeQuery();
		while(risultatiQuery.next()) {
			Libro lib=new Libro();
			lib.setId(risultatiQuery.getInt("id"));
			lib.setTitolo(risultatiQuery.getString("titolo"));
			lib.setPrezzo(risultatiQuery.getFloat("prezzo"));
			lib.setPagine(risultatiQuery.getInt("pagine"));
			
			
			return lib;
		}
		
		return null;
	}
		
		public boolean insertLibro(Libro lib) throws SQLException{
			String sql="INSERT INTO generation.libro"
					+ " (titolo, prezzo, pagine)"
					+ " VALUES(?, ?, ?);";
			
			PreparedStatement istruzione= con.prepareStatement(sql);
			
			
			istruzione.setString(1, lib.getTitolo());
			istruzione.setFloat(2, (float) lib.getPrezzo());
			istruzione.setInt(3, lib.getPagine());
			
			
			//executeUpdate si usa per INSERT, UPDATE, DELETE
			int numRigheModificate=istruzione.executeUpdate();
			
			if(numRigheModificate==1) return true;
			
			return false;
		
	}
		
		
		public int updateLibro(Libro lib) throws SQLException{
			String sql="UPDATE generation.libro"
					+ " SET id=?, titolo=?, prezzo=?, pagine=? "
					+ " WHERE id=? ; ";
			
			PreparedStatement istruzione= con.prepareStatement(sql);
			
			istruzione.setInt(1, lib.getId());
			istruzione.setString(2, lib.getTitolo());
			istruzione.setFloat(3, (float) lib.getPrezzo());
			istruzione.setInt(4, lib.getPagine());
			
			
			istruzione.setInt(5, lib.getId());
			
			//executeUpdate si usa per INSERT, UPDATE, DELETE
			return istruzione.executeUpdate();
			
		}
		
		public int deleteLibro(Libro lib) throws SQLException{
			String sql="DELETE FROM generation.libro WHERE id=? ; ";
			
			PreparedStatement istruzione= con.prepareStatement(sql);		
			istruzione.setInt(1, lib.getId());
			
			//executeUpdate si usa per INSERT, UPDATE, DELETE
			return istruzione.executeUpdate();
		}
	
	public List<Autore> getAllAutori() throws SQLException {
		String sql = "SELECT id, nome, cognome, nazionalita "
				+ "FROM generation.autore";
		PreparedStatement istruzione = con.prepareStatement(sql);
		ResultSet risultatiQuery = istruzione.executeQuery();
		
		List<Autore> listaAutori = new ArrayList<>();
		
		while(risultatiQuery.next()) {//sto dicendo fallo finchè c'è qualcosa dopo .next()
			//Per ogni recordo crea un nuovo oggetto studente
			Autore autore = new Autore();
			//Ci imposto dentro le varie colonne della sua riga
			autore.setId(risultatiQuery.getInt("id"));
			autore.setNome(risultatiQuery.getString("nome"));
			autore.setCognome(risultatiQuery.getString("cognome"));
			autore.setNazionalita(risultatiQuery.getString("nazionalita"));
			
			//Lo aggiungo alla lista degli studenti
			listaAutori.add(autore);
		}//fine while
		return listaAutori;
	}
	
	public Autore getAutoreById(int id) throws SQLException{
		String sql="SELECT id, nome, cognome, nazionalita "
				+ " FROM generation.autore "
				+ " WHERE id=? ; ";
		
		PreparedStatement istruzione= con.prepareStatement(sql);		
		istruzione.setInt(1, id);
		
		//executeQuery si usa per le SELECT
		ResultSet risultatiQuery=istruzione.executeQuery();
		while(risultatiQuery.next()) {
			Autore a=new Autore();
			a.setId(risultatiQuery.getInt("id"));
			a.setNome(risultatiQuery.getString("nome"));
			a.setCognome(risultatiQuery.getString("cognome"));
			a.setNazionalita(risultatiQuery.getString("nazionalita"));
			
			
			return a;
		}
		
		return null;
	}
		
		public boolean insertAutore(Autore a) throws SQLException{
			String sql="INSERT INTO generation.autore"
					+ " (nome, cognome, nazionalita)"
					+ " VALUES(?, ?, ?);";
			
			PreparedStatement istruzione= con.prepareStatement(sql);
			
			
			istruzione.setString(1, a.getNome());
			istruzione.setString(2, a.getCognome());
			istruzione.setString(3, a.getNazionalita());
			
			
			//executeUpdate si usa per INSERT, UPDATE, DELETE
			int numRigheModificate=istruzione.executeUpdate();
			
			if(numRigheModificate==1) return true;
			
			return false;
		
	}
		
		
		public int updateAutore(Autore a) throws SQLException{
			String sql="UPDATE generation.autore"
					+ " SET id=?, nome=?, cognome=?, nazionalita=? "
					+ " WHERE id=? ; ";
			
			PreparedStatement istruzione= con.prepareStatement(sql);
			
			istruzione.setInt(1, a.getId());
			istruzione.setString(2, a.getNome());
			istruzione.setString(3, a.getCognome());
			istruzione.setString(4, a.getNazionalita());
			
			
			istruzione.setInt(5, a.getId());
			
			//executeUpdate si usa per INSERT, UPDATE, DELETE
			return istruzione.executeUpdate();
			
		}
	
	
	public int deleteAutore(int idAutore) throws SQLException {
		String sql= "DELETE FROM generation.autore "
				+ "WHERE id = ?";
		
		PreparedStatement istruzione = con.prepareStatement(sql);
		
		istruzione.setInt(1, idAutore);
		
		return istruzione.executeUpdate();

}
	
	
	
	public List<AutoreLibro> getAllAutoriLibri() throws SQLException {
		String sql = "SELECT "
					+ "al.autore_id, "
					+ "al.libro_id, "
					+ "a.cognome, "
					+ "l.titolo, "
					+ "l.prezzo "
					+ "FROM generation.autore_libro al "
					+ "JOIN generation.autore a ON (a.id = al.autore_id) "
					+ "JOIN generation.libro l ON (l.id = al.libro_id)";
		
		PreparedStatement istruzione = con.prepareStatement(sql);
		ResultSet risultatiQuery = istruzione.executeQuery();
		
		List<AutoreLibro> listaAutoriLibri = new ArrayList<>();
		
		while(risultatiQuery.next()) {//sto dicendo fallo finchè c'è qualcosa dopo .next()
			//Per ogni recordo crea un nuovo oggetto studente
			AutoreLibro autoreLibro = new AutoreLibro();
			//Ci imposto dentro le varie colonne della sua riga
			autoreLibro.setAlAutoreId(risultatiQuery.getInt("al.autore_id"));
			autoreLibro.setAlLibroId(risultatiQuery.getInt("al.libro_id"));
			autoreLibro.setaCognome(risultatiQuery.getString("a.cognome"));
			autoreLibro.setlTitolo(risultatiQuery.getString("l.titolo"));
			autoreLibro.setlPrezzo(risultatiQuery.getDouble("l.prezzo"));
			
			//Lo aggiungo alla lista degli studenti
			listaAutoriLibri.add(autoreLibro);
		}//fine while
		return listaAutoriLibri;
	}
	
	public boolean insertAutoreLibro(AutoreLibro al) throws SQLException{
		String sql="INSERT INTO generation.autore_libro"
				+ " (autore_id, libro_id)"
				+ " VALUES(?, ?);";
		
		PreparedStatement istruzione= con.prepareStatement(sql);
		
		
		istruzione.setInt(1, al.getAlAutoreId());
		istruzione.setInt(2, al.getAlLibroId());
		
		
		
		//executeUpdate si usa per INSERT, UPDATE, DELETE
		int numRigheModificate=istruzione.executeUpdate();
		
		if(numRigheModificate==1) return true;
		
		return false;
	
}
	
	public int deleteAutoreLibro(AutoreLibro al) throws SQLException{
		String sql="DELETE FROM generation.autore_libro WHERE autore_id=? ; ";
		
		PreparedStatement istruzione= con.prepareStatement(sql);		
		istruzione.setInt(1, al.getAlAutoreId());
		
		//executeUpdate si usa per INSERT, UPDATE, DELETE
		return istruzione.executeUpdate();
	}
	
	//semplice controllo se ci sono righe coinvolte nel delete
	public int getAutoriInAutoriLibri(int idAutore) throws SQLException {
		String sql= "SELECT count(*) AS counter "
				+ "FROM generation.autore_libro al "
				+ "WHERE al.autore_id = ?";
		
		PreparedStatement istruzione = con.prepareStatement(sql);
		
		istruzione.setInt(1, idAutore);
		
		ResultSet risultatiQuery = istruzione.executeQuery();
		int counter = 0;
		while(risultatiQuery.next()) {
			counter =  risultatiQuery.getInt("counter");
		}
		
		return counter;
				
				
		
	}
	

}
