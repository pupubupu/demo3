package com.pyj.service;

import com.github.pagehelper.PageHelper;
import com.pyj.pojo.Account;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class AccountServiceTest {

    public static void main(String[] args) throws IOException {
        InputStream inputStream = Resources.getResourceAsStream("sdasdad");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
    }

    @Test
    public void SelectAllTest(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        AccountService accountService = applicationContext.getBean(AccountService.class);
        List<Account> accounts = accountService.SelectAll();
        for (Account account:accounts) {
            System.out.println(account);
        }
    }

    @Test
    public void SelectByIdTest(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        AccountService accountService = applicationContext.getBean(AccountService.class);
        Account account = accountService.SelectById(2);
        System.out.println(account);
    }

    @Test
    public void saveTest(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        AccountService accountService = applicationContext.getBean(AccountService.class);
        Account account = new Account();
        account.setUsername("Alice");
        account.setBalance(3000);
        int save = accountService.save(account);
        System.out.println(save);
    }

    @Test
    public void updateAccountTest(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        AccountService accountService = applicationContext.getBean(AccountService.class);
        Account account = new Account();
        account.setId(7);
//        account.setUsername("Alice");
        account.setBalance(5000);
        int save = accountService.updateAccount(account);
        System.out.println(save);
    }

    @Test
    public void deleteAccountTest(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        AccountService accountService = applicationContext.getBean(AccountService.class);
//        Account account = new Account();
//        account.setId(7);
//        account.setUsername("Alice");
//        account.setBalance(5000);
        int save = accountService.deleteAccount(7);
        System.out.println(save);
    }

    /**
     * 测试分页查询
     */
    @Test
    public void SelectAllTest2() throws IOException {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        AccountService accountService = applicationContext.getBean(AccountService.class);
        PageHelper.startPage(1,2);
        List<Account> accounts = accountService.SelectAll();
        for (Account account:accounts) {
            System.out.println(account);
        }

//        InputStream resourceAsStream = Resources.getResourceAsStream("mybatis-config.xml");
//        SqlSessionFactory build = new SqlSessionFactoryBuilder().build(resourceAsStream);
//        SqlSession sqlSession = build.openSession();
//        AccountDao mapper = sqlSession.getMapper(AccountDao.class);
//        List<Account> accounts1 = mapper.SelectAll();
//        for (Account account:accounts1) {
//            System.out.println(account);
//        }

    }

    @Test
    public void test() throws ParseException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy年MM月dd日 HH时mm分ss秒");//Date指定格式：yyyy-MM-dd HH:mm:ss:SSS
        String string = "2019年7月20日 10时00分10秒";
        Date d = simpleDateFormat.parse(string);//传入的格式必须符合simpleDateFormat对象的格式，即"yyyy-MM-dd HH:mm:ss:SSS" 否则会报错
        System.out.println(simpleDateFormat.format(d));
        System.out.println(d);

        AnnotationConfigWebApplicationContext applicationContext = new AnnotationConfigWebApplicationContext();
        applicationContext.register();


    }





}
