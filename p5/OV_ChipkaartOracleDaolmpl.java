package p5;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

public class OV_ChipkaartOracleDaolmpl extends OracleBaseDAO  implements OV_ChipkaartDao{

	@Override
	public List<OV_Chipkaart> findAll() throws SQLException {
		String query = "SELECT * FROM [MSDAO].[dbo].[OV_Chipkaart]";
		Statement stmt = getConnection().createStatement();
		List<OV_Chipkaart> ovCps = new ArrayList<OV_Chipkaart>();

		ResultSet rs = stmt.executeQuery(query);
		while (rs.next()) {   
			ovCps.add(new OV_Chipkaart(rs.getInt("KAARTNUMMER"),rs.getDate("GELDIGTOT"),rs.getInt("KLASSE"),rs.getDouble("SALDO"), rs.getInt("REIZIGERID")));	
		}
		closeConnection();
		return ovCps;
	}

	@Override
	public List<OV_Chipkaart> findByReiziger(int pmkey) throws ParseException, SQLException {
		String query = "SELECT * FROM [MSDAO].[dbo].[OV_Chipkaart] WHERE REIZIGERID = ?";
		PreparedStatement stmt = getConnection().prepareStatement(query);
		List<OV_Chipkaart> ovCps = new ArrayList<OV_Chipkaart>();
		stmt.setInt(1 , pmkey);
		ResultSet rs = stmt.executeQuery();
		while (rs.next()) {   
			ovCps.add(new OV_Chipkaart(rs.getInt("KAARTNUMMER"),rs.getDate("GELDIGTOT"),rs.getInt("KLASSE"),rs.getDouble("SALDO"), rs.getInt("REIZIGERID")));	
		}
		closeConnection();
		return ovCps;
	}
	
	public List<OV_Chipkaart> findOVByProductPrimaryKey(int pmKey) throws SQLException, ParseException {
		String query = "SELECT * FROM [MSDAO].[dbo].[OV_Chipkaart] c LEFT JOIN [MSDAO].[dbo].[OV_CHIPKAART_PRODUCT] t ON c.kaartNummer = t.kaartNummer  WHERE t.productNummer = ?";
		PreparedStatement stmt = getConnection().prepareStatement(query);
		stmt.setInt(1 , pmKey);
		ResultSet rs = stmt.executeQuery();
		List<OV_Chipkaart> ov = new ArrayList<OV_Chipkaart>();
		while (rs.next()) {
			ov.add(new OV_Chipkaart(rs.getInt("KAARTNUMMER"),rs.getDate("GELDIGTOT"),rs.getInt("KLASSE"),rs.getDouble("SALDO"), rs.getInt("REIZIGERID")));
		}
		closeConnection();
		return ov;
	}
	
	@Override
	public OV_Chipkaart findByPrimaryKey(int pmKey) throws ParseException, SQLException {
		String query = "SELECT * FROM [MSDAO].[dbo].[OV_Chipkaart] WHERE KAARTNUMMER = ?";
		PreparedStatement stmt = getConnection().prepareStatement(query);
		stmt.setInt(1 , pmKey);
		ResultSet rs = stmt.executeQuery();
		OV_Chipkaart ovCK = null;
		while (rs.next()) {
			ovCK = new OV_Chipkaart(rs.getInt("KAARTNUMMER"),rs.getDate("GELDIGTOT"),rs.getInt("KLASSE"),rs.getDouble("SALDO"), rs.getInt("REIZIGERID"));
		}
		closeConnection();
		return ovCK;
	}

	@Override
	public OV_Chipkaart save(OV_Chipkaart ov) throws SQLException {
		String query = "INSERT INTO [MSDAO].[dbo].[OV_Chipkaart] (KAARTNUMMER, GELDIGTOT, KLASSE,SALDO, REIZIGERID) VALUES(? , ?, ?, ?, ?)";
		PreparedStatement stmt = getConnection().prepareStatement(query);
		stmt.setInt(1 , ov.getKaartNummer());

		String date = ov.getGeldigTot().toString();
		java.sql.Date utilDate = java.sql.Date.valueOf(date);
		stmt.setDate(2 , utilDate);
		stmt.setInt(3 , ov.getKlasse());
		stmt.setDouble(4, ov.getSaldo());
		stmt.setDouble(5, ov.getReizigerID());
		
		stmt.executeUpdate();
		closeConnection();
		return ov;
	}

	@Override
	public OV_Chipkaart update(OV_Chipkaart ov) throws SQLException {
		String query = "UPDATE [MSDAO].[dbo].[OV_Chipkaart] SET REIZIGERID = ?, GELDIGTOT = ?,  KLASSE = ?,  SALDO = ? WHERE KAARTNUMMER = ?";
		PreparedStatement stmt = getConnection().prepareStatement(query);
		
		stmt.setDouble(1, ov.getReizigerID());
		String date = ov.getGeldigTot().toString();
		java.sql.Date utilDate = java.sql.Date.valueOf(date);
		stmt.setDate(2 , utilDate);
		stmt.setInt(3 , ov.getKlasse());
		stmt.setDouble(4, ov.getSaldo());
		stmt.setInt(5 , ov.getKaartNummer());
		stmt.executeUpdate();
		closeConnection();
		return ov;
	}

	@Override
	public boolean delete(OV_Chipkaart ov) throws SQLException {
		String query = "DELETE FROM [MSDAO].[dbo].[OV_Chipkaart] WHERE KAARTNUMMER = ?";
		PreparedStatement stmt = getConnection().prepareStatement(query);
		System.out.println(ov.getKaartNummer());
		stmt.setInt(1, ov.getKaartNummer());
		int value = stmt.executeUpdate();
		
		closeConnection();
		if(value == 1) {
			return true;
		} else {
			return false;
		}
	}




}
