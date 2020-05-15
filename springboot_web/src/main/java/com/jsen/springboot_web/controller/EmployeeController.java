package com.jsen.springboot_web.controller;

import com.jsen.springboot_web.dao.EmployeeDao;
import com.jsen.springboot_web.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

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

    @GetMapping("/emps")
    public String list(Model model) {
        Collection<Employee> all = employeeDao.getAll();
        model.addAttribute("emps", all);
        return "emp/list";
    }

}
