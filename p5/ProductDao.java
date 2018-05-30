package p5;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

public interface ProductDao {
	public List<Product> findAll() throws SQLException;
	public Product findByPrimaryKey(int pmKey) throws ParseException, SQLException;
	public List<Product> findProductByOVPrimaryKey(int pmKey) throws SQLException, ParseException;
//	public List<Product> findByReiziger(int pmKey) throws ParseException, SQLException;
	public Product save(Product ov) throws SQLException;
	public Product update(Product ov) throws SQLException;
	public boolean delete(Product ov) throws SQLException;
}
