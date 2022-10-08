package com.pyj.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.pyj.dao.AccountDao;
import com.pyj.pojo.Account;
import com.pyj.pojo.User;
import com.pyj.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private AccountService accountService;

    @RequestMapping("/save")
    public String save(HttpServletRequest req){
        req.setAttribute("success","success");
        return "success";
    }

    @RequestMapping("/save2")
    public ModelAndView save2(){
        ModelAndView mv = new ModelAndView();
        mv.addObject("success","success");
        mv.setViewName("success");
        return mv;
    }

    @RequestMapping("/save3")
    public ModelAndView save3(ModelAndView mv){
        mv.addObject("success","success");
        mv.setViewName("success");
        return mv;
    }

    @RequestMapping("/save4")
    public String save4(Model m){
        m.addAttribute("success","success");
        return "success";
    }

    @RequestMapping(value = "/save5", produces = "text/html;charset=utf-8", method = RequestMethod.POST)
    @ResponseBody
    public String save5(HttpServletResponse resp) throws IOException {
        return "哈喽哈喽";
    }

    @RequestMapping(value = "/save6", produces = "text/html;charset=utf-8")
    @ResponseBody
    public String save6() throws JsonProcessingException {
        Account account = new Account();
        account.setId(1);
        account.setUsername("李磊");
        account.setBalance(1000);
        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(account);
        return json;
    }

    @RequestMapping(value = "/save7", produces = "application/json;charset=utf-8")
    @ResponseBody
    public Account save7() {
        Account account = new Account();
        account.setId(1);
        account.setUsername("李磊");
        account.setBalance(1000);
        return account;
    }

    @RequestMapping(value = "/tologin")
    public String tologin() {
        return "login";
    }

    @RequestMapping(value = "/save8", produces = "text/html;charset=utf-8")
    @ResponseBody
    public String save8(@RequestParam(name = "username",
            defaultValue = "啥也灭有", required = false) String uname) {
        return uname;
    }

    @RequestMapping(value = "/save9")
    @ResponseBody
    public User save9(User user) {
        System.out.println(user);
        return user;
    }

    @RequestMapping(value = "/save10")
    @ResponseBody
    public List<User> save10(@RequestBody List<User> userList) {
        System.out.println(userList);
        return userList;
    }

    @RequestMapping(value = "/save11/{username}", method = RequestMethod.POST)
    @ResponseBody
    public void save11(@PathVariable("username") String name) {
        System.out.println(name);
    }

    @RequestMapping(value = "/save12")
    @ResponseBody
    public void save12(@RequestParam("date") Date date) {
        System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date));
    }

    @RequestMapping(value = "/save13")
    @ResponseBody
    public void save13(HttpServletRequest req) {
        ServletContext servletContext = req.getServletContext();
        WebApplicationContext webApplicationContext = WebApplicationContextUtils.findWebApplicationContext(servletContext);
        AccountDao bean = webApplicationContext.getBean(AccountDao.class);
        bean.SelectAll();
    }

    /**
     * RESTful风格
     */
    //根据id查询账户
//    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @GetMapping(value = "/{id}")
    @ResponseBody
    public Account selectAccountById(@PathVariable("id") int id){
        Account account = accountService.SelectById(id);
        return account;
    }

    //添加账户
//    @RequestMapping(method = RequestMethod.POST, produces = "text/html;charset=utf-8")
    @PostMapping(produces = "text/html;charset=utf-8")
    @ResponseBody
    public String addAccount(@RequestBody Account account){
        accountService.save(account);
        return "添加成功";
    }

    //删除账户
//    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE, produces = "text/html;charset=utf-8")
    @DeleteMapping(value = "/{id}", produces = "text/html;charset=utf-8")
    @ResponseBody
    public String deleteAccount(@PathVariable("id") int id ){
        accountService.deleteAccount(id);
        return "删除成功";
    }

    //查询全部用户
    @GetMapping
    @ResponseBody
    public List<Account> SelectAllAccount(){
        List<Account> accounts = accountService.SelectAll();
        return accounts;
    }

    //修改用户信息
    @PutMapping(produces = "application/json;charset=utf-8")
    @ResponseBody
    public String updateAccount(@RequestBody Account account){
        accountService.updateAccount(account);
        return "修改成功";
    }

}
