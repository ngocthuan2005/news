package TinTuc.DAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public abstract class BaseDAO {
	@Autowired
	protected JdbcTemplate jdbcTemplate;
	
	public abstract void delete(int id);
	
	protected StringBuffer delete(int id, String tableName) {
		StringBuffer sqlDelete = new StringBuffer();
		sqlDelete.append("DELETE FROM ");
		sqlDelete.append(tableName);
		sqlDelete.append(" WHERE id = ");
		sqlDelete.append(id);
		return sqlDelete;
	}
	
	protected StringBuffer getAll(String tableName) {
		StringBuffer sqlBuffer = new StringBuffer();
		sqlBuffer.append("SELECT * FROM ");
		sqlBuffer.append(tableName);
		return sqlBuffer;
	}
	
	protected StringBuffer sqlDataNewDTO() {
		StringBuffer sb = new StringBuffer();
		sb.append("SELECT new.image, user.name AS author, new.title AS newTitle, property.title AS propertyTitle, new.approval_date AS approvalDate, property.slug AS propertySlug, new.slug AS newSlug, category.slug AS categorySlug, category.title AS categoryTitle, new.view, new.summary AS summary,property.id AS idProperty, category.id AS idCategory FROM new, property, category, user WHERE new.id_property = property.id AND property.id_category = category.id AND category.id = new.id_category AND new.author = user.id AND status = 1");
		return sb;
	}
}

