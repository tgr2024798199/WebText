package stuInfo.servlets;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 描述：登录界面
 * 作者：小陶不慌张
 * 文件：LoginPageServlet
 * 日期：2023/3/2 13:20
 */
@WebServlet("/login")
public class LoginPageServlet extends HttpServlet{
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("-----doPost");
        doGet(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("----doGet");
        String tips =(String)request.getAttribute("tips");

        response.setStatus(200);
        response.setContentType("text/html;charset=utf-8");
        response.setCharacterEncoding("utf-8");

        PrintWriter out = response.getWriter();
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<meta charset='utf-8'>");
        out.println("<title>学生成绩查询系统-登录</title>");
        out.println("</head>");
        out.println("<body>");
        if(tips != null){
            out.println("<label style='color:red'>"+tips+"</label>");
        }
        out.println("<form action='CheckServlet' method='post'>");
        out.println("<h3>学生成绩查询系统-学生登录</h3>");
        out.println("<p>学号：<input type='text' name='stuNum' placeholder='学生学号'/></p>");
        out.println("<p>密码：<input type='password' name='stuPwd' placeholder='学生密码'/></p>");
        out.println("<p><input type='submit' value='登录'/></p>");
        out.println("</form>");
        out.println("</body>");
        out.println("</html>");
        out.flush();
        out.close();
    }


}
