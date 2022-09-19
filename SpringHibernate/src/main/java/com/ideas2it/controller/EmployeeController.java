package com.ideas2it.controller;

import com.ideas2it.entity.Employee;
import com.ideas2it.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;

    @RequestMapping(value = "/employeeRegister",method = RequestMethod.GET)
    public ModelAndView createEmployee(HttpServletRequest request, HttpServletResponse response) {
        return new ModelAndView("register","employee",new Employee());
    }

    @RequestMapping(value = "/registerProcess",method =RequestMethod.POST,consumes = {"*/*"})
    public ModelAndView addEmployee(HttpServletRequest request, HttpServletResponse response,
                                    @ModelAttribute ("employee") Employee employee) {
        employeeService.saveOrUpdateEmployee(employee);
        return new ModelAndView("addition","firstname", employee.getFirstName());
    }

    @RequestMapping(value="/viewEmployee")
    public String viewEmployee(Model employee){
        List<Employee> employees = employeeService.getEmployee();
        employee.addAttribute("list",employees);
        return "viewEmployees";
    }

    @RequestMapping(value="/displayEmployeeById",method = RequestMethod.GET)
    public ModelAndView displayEmployeeById(HttpServletRequest request,HttpServletResponse response) {
        return new ModelAndView("getEmployeeById","employee",new Employee());
    }
    @RequestMapping(value = "/updateEmployee",method = RequestMethod.GET)
    public ModelAndView updateEmployee(HttpServletRequest request,HttpServletResponse response) {
        return new ModelAndView("getById","employee",new Employee());
    }

    @RequestMapping(value = "employeeUpdate")
    public ModelAndView employeeUpdate(HttpServletRequest request,HttpServletResponse response,
                                       @ModelAttribute("employee") Employee employee){
        ModelAndView modelAndView = new ModelAndView();
        employeeService.update(employee);
        //modelAndView.setViewName("updated");
        return new ModelAndView ("updated", "firstname", employee.getFirstName());
    }
}
