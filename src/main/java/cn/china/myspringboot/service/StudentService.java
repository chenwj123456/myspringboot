package cn.china.myspringboot.service;

import cn.china.myspringboot.entity.Student;

import java.util.List;
import java.util.Map;

public interface StudentService {
    /**
     * 插入学生信息
     * @param s
     * @return
     */
    int insert(Student s);

    /**
     * 查询信息
     * @param name
     * @return
     */
    Student selectByName(String name);

    /**
     * 两个查询信息查询
     * @param name
     * @param age
     * @return
     */
    Student selectByNameAndAge(String name, Integer age);

    /**
     * 参数类型为map集合
     * @param map
     * @return
     */
    Student selectByNameAndGender(Map map);

    /**
     * 添加list集合类型
     * @param list
     * @return
     */
    int insertList(List list);

    /**
     * 修改信息
     * @param gender
     * @return
     */
    int update(String gender, Integer id);

}
