package p5;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

public interface ReizigerDao {
	
	public List<Reiziger> findAll() throws SQLException;
	public Reiziger findByGBdatum(String GBdatum) throws ParseException, SQLException;
	public Reiziger save(Reiziger reiziger) throws SQLException;
	public Reiziger update(Reiziger reiziger) throws SQLException;
	public boolean delete(Reiziger reiziger) throws SQLException;
	
}
