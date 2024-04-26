package TinTuc.Entity;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class MapperProperty implements RowMapper<Property>{

	@Override
	public Property mapRow(ResultSet rs, int rowNum) throws SQLException {
		Property property = new Property();
		property.setId(rs.getInt(1));
		property.setTitle(rs.getNString(2));
		property.setSlug(rs.getNString(3));
		property.setId_category(rs.getInt(4));
		return property;
	}

}
