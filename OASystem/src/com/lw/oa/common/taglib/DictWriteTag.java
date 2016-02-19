package com.lw.oa.common.taglib;

import java.io.IOException;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;
import org.apache.commons.lang.StringUtils;
import com.lw.oa.common.dao.DictDAOImpl;
import com.lw.oa.common.dao.IDictDAO;
import com.lw.system.framework.fa004.FA004001ResultCommand;
import com.lw.system.framework.fa004.FA004001SearchCommand;

public class DictWriteTag extends TagSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = -1937587583221600494L;
	private String value;
	private String busiDictTypeId;
	
	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getBusiDictTypeId() {
		return busiDictTypeId;
	}

	public void setBusiDictTypeId(String busiDictTypeId) {
		this.busiDictTypeId = busiDictTypeId;
	}

	private IDictDAO dictDAOImpl;

	public DictWriteTag() {
		// TODO Auto-generated constructor stub
		dictDAOImpl = new DictDAOImpl();
	}

	@Override
	public int doEndTag() throws JspException {
		// TODO Auto-generated method stub
		FA004001SearchCommand searchCommand = new FA004001SearchCommand();
		searchCommand.setBusidicttypeid(this.getBusiDictTypeId());
		searchCommand.setBusidictid(this.getValue());
		String busidictname = StringUtils.EMPTY;
		if (!StringUtils.isEmpty(this.getValue())) {
			FA004001ResultCommand command = (FA004001ResultCommand) dictDAOImpl.expandByObj("fa.fa004.fa004001searchDictById", searchCommand);	
			if(command == null)
				busidictname = StringUtils.EMPTY;
			else
				busidictname = command.getBusidictname();
		}
		JspWriter out = pageContext.getOut();
		StringBuffer sb = new StringBuffer();
		sb.append(busidictname);		
		try {
			out.write(sb.toString());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			throw new JspException(e);
		}
		
		return TagSupport.EVAL_PAGE;
	}

	@Override
	public int doStartTag() throws JspException {
		// TODO Auto-generated method stub
		return super.doStartTag();
	}

}
