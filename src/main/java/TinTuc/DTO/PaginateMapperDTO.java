package TinTuc.DTO;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

public class PaginateMapperDTO implements RowMapper<PaginatesDTO> {

	@Override
	public PaginatesDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
		PaginatesDTO paginatesDTO = new PaginatesDTO();
		paginatesDTO.setCurrentPage(rs.getInt("currentpage"));
		paginatesDTO.setLimitPage(rs.getInt("limitpage"));
		paginatesDTO.setStartPage(rs.getInt("startpage"));
		paginatesDTO.setEndPage(rs.getInt("endpage"));
		paginatesDTO.setTotalPage(rs.getInt("totalpage"));
		return paginatesDTO;
	}
}