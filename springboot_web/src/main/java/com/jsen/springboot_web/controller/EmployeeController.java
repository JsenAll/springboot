package com.jsen.springboot_web.controller;

import com.jsen.springboot_web.dao.DepartmentDao;
import com.jsen.springboot_web.dao.EmployeeDao;
import com.jsen.springboot_web.entities.Department;
import com.jsen.springboot_web.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Collection;

/**
 * 对用户的操作
 *
 * @author Jsen on 2020/5/15
 */
@Controller
public class EmployeeController {
    @Autowired
    EmployeeDao employeeDao;
    @Autowired
    DepartmentDao departmentDao;

    //查询全部员工
    @GetMapping("/emps")
    public String list(Model model) {
        Collection<Employee> all = employeeDao.getAll();
        model.addAttribute("emps", all);
        return "emp/list";
    }

    //添加员工页面
    @GetMapping("/emp")
    public String add(Model model) {

        Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("deps", departments);
        return "emp/add";
    }

    //添加员工到数据库
    @PostMapping("/emp")
    public String addEmp(Employee employee) {
        System.out.println(employee.toString());
        employeeDao.save(employee);
        //forward:
        return "redirect:/emps";
    }

    @GetMapping("/emp/{id}")
    public String toEditPage(@PathVariable("id") Integer id, Model model) {
        Employee employee = employeeDao.get(id);
        model.addAttribute("emp", employee);
        return "emp/edit";

    }


}
