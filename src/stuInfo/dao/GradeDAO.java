package stuInfo.dao;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import stuInfo.dto.Grade;
import stuInfo.utils.DruidUtils;

/**
 * 描述：
 * 作者：小陶不慌张
 * 文件：GradeDAO
 * 日期：2023/3/2 13:05
 */

public class GradeDAO {
    public Grade queryGradeBySnumAndCid(String snum, String cid) {
        Grade grade = null;
        try{
            System.out.println("2");
            //注意查询出的列名要取别名，和grade对象的属性一致
            String sql = "select s.stu_num snum,s.stu_name sname,c.course_id cid,c.course_name cname ,g.score score " +
                    "from students s INNER JOIN grades g INNER JOIN courses c  on s.stu_num = g.snum and g.cid = c.course_id where s.stu_num=? and c.course_id=?";
            QueryRunner queryRunner = new QueryRunner(DruidUtils.getDataSource());
            grade = queryRunner.query(sql,new BeanHandler<Grade>(Grade.class),snum,cid);
        }catch (Exception e){
            e.printStackTrace();
        }
        return grade;
    }
}
