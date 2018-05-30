package p5;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

public class ProductOracleDaolmpl extends OracleBaseDAO  implements ProductDao {

//	@perride
	public List<Product> findAll() throws SQLException {
		String query = "SELECT * FROM [MSDAO].[dbo].[Product]";
		Statement stmt = getConnection().createStatement();
		List<Product> p = new ArrayList<Product>();

		ResultSet rs = stmt.executeQuery(query);
		while (rs.next()) {   
			p.add(new Product(rs.getInt("productNummer"),rs.getString("productNaam"),rs.getString("beschrijving"),rs.getDouble("Prijs")));	
		}
		closeConnection();
		return p;
	}

//	@perride
	public Product findByPrimaryKey(int pmKey) throws ParseException, SQLException {
		String query = "SELECT * FROM [MSDAO].[dbo].[Product] WHERE productNummer = ?";
		PreparedStatement stmt = getConnection().prepareStatement(query);
		stmt.setInt(1 , pmKey);
		ResultSet rs = stmt.executeQuery();
		Product p = null;
		while (rs.next()) {
			p = new Product(rs.getInt("productNummer"),rs.getString("productNaam"),rs.getString("beschrijving"),rs.getDouble("Prijs"));
		}
		closeConnection();
		return p;
	}
	
	public List<Product> findProductByOVPrimaryKey(int pmKey) throws SQLException, ParseException {
		String query = "SELECT * FROM [MSDAO].[dbo].[Product] c LEFT JOIN [MSDAO].[dbo].[OV_CHIPKAART_PRODUCT] t ON c.productNummer = t.productNummer  WHERE t.kaartNummer = ?";
		PreparedStatement stmt = getConnection().prepareStatement(query);
		stmt.setInt(1 , pmKey);
		ResultSet rs = stmt.executeQuery();
		List<Product> p = new ArrayList<Product>();
		while (rs.next()) {
			p.add(new Product(rs.getInt("productNummer"),rs.getString("productNaam"),rs.getString("beschrijving"),rs.getDouble("Prijs")));	
		}
		closeConnection();
		return p;
	}

//	@perride
	public Product save(Product p) throws SQLException {
		String query = "INSERT INTO [MSDAO].[dbo].[Product] (productNummer, productNaam, beschrijving,prijs) VALUES(? , ?, ?, ?)";
		PreparedStatement stmt = getConnection().prepareStatement(query);
		stmt.setInt(1 , p.getProductNummer());
		stmt.setString(2 , p.getProductNaam());
		stmt.setString(3 , p.getBeschrijving());
		stmt.setDouble(4, p.getPrijs());
		
		stmt.executeUpdate();
		closeConnection();
		return p;
	}

//	@perride
	public Product update(Product p) throws SQLException {
		String query = "UPDATE [MSDAO].[dbo].[Product] SET productNaam = ?, beschrijving = ?,  prijs = ? WHERE productNummer = ?";
		PreparedStatement stmt = getConnection().prepareStatement(query);
		
		
		stmt.setString(1 , p.getProductNaam());
		stmt.setString(2 , p.getBeschrijving());
		stmt.setDouble(3, p.getPrijs());
		stmt.setInt(4 , p.getProductNummer());
		stmt.executeUpdate();
		closeConnection();
		return p;
	}

//	@perride
	public boolean delete(Product p) throws SQLException {
		String query = "DELETE FROM [MSDAO].[dbo].[Product] WHERE productNummer = ?";
		PreparedStatement stmt = getConnection().prepareStatement(query);
		System.out.println(p.getProductNummer());
		stmt.setInt(1, p.getProductNummer());
		int value = stmt.executeUpdate();
		
		closeConnection();
		if(value == 1) {
			return true;
		} else {
			return false;
		}
	}

}
