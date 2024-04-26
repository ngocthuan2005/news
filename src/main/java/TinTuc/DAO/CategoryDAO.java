package TinTuc.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import TinTuc.DTO.User.MapperNewDTO;
import TinTuc.DTO.User.NewDTO;
import TinTuc.Entity.Category;
import TinTuc.Entity.MapperCategory;

@Repository
public class CategoryDAO extends BaseDAO{
	
	public List<Category> getDataCategories(){
		String sql = getAll("category").toString();
		return jdbcTemplate.query(sql, new MapperCategory());
	}
	
	public String getBreadcrumby(String categorySlug){
		String sql = "SELECT title FROM category WHERE slug = '" + categorySlug +"';";
		return jdbcTemplate.query(sql, new RowMapper<String>() {
			@Override
			public String mapRow(ResultSet rs, int rowNum) throws SQLException {
				return rs.getString(1);
			}
		}).get(0);
	}
	
	public List<NewDTO> getDataCategoryBySlug(String slug) {
		StringBuffer sb = sqlDataNewDTO().append(" AND category.slug = '").append(slug).append("';");
		return jdbcTemplate.query(sb.toString(), new MapperNewDTO());
	}
	
	public List<NewDTO> getDataCategoryBySlug(String slug, int limit) {
		StringBuffer sb = sqlDataNewDTO().append(" AND category.slug = '").append(slug).append("'").append(" ORDER BY RAND() ");
		return jdbcTemplate.query(sb.append("LIMIT ").append(limit).toString(), new MapperNewDTO());
	}
	
	public List<NewDTO> getAllDataNewByCategory(){
		String sql = sqlDataNewDTO().append(" ORDER BY category.id;").toString();
		return jdbcTemplate.query(sql, new MapperNewDTO());
	}
	
	@Override
	public void delete(int id) {
		jdbcTemplate.execute(delete(id, "category").toString());
	}

	public void addCategory(String title, String slug, int idUser) {
		
	}
}
