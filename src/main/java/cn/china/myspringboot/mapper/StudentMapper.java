package cn.china.myspringboot.mapper;

import cn.china.myspringboot.entity.Student;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface StudentMapper {
    /**
     * 插入信息
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
     * 两个条件查询
     * @param name
     * @param age
     * @return
     */
    Student selectByNameAndAge(@Param("name1") String name, @Param("age1") Integer age);

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
    int update(@Param("gender1") String gender, @Param("id1") Integer id);

}
