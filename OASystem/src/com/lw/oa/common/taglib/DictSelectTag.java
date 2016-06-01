package com.lw.oa.common.taglib;

import java.io.IOException;
import java.util.List;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;
import org.apache.commons.lang.StringUtils;
import com.lw.oa.common.dao.DictDAOImpl;
import com.lw.oa.common.dao.IDictDAO;
import com.lw.system.framework.fa004.FA004001ResultCommand;
import com.lw.system.framework.fa004.FA004001SearchCommand;

public class DictSelectTag extends TagSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = -1937587583221600494L;
	private String value;
	private String busiDictTypeId;
	private String name;
	private String id;
	private String cssClass;
	private String styleClass;
	private String multiple;
	private String onChange;
	private String nullLabel;
	private String required;
	private String title;
	
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCssClass() {
		return cssClass;
	}

	public void setCssClass(String cssClass) {
		this.cssClass = cssClass;
	}

	public String getStyleClass() {
		return styleClass;
	}

	public void setStyleClass(String styleClass) {
		this.styleClass = styleClass;
	}

	public String getMultiple() {
		return multiple;
	}

	public void setMultiple(String multiple) {
		this.multiple = multiple;
	}

	public String getOnChange() {
		return onChange;
	}

	public void setOnChange(String onChange) {
		this.onChange = onChange;
	}

	public String getNullLabel() {
		return nullLabel;
	}

	public void setNullLabel(String nullLabel) {
		this.nullLabel = nullLabel;
	}

	
	public String getRequired() {
		return required;
	}

	public void setRequired(String required) {
		this.required = required;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}


	private IDictDAO dictDAOImpl;

	public DictSelectTag() {
		// TODO Auto-generated constructor stub
		dictDAOImpl = new DictDAOImpl();
	}

	@Override
	public int doEndTag() throws JspException {
		// TODO Auto-generated method stub
		FA004001SearchCommand searchCommand = new FA004001SearchCommand();
		searchCommand.setBusidicttypeid(this.getBusiDictTypeId());
		@SuppressWarnings("unchecked")
		List<FA004001ResultCommand> list = (List<FA004001ResultCommand>) dictDAOImpl
				.queryByObj("fa.fa004.fa004001searchDictById", searchCommand);
		JspWriter out = pageContext.getOut();
		StringBuffer sb = new StringBuffer();
		sb.append("<select  ");
		if (!StringUtils.isEmpty(this.getId())) {
			sb.append("id=\"" + this.getId() + "\" ");
		}
		if (!StringUtils.isEmpty(this.getName())) {
			sb.append("name=\"" + this.getName() + "\" ");
		}
		if (!StringUtils.isEmpty(this.getCssClass())) {
			sb.append("class=\"" + this.getCssClass() + "\" ");
		}
		if (!StringUtils.isEmpty(this.getStyleClass())) {
			sb.append("style=\"" + this.getStyleClass() + "\" ");
		}
		if (!StringUtils.isEmpty(this.getMultiple())) {
			sb.append("multiple=\"" + this.getMultiple() + "\" ");
		}
		if (!StringUtils.isEmpty(this.getOnChange())) {
			sb.append("onchange=\"" + this.getOnChange() + "\" ");
		}
		if (!StringUtils.isEmpty(this.getRequired())) {
			sb.append("required=\"" + this.getRequired() + "\" ");
		}
		if (!StringUtils.isEmpty(this.getTitle())) {
			sb.append("title=\"" + this.getTitle() + "\" ");
		}
		sb.append(">");
		if (!StringUtils.isEmpty(this.getNullLabel())) {
			sb.append("<option value=\"\">"+this.getNullLabel()+"</option>");
		}
		for (FA004001ResultCommand command : list) {
			if (command.getBusidictid().equals(this.getValue())) {
				sb.append("<option value=\"" + command.getBusidictid()
						+ "\" selected=\"selected\">");
			} else {
				sb.append("<option value=\"" + command.getBusidictid() + "\">");
			}
			sb.append(command.getBusidictname() + "</option>");
		}
		sb.append("</select>");
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
