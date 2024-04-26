package TinTuc.Entity;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

public class MapperCategory implements RowMapper<Category>{

	@Override
	public Category mapRow(ResultSet rs, int rowNum) throws SQLException {
		Category category = new Category();
		category.setId(rs.getInt(1));
		category.setTitle(rs.getString(2));
		category.setSlug(rs.getString(3));
		category.setChubien(rs.getInt(4));
		return category;
	}
}
