package com.example.sharding;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.sharding.entity.Course;
import com.example.sharding.mapper.CourseMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Desc
 * @Author ninja
 * @Date Created on 2025/1/12
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ShardingTest {

    @Resource
    private CourseMapper courseMapper;

    @Test
    public void addCourse() {
        for (int i = 1; i <= 10; i++) {
            Course course = new Course();
            course.setCname("java");
            course.setUserId(1111L);
            course.setCstatus("1");
            courseMapper.insert(course);
            System.out.println(course);
        }
    }

    /**
     * 不带分片键，所有表查一遍
     */
    @Test
    public void queryByName() {
        QueryWrapper<Course> wrapper = new QueryWrapper<Course>();
        wrapper.eq("cname", "java");
        wrapper.orderByDesc("cid");
        List<Course> courses = courseMapper.selectList(wrapper);
        for (Course course : courses) {
            System.out.println(course.getCid());
        }
    }
    @Test
    public void queryByLimit() {
        QueryWrapper<Course> wrapper = new QueryWrapper<Course>();
        wrapper.eq("cname", "java");
        wrapper.orderByDesc("cid");
        wrapper.last("limit 3,1");//实际执行的是0,4拿到所有结果后再去聚合
        List<Course> courses = courseMapper.selectList(wrapper);
        for (Course course : courses) {
            System.out.println(course.getCid());
        }
    }

    /**
     * 为何没生效？
     */
    @Test
    public void queryByNameByPage() {
        Page<Course> page = new Page<Course>(1, 2);
        QueryWrapper<Course> wrapper = new QueryWrapper<Course>();
        wrapper.eq("cname", "java");
        wrapper.orderByDesc("cid");
        Page<Course> coursePage = courseMapper.selectPage(page, wrapper);
        List<Course> records = coursePage.getRecords();
        for (Course record : records) {
            System.out.println(record.getCid());
        }
    }

    @Test
    public void queryByBetween() {
        QueryWrapper<Course> wrapper = new QueryWrapper<Course>();
        wrapper.between("user_id", 1,2222);
        wrapper.orderByDesc("cid");
        wrapper.last("limit 3,1");//实际执行的是0,4拿到所有结果后再去聚合
        List<Course> courses = courseMapper.selectList(wrapper);
        for (Course course : courses) {
            System.out.println(course.getCid());
        }
    }

    @Test
    public void queryByIn() {
        QueryWrapper<Course> wrapper = new QueryWrapper<Course>();
        //wrapper.in("cid",222L,333L); //虽然匹配不到，但是还是会查询所有的库表
        wrapper.in("cid",1085287478547447809L,1085287478455173120L);//也是全表查询？
        //wrapper.between("user_id", 1,2222);
        //wrapper.orderByDesc("cid");
        //wrapper.last("limit 3,1");//实际执行的是0,4拿到所有结果后再去聚合
        List<Course> courses = courseMapper.selectList(wrapper);
        for (Course course : courses) {
            System.out.println(course.getCid());
        }
    }
}
