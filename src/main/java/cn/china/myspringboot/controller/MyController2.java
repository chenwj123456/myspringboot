package cn.china.myspringboot.controller;

import cn.china.myspringboot.entity.Student;
import cn.china.myspringboot.serviceImpl.StudentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;


import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


//注解：将所有注解对象交给springmvc管理
@RestController//等价于下面两个，即将MyController这个类交给springmvc这个框架管理
/*@Controller
@ResponseBody*/
public class MyController2 {
    @Autowired //获取对象，已经将类交给框架管理了
            StudentServiceImpl ssi;

    @RequestMapping("/insert")
    public int insert(){
        Student s = new Student();
        s.setName("张三");
        s.setAge(18);
        s.setGender("男");
        return ssi.insert(s);
        //返回的值再jsp页面中用ajaks来接受
    }

    //@RequestParam 为获取前端穿的参数，即地址栏中拼接的信息，取代了String s= req.getparamter()这个方法
    @RequestMapping("/select1")
    public Student find(@RequestParam String name){
        return ssi.selectByName(name);
    }

    @RequestMapping("/select2")
    public Student find2(@RequestParam String name, @RequestParam Integer age){
        return ssi.selectByNameAndAge(name,age);
    }

    @RequestMapping("/select3")
    public Student find3(@RequestParam String name, @RequestParam String gender){
        Map<String,String> map = new HashMap<>();
        //注意这里的添加到map集合中的key值nameKey和genderKey这两个要对应上sql语句中的#{}
        map.put("nameKey",name);
        map.put("genderKey",gender);
        return ssi.selectByNameAndGender(map);
    }

    @RequestMapping("/select4")
    public int insertList(){
        List<Student> list = new ArrayList<>();
        list.add(new Student("dog",18,"雄"));
        list.add(new Student("cat",11,"雌"));
        list.add(new Student("fish",15,"雄"));
        return ssi.insertList(list);
    }











    //当请求中包含hello路径时，就会访问到这个方法
    @RequestMapping("/hello")
    public String hello(HttpServletRequest request){
        request.setAttribute("key","helloWorld");
        return "hello";
    }

    @RequestMapping("/my")
    public String my(){
        return "my";
    }

    @RequestMapping("/my2") //服务器地址栏用来访问的路径
    public ModelAndView way(ModelAndView mv){
        //等价于往作用域中设置键值对
        mv.addObject("name","陈伟进");
        //将数据返还给指定jsp
        mv.setViewName("my");
        return mv;
    }

    //当返回值为int类型时，即直接在页面显示
    @RequestMapping("/int")
    //这个注解是返回int类型，或者对象，集合等等。另外需要注意的是：
    //当你返回值类型为String，理论上是访问jsp页面，但是你加了下面这个注解，
    //就直接在页面显示String
    //如果将其放在整个类上，则当前类中的方法返回的都是数据，即直接在页面显示
    @ResponseBody
    public int show(){
        return 123;
    }


    //返回对象
    @RequestMapping("/stu")
    public Student student(){
        Student s = new Student();
        s.setName("tom");
        s.setAge(20);
        s.setGender("男");
        return s;
    }

    //返回集合
    @RequestMapping("/list")
    public List<Student> list2(){
        List<Student> list = new ArrayList<>();
        list.add(new Student("陈伟进",18,"男"));
        list.add(new Student("刘竹青",18,"男"));
        list.add(new Student("桑梓旭",18,"男"));
        return list;
    }

}
