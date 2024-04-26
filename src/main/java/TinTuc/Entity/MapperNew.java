package TinTuc.Entity;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class MapperNew implements RowMapper<New>{

	@Override
	public New mapRow(ResultSet rs, int rowNum) throws SQLException {
		New n = new New();
		n.setId(rs.getInt(1));
		n.setTitle(rs.getString(2));
		n.setSlug(rs.getString(3));
		n.setSummary(rs.getString(4));
		n.setContent(rs.getString(5));
		n.setAuthor(rs.getInt(6));
		n.setPosting_date(rs.getDate(7));
		n.setApproval_date(rs.getDate(8));
		n.setView(rs.getInt(9));
		n.setImage(rs.getString(10));
		n.setVideo(rs.getString(11));
		n.setStatus(rs.getBoolean(12));
		n.setId_category(rs.getInt(13));
		n.setId_property(rs.getInt(14));
		return n;
	}

}
