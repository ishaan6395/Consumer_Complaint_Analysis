package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class queries_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>JSP Page</title>\n");
      out.write("        <style type=\"text/css\">\n");
      out.write("            .btn{\n");
      out.write("                color:blue;\n");
      out.write("                text-decoration: underline;\n");
      out.write("            }\n");
      out.write("            .btn:hover{\n");
      out.write("                cursor:pointer;\n");
      out.write("                font-weight: bold;\n");
      out.write("            }\n");
      out.write("        </style>\n");
      out.write("    </head>\n");
      out.write("    <body style=\"margin-left: 20px\">\n");
      out.write("        <br/>\n");
      out.write("        <div id=\"querylist\">\n");
      out.write("            &nbsp;&nbsp;&nbsp;<span> 1) See Number of Complaints By companies</span> &nbsp; \n");
      out.write("            <span class=\"btn\">Go</span><br/><Br/> \n");
      out.write("            &nbsp;&nbsp;&nbsp;&nbsp;<span>2) See top <input type=\"text\" style=\"max-width: 20px\"/> companies with complaints\n");
      out.write("            </span> &nbsp;<span class=\"btn\">Go</span><br/><Br/>\n");
      out.write("            &nbsp;&nbsp;&nbsp;<span>3) See subissue's \n");
      out.write("            <select>\n");
      out.write("                <option>hi</option>\n");
      out.write("            </select> &nbsp; Issue\n");
      out.write("            </span> &nbsp;\n");
      out.write("            <span class=\"btn\">Go</span><br/><Br/>\n");
      out.write("            &nbsp;&nbsp;&nbsp;<span>4) See subproduct's \n");
      out.write("            <select>\n");
      out.write("                <option>hi</option>\n");
      out.write("            </select> &nbsp; Product\n");
      out.write("            </span> &nbsp;\n");
      out.write("            <span class=\"btn\">Go</span> <br/><Br/>\n");
      out.write("            \n");
      out.write("            &nbsp;&nbsp;&nbsp;<span>5) See total responses of &nbsp;<input type=\"text\" style=\"max-width: 20px;\"> &nbsp; companies \n");
      out.write("            \n");
      out.write("            </span> &nbsp;\n");
      out.write("            <span class=\"btn\">Go</span> <br/><Br/>\n");
      out.write("            \n");
      out.write("            &nbsp;&nbsp;&nbsp;<span>6) See total responses of &nbsp;<input type=\"text\" style=\"max-width: 20px;\"> &nbsp; companies \n");
      out.write("            \n");
      out.write("            </span> &nbsp;\n");
      out.write("            <span class=\"btn\">Go</span> <br/><Br/>\n");
      out.write("        </div>\n");
      out.write("        <div id=\"queryoutput\">\n");
      out.write("            \n");
      out.write("        </div>\n");
      out.write("    </body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
