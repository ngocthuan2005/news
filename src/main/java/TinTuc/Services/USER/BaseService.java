package TinTuc.Services.USER;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import TinTuc.DAO.CategoryDAO;
import TinTuc.DAO.Comment_LikeDAO;
import TinTuc.DAO.NewDAO;
import TinTuc.DAO.PropertyDAO;
import TinTuc.DAO.RoleDAO;
import TinTuc.DAO.UserDAO;

@Service
public abstract class BaseService {
	@Autowired
	protected CategoryDAO categoryDAO;
	@Autowired
	protected PropertyDAO propertyDAO;
	@Autowired
	protected NewDAO newDAO;
	@Autowired 
	protected Comment_LikeDAO commentLikeDAO;
	@Autowired
	protected UserDAO userDAO;
	@Autowired
	protected RoleDAO roleDAO;
}
