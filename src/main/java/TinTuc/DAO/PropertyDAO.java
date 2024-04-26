package TinTuc.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.instrument.classloading.jboss.JBossLoadTimeWeaver;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import TinTuc.DTO.User.MapperNewDTO;
import TinTuc.DTO.User.NewDTO;
import TinTuc.Entity.MapperProperty;
import TinTuc.Entity.Property;

@Repository
public class PropertyDAO extends BaseDAO{

	@Override
	public void delete(int id) {
		jdbcTemplate.execute(delete(id, "property").toString());
	}
	
	public List<Property> getAllProperty(){
		return jdbcTemplate.query(getAll("property").toString(), new MapperProperty());
	}
	
	public List<String> getDataBreadcrumby(String categorySlug, String propertySlug) {
		StringBuffer sb = new StringBuffer();
		sb.append("SELECT category.title, property.title FROM property, category WHERE property.id_category = category.id AND category.slug = '");
		sb.append(categorySlug);
		sb.append("' AND property.slug = '");
		sb.append(propertySlug);
		sb.append("';");
		List<String> listStrings = new ArrayList<>();
		List<List<String>> list = jdbcTemplate.query(sb.toString(), 
				new RowMapper<List<String>>() {

					@Override
					public List<String> mapRow(ResultSet rs, int rowNum) throws SQLException {
						List<String> list = new ArrayList<>();
						list.add(rs.getString(1));
						list.add(rs.getString(2));
						return list;
					}
					
		});
		for (List<String> listString : list) {
			for (String str : listString) {
				listStrings.add(str);
			}
		}
		return listStrings;
	}
	
	public List<NewDTO> getPropertyBySlug(String categorySlug, String propertySlug){
		StringBuffer sb = sqlDataNewDTO().append(" AND category.slug = '").append(categorySlug).append("' AND property.slug = '").append(propertySlug).append("';");
		String sql = sb.toString();
		return jdbcTemplate.query(sql, new MapperNewDTO());
	}
	
}
