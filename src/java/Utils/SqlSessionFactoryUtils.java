package Utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public  class SqlSessionFactoryUtils {
    private static SqlSession session;
    private static SqlSessionFactory sqlSessionFactory;
    private  static SqlSessionFactory getSqlSessionFactory(){
        //单例SqlSessionFactory
        if (sqlSessionFactory==null){
            InputStream inputStream;
            try{
                String resource = "Do/mybatis-config.xml";
                inputStream = Resources.getResourceAsStream(resource);
                sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
            }catch (IOException e){

            }
        }
        return sqlSessionFactory;
    }
    public static SqlSession getSession(){
        return getSqlSessionFactory().openSession();
    }

}
