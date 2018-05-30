package p5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import java.util.Date;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class ReizigerOracleDaolmpl extends OracleBaseDAO implements ReizigerDao  {
	
	@Override
	public List<Reiziger> findAll() throws SQLException {
		Statement stmt = getConnection().createStatement();
		String query = "SELECT * FROM [MSDAO].[dbo].[reiziger]";
		List<Reiziger> reizigers = new ArrayList<Reiziger>();
		ResultSet rs = stmt.executeQuery(query);
		
		while (rs.next()) {   
			reizigers.add(new Reiziger(rs.getInt("REIZIGERID"),rs.getString("VOORLETTERS"),rs.getString("TUSSENVOEGSEL"),rs.getString("ACHTERNAAM"), rs.getDate("GEBORTEDATUM")));
			
		}
		closeConnection();
		return reizigers;
	}
	
	@Override
	public Reiziger findByGBdatum(String GBdatum) throws ParseException, SQLException {
		String query = "SELECT * FROM [MSDAO].[dbo].[reiziger] WHERE GEBORTEDATUM = ?";
		PreparedStatement stmt = getConnection().prepareStatement(query);
		java.sql.Date utilDate = java.sql.Date.valueOf(GBdatum);
		stmt.setDate(1 , utilDate);
		ResultSet rs = stmt.executeQuery();
		rs.next();
		Reiziger r = new Reiziger(rs.getInt("REIZIGERID"),rs.getString("VOORLETTERS"),rs.getString("TUSSENVOEGSEL"),rs.getString("ACHTERNAAM"), rs.getDate("GEBORTEDATUM"));
		closeConnection();
		return r;
	}
	
	@Override
	public Reiziger save(Reiziger reiziger) throws SQLException {
		String query = "INSERT INTO [MSDAO].[dbo].[reiziger] (REIZIGERID, VOORLETTERS, TUSSENVOEGSEL,ACHTERNAAM, GEBORTEDATUM) VALUES(id_increment.NEXTVAL , ?, ?, ?, ?)";
		PreparedStatement stmt = getConnection().prepareStatement(query);
		stmt.setString(1 , reiziger.getVoorletters());
		stmt.setString(2 , reiziger.getTussenvoegsel());
		stmt.setString(3 , reiziger.getAchternaam());
		String date = reiziger.getGbdatum().toString();
		java.sql.Date utilDate = java.sql.Date.valueOf(date);
		stmt.setDate(4, utilDate);
		
		stmt.executeUpdate();
		closeConnection();
		return reiziger;
	}
	@Override
	public Reiziger update(Reiziger reiziger) throws SQLException {
		String query = "UPDATE [MSDAO].[dbo].[reiziger] SET VOORLETTERS = ?, ACHTERNAAM = ?,  GEBORTEDATUM = ? WHERE REIZIGERID = ?";
		PreparedStatement stmt = getConnection().prepareStatement(query);
		stmt.setString(1 , reiziger.getVoorletters());
//		stmt.setString(2 , reiziger.getTussenvoegsel());
		stmt.setString(2 , reiziger.getAchternaam());
		String date = reiziger.getGbdatum().toString();
		java.sql.Date utilDate = java.sql.Date.valueOf(date);
		stmt.setDate(3, utilDate);
		System.out.println(reiziger.getReizigerID());
		stmt.setInt(4, reiziger.getReizigerID());
		stmt.executeUpdate();
		closeConnection();
		return reiziger;
	}
	@Override
	public boolean delete(Reiziger reiziger) throws SQLException {
		String query = "DELETE FROM [MSDAO].[dbo].[reiziger] WHERE REIZIGERID = ?";
		PreparedStatement stmt = getConnection().prepareStatement(query);
		System.out.println(reiziger.getReizigerID());
		stmt.setInt(1, reiziger.getReizigerID());
		int value = stmt.executeUpdate();
		
		closeConnection();
		if(value == 1) {
			return true;
		} else {
			return false;
		}
	}



}
