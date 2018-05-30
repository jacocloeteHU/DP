package p5;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

public interface OV_ChipkaartDao {
	public List<OV_Chipkaart> findAll() throws SQLException;
	public OV_Chipkaart findByPrimaryKey(int pmKey) throws ParseException, SQLException;
	public List<OV_Chipkaart> findByReiziger(int pmKey) throws ParseException, SQLException;
	public List<OV_Chipkaart> findOVByProductPrimaryKey(int pmKey) throws SQLException, ParseException;
	public OV_Chipkaart save(OV_Chipkaart ov) throws SQLException;
	public OV_Chipkaart update(OV_Chipkaart ov) throws SQLException;
	public boolean delete(OV_Chipkaart ov) throws SQLException;
}
