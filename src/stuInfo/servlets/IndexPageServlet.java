package stuInfo.servlets;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 描述：登陆成功主页面
 * 作者：小陶不慌张
 * 文件：IndexPageServlet
 * 日期：2023/3/2 19:51
 */
@WebServlet("/IndexPageServlet")
public class IndexPageServlet extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setStatus(200);
        resp.setContentType("text/html;charset=utf-8");
        resp.setCharacterEncoding("UTF-8");

        PrintWriter out = resp.getWriter();
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<meta charset='UTF-8'>");
        out.println("<title>学生成绩查询系统</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<table border='1' width='100%' height='700'>");
        out.println("<tr height='100'><td colspan='2'><label>学生成绩查询系统</label></td></tr>");
        out.println("<tr>");
        out.println("<td width='200'>2-1</td>");
        out.println("<td align='center' valign='top'>");
        out.println("<form action='GradeQueryServlet' method='post'>");
        out.println("<h3>查询成绩</h3>");
        out.println("<p>学号：<input type='text' name='stuNum' placeholder='学生学号'/></p>" );
        out.println("<p>课程：<input type='text' name='courseId' placeholder='课程编号'/></p> " );
        out.println("<p><input type='submit' value='查询'/></p>");
        out.println("</form>");
        out.println("</td>");
        out.println("</tr>");
        out.println("</table>");
        out.println("</body>");
        out.println("</html>");
        out.flush();
        out.close();
    }

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
       // doGet(req, resp);
    }
}
