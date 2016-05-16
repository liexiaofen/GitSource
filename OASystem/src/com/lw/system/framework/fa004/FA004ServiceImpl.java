package com.lw.system.framework.fa004;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;

import com.lw.oa.common.dao.IMybatisDAO;
import com.lw.oa.common.dao.MybatisDAOImpl;
import com.lw.oa.common.model.BusiDict;
import com.lw.oa.common.model.BusiDictType;
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

	@Override
	public FA004Command fa004001view(FA004001SearchCommand searchCommand) {
		// TODO Auto-generated method stub
		mybatisDAOImpl.openSession();
		FA004Command command = new FA004Command();
		command.setBusidicttypeid(searchCommand.getId());
		command.setBusidicttypename(searchCommand.getName());
		// 设置查询条件				
		HashMap<String,String> map = new HashMap<String, String>();
		map.put("id", searchCommand.getId());
		@SuppressWarnings("unchecked")
		List<BusiDict> list = (List<BusiDict>) mybatisDAOImpl
				.queryByObj("fa.fa004.fa004001queryDictById", map);
		command.setList(list);
		return command;
	}

	@Override
	public int fa004001delete(FA004001SearchCommand searchCommand,
			HttpServletRequest request) {
		// TODO Auto-generated method stub
		int flag = 1;
		BusiDictType[] busidicttype = searchCommand.getBusidicttype();
		try {
			mybatisDAOImpl.openSession();
			for(BusiDictType entity:busidicttype){			
				flag = mybatisDAOImpl.delete( "fa.fa004.fa004001PDBusiDictType", entity.getBusidicttypeid());	
				flag = mybatisDAOImpl.delete( "fa.fa004.fa004001PDBusiDict", entity.getBusidicttypeid());	
				if(flag < 1){
					mybatisDAOImpl.rollback();
					return flag;
				}	
			}
			mybatisDAOImpl.commit();
		} catch (Exception e) {
			mybatisDAOImpl.rollback();
			flag = 0;
			e.printStackTrace();
		} finally {
			mybatisDAOImpl.close();
		}
		return flag;
	}

	@Override
	public int fa004002update(FA004Command command, HttpServletRequest request) {
		// TODO Auto-generated method stub
		int flag = 1;
		try {
			mybatisDAOImpl.openSession();
			// 根据业务字典类型id删除业务字典表
			flag = mybatisDAOImpl.delete( "fa.fa004.fa004001PDBusiDict", command.getBusidicttypeid());	
			for(BusiDict entity:command.getBusidict()){			
				BusiDict busidict = new BusiDict();
				busidict.setBusidicttypeid(command.getBusidicttypeid());
				busidict.setBusidictid(entity.getBusidictid());
				busidict.setBusidictname(entity.getBusidictname());
				busidict.setSortno(new Integer(entity.getSortno()));
				busidict.setStatus("1");
				busidict.setRank("1");
				busidict.setSeqno("."+entity.getBusidictid()+".");
				mybatisDAOImpl.insert("common.insertBusidict", busidict);		
				if(flag < 1){
					mybatisDAOImpl.rollback();
					return flag;
				}	
			}			
			mybatisDAOImpl.commit();
		} catch (Exception e) {
			mybatisDAOImpl.rollback();
			flag = 0;
			e.printStackTrace();
		} finally {
			mybatisDAOImpl.close();
		}
		return 0;
	}

	@Override
	public int fa004003insert(FA004Command command, HttpServletRequest request) {
		// TODO Auto-generated method stub
		int flag = 1;
		try {
			mybatisDAOImpl.openSession();
			// 创建业务字典类型对象
			BusiDictType bicttype = new BusiDictType();
			bicttype.setBusidicttypeid(command.getBusidicttypeid());
			bicttype.setBusidicttypename(command.getBusidicttypename());
			bicttype.setRank("1");
			bicttype.setSeqno("."+command.getBusidicttypeid()+".");
			mybatisDAOImpl.insert("common.insertBusidicttype", bicttype);			
			for(BusiDict entity:command.getBusidict()){			
				BusiDict busidict = new BusiDict();
				busidict.setBusidicttypeid(command.getBusidicttypeid());
				busidict.setBusidictid(entity.getBusidictid());
				busidict.setBusidictname(entity.getBusidictname());
				busidict.setSortno(new Integer(entity.getSortno()));
				busidict.setStatus("1");
				busidict.setRank("1");
				busidict.setSeqno("."+entity.getBusidictid()+".");
				mybatisDAOImpl.insert("common.insertBusidict", busidict);		
				if(flag < 1){
					mybatisDAOImpl.rollback();
					return flag;
				}	
			}			
			mybatisDAOImpl.commit();
		} catch (Exception e) {
			mybatisDAOImpl.rollback();
			flag = 0;
			e.printStackTrace();
		} finally {
			mybatisDAOImpl.close();
		}
		return flag;
	}
	
}
