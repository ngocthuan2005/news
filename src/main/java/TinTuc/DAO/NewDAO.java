package TinTuc.DAO;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.validation.constraints.AssertTrue;

import org.springframework.stereotype.Repository;

import TinTuc.DTO.Admin.MapperDetailAdmin;
import TinTuc.DTO.Admin.MapperNewDTOAdmin;
import TinTuc.DTO.Admin.NewDTOAdmin;
import TinTuc.DTO.User.CommentDTO;
import TinTuc.DTO.User.MapperCommentDTO;
import TinTuc.DTO.User.MapperNewDTO;
import TinTuc.DTO.User.MapperNewDetailDTO;
import TinTuc.DTO.User.NewDTO;
import TinTuc.DTO.User.NewDetailDTO;
import TinTuc.Entity.MapperNew;
import TinTuc.Entity.New;

@Repository
public class NewDAO extends BaseDAO {

	@Override
	public void delete(int id) {
		jdbcTemplate.execute(delete(id, "new").toString());
	}

	public List<New> getAllNew() {
		return jdbcTemplate.query(getAll("new").toString(), new MapperNew());
	}

	public New getNewByID(int id) {
		return jdbcTemplate.query(getAll("new").append(" WHERE new.id = '").append(id).append("' LIMIT 1;").toString(),
				new MapperNew()).get(0);
	}

	public New getNewBySlug(String slug) {
		return jdbcTemplate
				.query(getAll("new").append(" WHERE new.slug = '").append(slug).append("' LIMIT 1;").toString(),
						new MapperNew())
				.get(0);
	}

	public List<New> getDataNewUpdate() {
		String sql = getAll("new ").append("ORDER BY `new`.`approval_date` DESC LIMIT 10;").toString();
		return jdbcTemplate.query(sql, new MapperNew());
	}

	public List<NewDTO> getDataLimitSix() {
		StringBuffer sb = sqlDataNewDTO().append(" ORDER BY RAND() LIMIT 6;");
		List<NewDTO> list = jdbcTemplate.query(sb.toString(), new MapperNewDTO());
		return list;
	}

	public List<CommentDTO> getCommentByNew(String slug) {
		// String sql = "SELECT user.name AS author, new.title AS newTitle,
		// property.title AS propertyTitle, new.approval_date AS approvalDate,
		// category.slug AS categorySlug, property.slug AS propertySlug, category.title
		// AS categoryTitle, new.view AS view, new.content AS content, (SELECT
		// COUNT(comments_likes.like) FROM new, comments_likes WHERE new.id =
		// comments_likes.id_new AND new.slug = '" + slug + "') AS likes, (SELECT
		// COUNT(comments_likes.content) FROM comments_likes, new WHERE new.id =
		// comments_likes.id AND new.slug = '" + slug + "') AS countComment FROM user,
		// new, category, property WHERE user.id = new.author AND property.id =
		// new.id_property AND new.id_category = category.id AND status = 1 AND new.slug
		// = '" + slug + "';";
		// return jdbcTemplate.query(sql, new MapperCommentDTO());
		return null;
	}

	public NewDetailDTO getNewDetailBySlug(String slug) {
		String sql = "SELECT user.name AS author, new.title AS newTitle, property.title AS propertyTitle, new.approval_date AS approvalDate, category.slug AS categorySlug, property.slug AS propertySlug, category.title AS categoryTitle, new.view AS view, new.content AS content, (SELECT COUNT(likes.like) FROM new, likes WHERE new.id = likes.id_new AND new.slug = '"
				+ slug
				+ "' AND likes.like = true) AS likes, (SELECT COUNT(comments.id) FROM comments, new WHERE new.id = comments.id_new AND new.slug = '"
				+ slug
				+ "' AND new.status = 1) AS countComment, new.image, new.author AS authorID, new.id_property AS idProperty, new.slug AS newSlug FROM user, new, category, property WHERE user.id = new.author AND property.id = new.id_property AND new.id_category = category.id AND new.status = 1 AND new.slug = '"
				+ slug + "' LIMIT 1;";
		return jdbcTemplate.query(sql, new MapperNewDetailDTO()).get(0);
	}

	public List<Map<Integer, Integer>> getCommentByIdNew() {
		// String sql = "SELECT A"
		return null;
	}

	public List<NewDTO> getNewByAuthor(int author) {
		String sql = sqlDataNewDTO().append(" AND new.author = " + author + "  LIMIT 3;").toString();
		return jdbcTemplate.query(sql, new MapperNewDTO());
	}

	public List<NewDTO> getNewByProperty(int propertyID) {
		String sql = sqlDataNewDTO().append(" AND new.id_property = ").append(propertyID).append(" LIMIT 3;")
				.toString();
		return jdbcTemplate.query(sql, new MapperNewDTO());
	}

