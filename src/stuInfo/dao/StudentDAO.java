package stuInfo.dao;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import stuInfo.dto.Student;
import stuInfo.utils.DruidUtils;

/**
 * 描述：根据学号密码查询学生信息
 * 作者：小陶不慌张
 * 文件：StudentDAO
 * 日期：2023/3/2 12:52
 */

public class StudentDAO {
    public Student queryStudentByNumAndPwd(String stuNum, String stuPwd){
        Student student=null;
        try{
            String sql = "select stu_num stuNum, stu_name stuName, stu_gender stuGender, stu_age stuAge, stu_pwd stuPwd from students where stu_num=? and stu_pwd=?";
            QueryRunner queryRunner = new QueryRunner(DruidUtils.getDataSource());
            student = queryRunner.query(sql,new BeanHandler<Student>(Student.class),stuNum,stuPwd);
            System.out.println(student);
        }catch(Exception e){
            e.printStackTrace();
        }
        return student;
    }
}
