package TinTuc.Services;

import org.springframework.stereotype.Service;
import TinTuc.DTO.PaginatesDTO;

@Service
public interface PaginatesService {
	public PaginatesDTO getInfoPaginate(int totalPage, int limitPage, int currentPage);
}
