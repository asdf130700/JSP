/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.107
 * Generated at: 2020-12-03 08:36:43 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.io.PrintWriter;
import bbs.BbsDAO;
import bbs.Bbs;

public final class update_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
        throws java.io.IOException, javax.servlet.ServletException {

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text.html; charset=UTF-8\">\r\n");
      out.write("<meta name=\"viewport\" content=\"width=device-width\", initial-scale=\"1\">\r\n");
      out.write("<link rel=\"stylesheet\" href=\"css/bootstrap.css\">\r\n");
      out.write("<title>JSP 게시판 웹 사이트</title>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\r\n");
      out.write("\t\t\t");

	int bbsID = 0;
	if(request.getParameter("bbsID") != null){
			bbsID = Integer.parseInt(request.getParameter("bbsID"));

	}
	if(bbsID == 0){
		PrintWriter script = response.getWriter();
		script.println("<script>");
		script.println("alert('유효하지 않은 글입니다')");
		script.println("location.href = 'main.jsp'");
		script.println("</script>");
	}
	Bbs bbs = new BbsDAO().getBbs(bbsID);
	
	
      out.write("\r\n");
      out.write("\t<nav class=\"navbar navbar-default\">\r\n");
      out.write("\t<div class=\"navbar-header\">\r\n");
      out.write("\t<button type=\"button\" class=\"navbar-toggle collapsed\"\r\n");
      out.write("\tdata-toggle=\"collapse\" data-target=\"#bs-example-navbar-collapse-1\"\r\n");
      out.write("\taria-expanded=\"flase\">\r\n");
      out.write("\t<span class=\"icon-bar\"></span>\r\n");
      out.write("\t\t<span class=\"icon-bar\"></span>\r\n");
      out.write("\t\t\t<span class=\"icon-bar\"></span>\r\n");
      out.write("\t</button>\r\n");
      out.write("\t<a class=\"navbar-brand\" href=\"main.jsp\">JSP 게시판 웹 사이트</a>\r\n");
      out.write("\t</div>\r\n");
      out.write("\t<div class=\"collapse navbar-collapse\" id=\"bs-example-navbar-collapse-1\">\r\n");
      out.write("\t<ul class=\"nav navbar-nav\">\r\n");
      out.write("\t<li><a href=\"main.jsp\">메인</a></li>\r\n");
      out.write("\t\t<li><a href=\"bbs.jsp\">게시판</a></li>\r\n");
      out.write("\t</ul>\r\n");
      out.write("\t<ul class=\"nav navbar-nav navbar-right\">\r\n");
      out.write("\t<li class=\"dropdown\">\r\n");
      out.write("\t\t<a href=\"#\" class=\"dropdwon-toggle\"\r\n");
      out.write("\t\tdata-toggle=\"dropdown\" role=\"button\" aria-haspopup=\"true\"\r\n");
      out.write("\t\taria-expanded=\"false\">접속하기<span class=\"caret\"></span></a>\r\n");
      out.write("\t<ul class=\"dropdown-menu\">\r\n");
      out.write("\t\t<li class=\"active\"><a href=\"login.jsp\">로그인</a><li>\r\n");
      out.write("\t\t<li><a href=\"join.jsp\">회원가입</a></li>\r\n");
      out.write("\t</ul>\r\n");
      out.write("\t</li>\r\n");
      out.write("\t</ul>\r\n");
      out.write("\t</div>\r\n");
      out.write("\t</nav>\r\n");
      out.write("\t<div class =\"container\">\r\n");
      out.write("\t\t<div class=\"row>\">\r\n");
      out.write("\t\t<form method=\"post\" action=\"updateAction.jsp?bbsID=");
      out.print( bbsID );
      out.write("\">\r\n");
      out.write("\t\t\t<table class=\"table table-striped\" style=\"text-align: center; border: 1px solid #dddddd\">\r\n");
      out.write("\t\t\t<thead>\r\n");
      out.write("\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t<th colsapn=\"2\" style=\"background-color: #eeeeee; text-align: center;\">게시판 글수정 양식</th>\r\n");
      out.write("\t\t\t\t</tr>\r\n");
      out.write("\t\t\t</thead>\r\n");
      out.write("\t\t\t<tbody>\r\n");
      out.write("\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t<td><input type=\"text\" class=\"form-control\" placeholder=\"작성자\" name=\"userID\" maxlength=\"20\"value=\"");
      out.print(bbs.getUserID() );
      out.write("\"></td>\r\n");
      out.write("\t\t\t\t</tr> \r\n");
      out.write("\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t<td><input type=\"text\" class=\"form-control\" placeholder=\"글제목\" name=\"bbsTitle\" maxlength=\"50\" value=\"");
      out.print(bbs.getBbsTitle() );
      out.write("\"></td>\r\n");
      out.write("\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t<td><textarea type=\"text\" class=\"form-control\" placeholder=\"글 내용\" name=\"bbsContent\" maxlength=\"2048\" style=\"height:350px\">");
      out.print(bbs.getBbsContent() );
      out.write("</textarea></td>\r\n");
      out.write("\t\t\t\t</tr>\r\n");
      out.write("\t\t\t</tbody>\r\n");
      out.write("\t\t\t</table>\r\n");
      out.write("\t\t\t\t\t\t<input type=\"submit\" class=\"btn btn-primary pull-right\" value=\"수정하기\">\r\n");
      out.write("\t\t\t</form>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t</div>\r\n");
      out.write("\t<script src=\"http://code.jquery.com/jquery-3.1.1.min.js\"></script>\r\n");
      out.write("\t<script src=\"js/bootstrap.js\"></script>\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
