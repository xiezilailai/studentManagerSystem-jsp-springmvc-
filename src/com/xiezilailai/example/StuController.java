package com.xiezilailai.example;

import com.sun.deploy.net.HttpResponse;
import com.sun.javaws.Main;
import com.sun.org.apache.xpath.internal.operations.Mod;
import com.xiezilailai.example.entities.StudentinfoEntity;
import com.xiezilailai.example.entities.UsertableEntity;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import java.io.UnsupportedEncodingException;
import java.sql.ResultSet;
import java.util.List;

import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.jws.soap.SOAPBinding;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Created by 蝎子莱莱123 on 2016/2/13.
 */
@Controller
public class StuController {
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String hello(ModelMap model) {
        return "hello";
    }

    @RequestMapping(value = "/main", method = RequestMethod.GET)
    public String main(ModelMap model) {
        return "main";
    }

    @RequestMapping(value = "/exit", method = RequestMethod.GET)
    public String exit(HttpSession session) {
        session.invalidate();
        return "index";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(ModelMap map, @RequestParam String username, @RequestParam String password, HttpSession httpSession) {
        map.addAttribute("username", username);
        map.addAttribute("password", password);

        Session session=Dbconnection.getSession();
        SQLQuery sqlQuery=session.createSQLQuery("SELECT * FROM usertable WHERE username=:username and password=:password");
        sqlQuery.setString("username",username);
        sqlQuery.setString("password",password);
        Object user= sqlQuery.uniqueResult();
        if(user!=null){
            httpSession.setAttribute("user",user);
            return "main";
        }
        else{
            return "index";
        }

    }

    @RequestMapping(value = "/display", method = RequestMethod.GET)
    public String display(HttpSession httpSession) {
        Session session = Dbconnection.getSession();
        List<StudentinfoEntity> stus = session.createCriteria(StudentinfoEntity.class).list();
        httpSession.setAttribute("stus", stus);
        return "displaystuinfo";

    }

    @RequestMapping(value = "/input", method = RequestMethod.GET)
    public String input() {
        return "inputstuinfo";
    }

    @RequestMapping(value = "/input_success", method = RequestMethod.POST)
    public String inputSuccess(HttpServletRequest req, ModelMap modelMap) throws UnsupportedEncodingException {
        StudentinfoEntity stu = new StudentinfoEntity();
        req.setCharacterEncoding("utf-8");
        String nickName = req.getParameter("nickname");
        String realName = req.getParameter("realname");
        byte sex = Byte.parseByte(req.getParameter("sex"));
        String bornDate = req.getParameter("borndate");
        String profession = req.getParameter("profession");
        String[] subjects = req.getParameterValues("subject");
        String[] hobbies = req.getParameterValues("hobby");
        String remark = req.getParameter("remark");


        stu.setNickname(nickName);
        stu.setRealname(realName);
        stu.setSex(sex);
        stu.setBorndate(bornDate);
        stu.setProfession(profession);

        String subject = "";
        if(subjects!=null){
            for (int i = 0; i < subjects.length; i++) {
                subject += subjects[i] + "&";
            }
            subject = subject.substring(0, subject.length() - 1);
        }

        String hobby = "";
        if(hobbies!=null){
            for (int i = 0; i < hobbies.length; i++) {
                hobby += hobbies[i] + "&";
            }
            hobby = hobby.substring(0, hobby.length() - 1);
        }

        stu.setSubject(subject);
        stu.setHobby(hobby);
        stu.setRemark(remark);

        Session session = Dbconnection.getSession();
        Transaction tran = session.beginTransaction();
        session.save(stu);
        tran.commit();
        return "inputStuInfo_success";
    }

    @RequestMapping(value = "/modify", method = RequestMethod.GET)
    public String modify(HttpSession httpSession) {
        Session session = Dbconnection.getSession();
        List<StudentinfoEntity> stus = session.createCriteria(StudentinfoEntity.class).list();
        httpSession.setAttribute("stus", stus);
        return "modifystuinfo";
    }

    @RequestMapping(value = "/modifyOneStu",method = RequestMethod.GET)
    public String modifyOneStu(HttpServletRequest request,HttpSession httpSession){
        String ids=request.getParameter("id");
        int id=Integer.parseInt(ids);
        Session session=Dbconnection.getSession();
        session.beginTransaction();
        StudentinfoEntity stu= (StudentinfoEntity) session.get(StudentinfoEntity.class,id);
        httpSession.setAttribute("stu",stu);
        return "modifyOneStu";
    }

    @RequestMapping(value = "/modify_success",method = RequestMethod.POST)
    public String modifySuccess(HttpServletRequest req) throws UnsupportedEncodingException {

        req.setCharacterEncoding("utf-8");
        String nickName = req.getParameter("nickname");
        String realName = req.getParameter("realname");
        byte sex = Byte.parseByte(req.getParameter("sex"));
        String bornDate = req.getParameter("borndate");
        String profession = req.getParameter("profession");
        String[] subjects = req.getParameterValues("subject");
        String[] hobbies = req.getParameterValues("hobby");
        String remark = req.getParameter("remark");
        String id=req.getParameter("id");
        Session session = Dbconnection.getSession();
        session.beginTransaction();
        StudentinfoEntity stu= (StudentinfoEntity)session.get(StudentinfoEntity.class,Integer.parseInt(id));
        if(stu!=null){
            stu.setNickname(nickName);
            stu.setRealname(realName);
            stu.setSex(sex);
            stu.setBorndate(bornDate);
            stu.setProfession(profession);

            String subject = "";
            if(subjects!=null){
                for (int i = 0; i < subjects.length; i++) {
                    subject += subjects[i] + "&";
                }
                subject = subject.substring(0, subject.length() - 1);
            }

            String hobby = "";
            if(hobbies!=null){
                for (int i = 0; i < hobbies.length; i++) {
                    hobby += hobbies[i] + "&";
                }
                hobby = hobby.substring(0, hobby.length() - 1);
            }
            stu.setSubject(subject);
            stu.setHobby(hobby);
            stu.setRemark(remark);
            session.update(stu);
            session.getTransaction().commit();
            return "modifyOneStu_success";
        }else{
            return "modify_success";
        }
    }
    @RequestMapping(value = "/delete",method = RequestMethod.GET)
    public String delete(HttpSession httpSession){
        Session session = Dbconnection.getSession();
        List<StudentinfoEntity> stus = session.createCriteria(StudentinfoEntity.class).list();
        httpSession.setAttribute("stus", stus);
        return "deletestuinfo";
    }
    @RequestMapping(value = "/deletestu",method = RequestMethod.GET)
    public String deleteOneStu(HttpServletRequest request,HttpSession httpSession){
        int id=Integer.parseInt(request.getParameter("id"));
        Session session=Dbconnection.getSession();
        session.beginTransaction();
        StudentinfoEntity stu=new StudentinfoEntity();
        stu.setId(id);
        session.delete(stu);
        session.getTransaction().commit();

        return "deleteStu_success";
    }
}

