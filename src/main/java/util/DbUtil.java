package util;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;

/*
    config MyBatis ORM
 */
public class DbUtil {
    private static SqlSessionFactory factory;

    static {
        //retrieve SqlsessionFactory from SqlSessionFactoryBuilder
        try {
            String resource = "config/SqlMapConfig.xml";
            Reader reader = Resources.getResourceAsReader(resource);

            factory = new SqlSessionFactoryBuilder().build(reader);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }// end of static

    /*
        a method that returns SqlSession
            : new SqlSession is opened and closed for every CRUD process
            : commit 또는 rollback을 이용해서 transaction 처리를 한다.
            : no Auto-commit is present, so for DML(insert, update, delete) you need to "Save" or "Cancel"
     */

    public static SqlSession getSession() {
        return factory.openSession();
    }


    /*
       close SqlSession (for select statements)
     */
    public static void sessionClose(SqlSession session) {
        if(session!=null) session.close();
    }


    /**
     close SqlSession (for DML statements)
     @param : booelan state - if true -> commit(), if false -> rollback()
     */
    public static void sessionClose(SqlSession session, boolean state) {
        if(session!=null) {
            if(state) session.commit();
            else session.rollback();

            session.close();
        }
    }

    public static void main(String[] args) {
        System.out.println("---beginning DbUtil---");
        SqlSession session = DbUtil.getSession();
        System.out.println("session = " + session);
    }


}
