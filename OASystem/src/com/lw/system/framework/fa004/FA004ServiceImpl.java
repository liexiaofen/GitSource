package com.lw.system.framework.fa004;

import java.util.List;
import org.springframework.stereotype.Service;
import com.lw.oa.common.dao.IMybatisDAO;
import com.lw.oa.common.dao.MybatisDAOImpl;
import com.lw.oa.common.util.ConstantUtil;

/**
 ** @author yuliang
 */
@Service("fa004Service")
public class FA004ServiceImpl implements IFA004Service,ConstantUtil {

	private IMybatisDAO mybatisDAOImpl;

	public FA004ServiceImpl() {
		// TODO Auto-generated constructor stub
		mybatisDAOImpl = new MybatisDAOImpl();
	}

	@Override
	public List<?> fa004001search(FA004001SearchCommand searchCommand) {
		// TODO Auto-generated method stub
		mybatisDAOImpl.openSession();
		@SuppressWarnings("unchecked")
		List<FA004001ResultCommand> list = (List<FA004001ResultCommand>) mybatisDAOImpl
				.queryByObj("fa.fa004.fa004001searchListByPage", searchCommand);
		mybatisDAOImpl.close();
		return list;
	}
}
