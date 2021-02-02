package com.fouriertransform.test;

import com.fouriertransform.dao.IUserDao;
import com.fouriertransform.domain.User;
//import com.fouriertransform.mybatis.io.Resources;
//import com.fouriertransform.mybatis.sqlsession.SqlSession;
//import com.fouriertransform.mybatis.sqlsession.SqlSessionFactory;
//import com.fouriertransform.mybatis.sqlsession.SqlSessionFactoryBuilder;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.util.Date;
import java.util.List;

/**
 * @author ：FourierTransform
 * @date ：Created in 2021/2/1 13:42
 */
public class MybatisTest{
    IUserDao userDao;
    SqlSession session;
    InputStream in;
    @Before
    public void init() throws Exception{
        in = Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactoryBuilder builder= new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = builder.build(in);

        session = factory.openSession();

        userDao = session.getMapper(IUserDao.class);
    }

    @After
    public void close() throws Exception{
        session.commit();
        session.close();
        in.close();
    }
    public static void main(String[] args) throws Exception{

    }

    @Test
    public void testUpdate() throws Exception{
        User user = new User();
        user.setId(51);
        user.setUsername("Mike joker");
        user.setAddress("American");
        user.setSex("m");
        user.setBirthday(new Date());

        userDao.updateUser(user);

        List<User> users = userDao.findAll();
        for(User i: users){
            System.out.println(i);
        }
    }
}
