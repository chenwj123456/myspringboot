package cn.china.myspringboot.serviceImpl;

import cn.china.myspringboot.entity.Student;
import cn.china.myspringboot.mapper.StudentMapper;
import cn.china.myspringboot.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service //这个注解加在实现类中，为了将类对象交给spring管理
public class StudentServiceImpl implements StudentService {
    //通过注解，调用mapper包下的接口中定义的方法
    @Autowired
    StudentMapper sm;
    /**
     * 插入学生信息
     *
     * @param s
     * @return
     */
    @Override
    public int insert(Student s) {
        return sm.insert(s);
    }

    /**
     * 查询信息
     *
     * @param name
     * @return
     */
    @Override
    public Student selectByName(String name) {
        return sm.selectByName(name);
    }

    /**
     * 两个查询信息查询
     * @param name
     * @param age
     * @return
     */
    @Override
    public Student selectByNameAndAge(String name, Integer age) {
        return sm.selectByNameAndAge(name,age);
    }

    @Override
    public Student selectByNameAndGender(Map map) {
        return sm.selectByNameAndGender(map);
    }

    /**
     * 添加list集合类型
     *
     * @param list
     * @return
     */
    @Override
    public int insertList(List list) {
        return sm.insertList(list);
    }

    /**
     * 修改信息
     *
     * @param gender
     * @return
     */
    @Override
    public int update(String gender,Integer id) {
        return sm.update(gender,id);
    }

}
