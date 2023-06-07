package stuInfo.servlets;

import stuInfo.dto.Student;
import stuInfo.dao.StudentDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 描述：
 * 作者：小陶不慌张
 * 文件：CheckServlet
 * 日期：2023/3/2 20:20
 */
@WebServlet("/CheckServlet")
public class CheckServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("CheckServlet");
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        //接收学号和密码
        String num = req.getParameter("stuNum");
        String pwd = req.getParameter("stuPwd");

        StudentDAO studentDAO = new StudentDAO();
        Student student = studentDAO.queryStudentByNumAndPwd(num, pwd);
        //判断查询结果响应给不同客户端页面


        //根据登录验证的不同结果响应给客户端不同的页面
        if(student == null){
            //转发到下一个Servlet是可以通过request传递数据过去的
           req.setAttribute("tips","登陆失败，学号或密码错误");
           //转发到LoginPageServlet:在当前Servlet类的Post方法转到，也会转到下一个Servlet的doPost
           req.getRequestDispatcher("login").forward(req,resp);
        }else{
            //重定向到IndexPageServlet:无需传递参数到IndexPageServlet,所以可以重定向
            resp.sendRedirect("IndexPageServlet");
            //登录成功：响应客户端系统的主页
        }


    }
}
