package com.cw.common.taglib;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.BodyTagSupport;

import org.apache.log4j.Logger;
import org.apache.taglibs.standard.lang.support.ExpressionEvaluatorManager;

/**
 * 系统样式、JavaScript、title、keyword通用标签
 * 
 * @author yuanguangjie
 *
 */
public class ThemeTag extends BodyTagSupport {

	// 创建log日志对象
	private Logger log = Logger.getLogger(ThemeTag.class);

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 *  标签，这里设置为网页标题，必填
	 */
	private Object title;

	/**
	 *  关键字，meta标签中，name为keyword时，设置的content内容，用于SEO优化使用，非必填字段
	 */
	private Object keyword;

	/**
	 *  编码集，meta标签属性http-equiv中设置的charset编码集，设置为整个网页的编码集，必填
	 */
	private Object charset;

	public Object getCharset() {
		return charset;
	}

	public void setCharset(Object charset) {
		try {
			this.charset = ExpressionEvaluatorManager.evaluate("charset", charset.toString(), Object.class,
					this.pageContext);
		} catch (JspException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public Object getTitle() {
		return title;
	}

	public void setTitle(Object title) {

		try {

			// 让自定义标签支持el表达式
			this.title = ExpressionEvaluatorManager.evaluate("title", title.toString(), Object.class, this.pageContext);
		} catch (JspException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public Object getKeyword() {
		return keyword;
	}

	public void setKeyword(Object keyword) {
		try {
			this.keyword = ExpressionEvaluatorManager.evaluate("keyword", keyword.toString(), Object.class,
					this.pageContext);
		} catch (JspException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 *  重写父类doEndTag方法，将网页头部信息输出在jsp页面上，通用每个页面中的css/js/及头部设置和url设置
	 */
	public int doEndTag() throws JspException {

		log.info("传入的title值---》》》" + this.title + ",关键字值为----》》》" + this.keyword+",编码集设置----》》》"+charset);

		// 获取request
		HttpServletRequest request = (HttpServletRequest) this.pageContext.getRequest();

		// 获取项目路径
		String contextPath = request.getContextPath();

		// 用于拼接html头部标签
		StringBuffer html = new StringBuffer();

		html.append("<base href=\"" + contextPath + "/\">");
		html.append("<title>" + this.title + "</title>");
		html.append("<meta name=\"keywords\" content=\"" + this.keyword + "\">");

		html.append("<meta http-equiv=\"Content-Type\" content=\"text/html; charset="+this.charset+"\">");
			
		html.append("<meta http-equiv=\"charset\" content=\""+this.charset+"\">");
		
		html.append("<meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge,chrome=1\">");
		
		html.append("<script type=\"text/javascript\" src=\"" + contextPath
				+ "/resources/js/jquery/jquery-1.9.0.min.js\"></script>");

		html.append("<script type=\"text/javascript\" src=\"" + contextPath + "/resources/js/all.js\"></script>");

		html.append("<script type=\"text/javascript\" src=\"" + contextPath
				+ "/resources/bootstrap/js/bootstrap.min.js\"></script>");

		html.append("<script type=\"text/javascript\" src=\"" + contextPath
				+ "/resources/bootstrap/js/bootstrap-datetimepicker.js\"></script>");

		html.append("<script type=\"text/javascript\" src=\"" + contextPath
				+ "/resources/bootstrap/js/bootstrap-datetimepicker.zh-CN.js\"></script>");

		html.append("<link rel=\"shortcut icon\"	href=\"" + contextPath + "/resources/images/favicon.ico\" />");

		html.append(
				"<link href=\"" + contextPath + "/resources/bootstrap/css/bootstrap-huan.css\" rel=\"stylesheet\">");

		html.append("<link href=\"" + contextPath
				+ "/resources/font-awesome/css/font-awesome.min.css\" rel=\"stylesheet\">");

		html.append("<link href=\"" + contextPath
				+ "/resources/bootstrap/css/bootstrap-datetimepicker.min.css\" rel=\"stylesheet\">");

		html.append("<link href=\"" + contextPath + "/resources/css/style.css\" rel=\"stylesheet\">");

		try {
			// 将标签输出至页面
			this.pageContext.getOut().write(html.toString());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return super.doEndTag();
	}

}