	public List<NewDTOAdmin> getDataNewAdminByIDAuthor(int idAuthor) {
		String sql = "SELECT new.id AS idNew, new.title AS newTitle, "
				+ "property.title AS property, category.title AS category, user.name "
				+ "AS author, new.status, new.approval_Date AS approvalDate, user.id AS idUser "
				+ "FROM category, property, user, role, new WHERE category.id = new.id_category AND new.id_property = property.id AND new.author = user.id AND user.id_role = role.id AND new.author = "
				+ idAuthor;
		return jdbcTemplate.query(sql, new MapperNewDTOAdmin());
	}

	public List<NewDTOAdmin> getDataNewAdminAll() {
		return jdbcTemplate.query(sqlDataNewAdminAll(), new MapperNewDTOAdmin());
	}

	private String sqlDataNewAdminAll() {
		String sql = "SELECT new.id AS idNew, new.title AS newTitle, "
				+ "property.title AS property, category.title AS category, user.name "
				+ "AS author, new.status, new.approval_Date AS approvalDate, user.id AS idUser "
				+ "FROM category, property, user, role, new WHERE category.id = new.id_category AND new.id_property = property.id AND new.author = user.id GROUP BY new.id";
		return sql;
	}
	
	private StringBuffer sqlDataNewAdminAll(int start, int totalOnOnePage) {
		StringBuffer sb = new StringBuffer();
		sb.append(sqlDataNewAdminAll());
		sb.append(" LIMIT ").append(start).append(", ").append(totalOnOnePage);
		return sb;
	}
	
	
	public List<NewDTOAdmin> getDataNewAdminAll(int start, int totalOnOnePage) {
		return jdbcTemplate.query(sqlDataNewAdminAll(start, totalOnOnePage).toString(), new MapperNewDTOAdmin());
	}
	
	public void insertNew(String title, String slug, String summary, String content, int author, String posting_date,
			String image, String video, int id_property, int id_category) {
		StringBuffer sb = new StringBuffer();
		sb.append("INSERT INTO new(");
		sb.append("title, slug, summary, content, author, posting_date, image, video, id_property, id_category)");
		sb.append(" VALUES (");
		sb.append("'").append(title).append("',");
		sb.append("'").append(slug).append("',");
		sb.append("'").append(summary).append("',");
		sb.append("'").append(content).append("',");
		sb.append(author).append(",");
		sb.append("'").append(posting_date).append("', ");
		sb.append("'").append(image).append("', ");
		sb.append("'").append(video).append("', ");
		sb.append(id_property).append(", ");
		sb.append(id_category).append(");");
		jdbcTemplate.execute(sb.toString());
	}

	public void updateNew(int id, String title, String slug, String summary, String content, String posting_date,
			String approval_date, String image, String video, int id_property, int id_category) {
		StringBuffer sb = new StringBuffer();
		sb.append("UPDATE new SET ");
		sb.append("title = ").append("'").append(title).append("', ");
		sb.append("slug = ").append("'").append(slug).append("', ");
		sb.append("summary = ").append("'").append(summary).append("', ");
		sb.append("content = ").append("'").append(content).append("', ");
		sb.append("posting_date = ").append("'").append(posting_date).append("', ");
		sb.append("approval_date = ").append("'").append(approval_date).append("', ");
		sb.append("image = ").append("'").append(image).append("', ");
		sb.append("video = ").append("'").append(video).append("', ");
		sb.append("id_property = ").append(id_property).append(", ");
		sb.append("id_category = ").append(id_category).append(" ");
		sb.append("WHERE new.id = ").append(id);
		System.out.println(sb.toString());
		//jdbcTemplate.execute(sb.toString());
	}

	public void updateNew(int id, boolean status) {
		StringBuffer sb = new StringBuffer();
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date date = Calendar.getInstance().getTime();
		sb.append("UPDATE new SET ");
		sb.append("status = ").append(status);
		sb.append(", approval_date = ");
		if (status) {
			sb.append("'").append(dateFormat.format(date)).append("' ");
		} else {
			sb.append("NULL ");
		}
		sb.append("WHERE new.id = ").append(id);
		jdbcTemplate.execute(sb.toString());
	}

	public void deleteNew(int id) {
		delete(id);
	}

	public NewDetailDTO getNewDetailAdmin(int id) {
		String sql = "SELECT new.image, new.title, user.name, new.posting_date, new.content FROM new, user WHERE new.author = user.id AND new.id = "
				+ id;
		return jdbcTemplate.query(sql, new MapperDetailAdmin()).get(0);
	}
}
