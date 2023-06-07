package stuInfo.servlets;

import stuInfo.dto.Grade;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 描述：
 * 作者：小陶不慌张
 * 文件：GradePageServlet
 * 日期：2023/3/3 10:43
 */
@WebServlet("/GradePageServlet")
public class GradePageServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        Grade grade = (Grade)req.getAttribute("grade");

        //2.设置响应头
        resp.setStatus(200);
        resp.setContentType("text/html;charset=utf-8");
        resp.setCharacterEncoding("utf-8");

        //3.响应成绩结果页面
        PrintWriter out = resp.getWriter();
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<meta charset='utf-8'>");
        out.println("<title>学生成绩查询系统</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<table border='1' width='100%' height='700'>");
        out.println("<tr height='100'><td colspan='2'><label>学生成绩查询系统欢迎您！</label></td></tr>");
        out.println("<tr>");
        out.println("<td width='200'>2-1</td>");
        out.println("<td align='center' valign='top'>");
        out.println("<form action='GradeQueryServlet' method='post'>");
        //查询成绩的表单 ： 修改action属性为 GradeQueryServlet
        out.println("<h3>查询结果</h3>");
        if(grade != null){
            out.println("<table width='200' border='1' cellspacing='0'>");
            out.println("<tr><td>学号</td><td>"+grade.getSnum()+"</td></tr>");
            out.println("<tr><td>姓名</td><td>"+grade.getSname()+"</td></tr>");
            out.println("<tr><td>课程ID</td><td>"+grade.getCid()+"</td></tr>");
            out.println("<tr><td>课程名</td><td>"+grade.getCname()+"</td></tr>");
            out.println("<tr><td>成绩</td><td><label style='color:red;font-weight:bold'>"+grade.getScore()+"</label></td></tr>");
            out.println("</table>");
        }else{
            out.println("<label style='color:red;font-weight:bold;font-size:20px'>学号或课程号有误!</label>");
        }
        out.println("<a href='IndexPageServlet'>继续查询</a>");
        out.println("</td>");
        out.println("</tr>");
        out.println("</table>");
        out.println("</body>");
        out.println("</html>");
        out.flush();
        out.close();
    }
}
