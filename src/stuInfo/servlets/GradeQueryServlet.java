package stuInfo.servlets;

import stuInfo.dao.GradeDAO;
import stuInfo.dto.Grade;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 描述：根据学号、课程号查成绩
 * 作者：小陶不慌张
 * 文件：GradeQueryServlet
 * 日期：2023/3/3 10:24
 */
@WebServlet("/GradeQueryServlet")
public class GradeQueryServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //接收学号，课程id
        System.out.println("1");
        String snum = req.getParameter("stuNum");
        String cid = req.getParameter("courseId");
        //调用DAO中的方法根据学号，课程id查成绩
        GradeDAO gradeDao = new GradeDAO();
        Grade grade = gradeDao.queryGradeBySnumAndCid(snum, cid);
        //查询到成绩后，将成绩传递给GradePageServlet
        System.out.println(grade);
        req.setAttribute("grade", grade);
        req.getRequestDispatcher("GradePageServlet").forward(req, resp);
    }


}
