package TinTuc.DAO;

import java.util.List;

import org.springframework.stereotype.Repository;

import TinTuc.Entity.MapperRole;
import TinTuc.Entity.Role;

@Repository
public class RoleDAO extends BaseDAO{

	@Override
	public void delete(int id) {
		//System.out.println(delete(id, "role").toString());
		jdbcTemplate.execute(delete(id, "role").toString());
	}
	
	public List<Role> getAllRole(){
		return jdbcTemplate.query(getAll("role").toString(), new MapperRole());
	}
	
	public Role getRoleByID(int id) {
		return jdbcTemplate.query(getAll("role").append(" WHERE id = ").append(id).toString(), new MapperRole()).get(0);
	}
	
	public void insertRole(String roleName) {
		StringBuffer sb = new StringBuffer();
		sb.append("INSERT INTO role(name) VALUES ('").append(roleName).append("');");
		jdbcTemplate.execute(sb.toString());
	}
	
	public void updateRole(int id_role, String name) {
		StringBuffer sb = new StringBuffer();
		sb.append("UPDATE role");
		sb.append(" SET name = '");
		sb.append(name);
		sb.append("' WHERE id = ");
		sb.append(id_role);
		System.out.println(sb.toString());
		//jdbcTemplate.execute(sb.toString());
	}
}
