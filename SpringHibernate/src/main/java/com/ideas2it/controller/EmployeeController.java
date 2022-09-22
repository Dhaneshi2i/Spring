package com.ideas2it.controller;

import com.ideas2it.entity.Trainee;
import com.ideas2it.entity.Trainer;
import com.ideas2it.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class EmployeeController {

    @Autowired
    EmployeeService  employeeService;

    @RequestMapping(value = "/traineeRegister")
    public ModelAndView createTrainee() {
        return new ModelAndView("traineeRegister","trainee",new Trainee());
    }

    @PostMapping(value = "/saveTrainee")
    public ModelAndView addTrainee(@ModelAttribute("trainee") Trainee trainee) {
        employeeService.saveEmployee(trainee);
        return new ModelAndView("addition","firstname",trainee.getFirstName());
    }

    /*@PostMapping(value = "/saveTrainee")
    public String addTrainee(Model model,@ModelAttribute ("trainee") Trainee trainee) {
        employeeService.saveEmployee(trainee);
        model.addAttribute("firstName",trainee.getFirstName());
        //return "redirect:/viewTrainees";
        return "addition";
    }*/

    @RequestMapping(value = "/trainerRegister")
    public String createTrainer(Model model) {
        model.addAttribute("trainer",new Trainer());
        return"trainerRegister";
    }

    @PostMapping(value = "/saveTrainer")
    public ModelAndView addTrainer(@ModelAttribute ("trainer") Trainer trainer) {
        employeeService.saveEmployee(trainer);
        return new ModelAndView("addition","firstname", trainer.getFirstName());
    }

    @GetMapping("viewTraineeEmployee")
    public String viewTrainee(Model model) {
        List<Trainee> trainees = (List<Trainee>) employeeService.getTraineeEmployees();
        model.addAttribute("trainees",trainees);
        return "viewTrainees";
    }
    @GetMapping("viewTrainerEmployee")
    public String viewTrainer(Model model) {
        List<Trainer> trainers = (List<Trainer>) employeeService.getTrainerEmployees();
        model.addAttribute("trainers",trainers);
        return "viewTrainers";
    }

    @RequestMapping(value = "/editTrainee/{employeeId}")
    public String updateTrainee(@PathVariable String employeeId, Model model) {
        Trainee trainee = (Trainee) employeeService.getEmployeeById(employeeId);
        model.addAttribute("command",trainee);
        return "traineeEditForm";
    }

    @PutMapping(value = "editAndSaveTrainee")
    public String updateTrainee(@ModelAttribute("trainee") Trainee trainee) {
        employeeService.update(trainee);
        return "updated";
    }

    @RequestMapping(value = "/editTrainer/{employeeId}")
    public String updateTrainer(@PathVariable String employeeId, Model model) {
        Trainer trainer = (Trainer) employeeService.getEmployeeById(employeeId);
        model.addAttribute("command",trainer);
        return "trainerEditForm";
    }

    @PutMapping(value = "editAndSaveTrainer")
    public String updateTrainer(@ModelAttribute("trainer") Trainer trainer) {
        employeeService.update(trainer);
        return "updated";
    }

    @RequestMapping(value = "/deleteTrainee/{employeeId}")
    public String delete(@PathVariable String employeeId) {
        employeeService.removeEmployee(employeeId);
        return "resirect:/viewTrainees";
    }
    /*@PostMapping(value = "/registerProcess")
    public ModelAndView addEmployee(@ModelAttribute ("employee") Employee employee) {
        employeeService.saveOrUpdateEmployee(employee);
        return new ModelAndView("addition","firstname", employee.getFirstName());
    }*/

    //@RequestMapping(value = "/registerProcess",method =RequestMethod.POST,consumes = {"*/*"})
    /*public ModelAndView addEmployee(HttpServletRequest request, HttpServletResponse response,
                                    @ModelAttribute ("employee") Employee employee) {
        if (employee.getEmployeeId()== null) {
            employeeService.saveOrUpdateEmployee(employee);
        }
        else {
            employeeService.update(employee);
        }
        return new ModelAndView("addition","firstname", employee.getFirstName());
    }

    @RequestMapping(value="/viewEmployee")
    public ModelAndView viewEmployee(){
        List<Employee> employees = employeeService.getEmployees();
        return new ModelAndView("viewEmployees","employees",employees);
    }

    @RequestMapping(value="/displayEmployeeById")
    public ModelAndView displayEmployeeById() {
        return new ModelAndView("getEmployeeById","employee",new Employee());
    }

    @RequestMapping("/getEmployeeById")
    public ModelAndView displayEmployeeById(@ModelAttribute("employee") Employee selectedEmployee) {
        Employee employee = employeeService.getEmployeeById(selectedEmployee.getEmployeeId());
        return new ModelAndView("displayById","employee",employee);
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
        return new ModelAndView ("updated", "firstname", employee.getFirstName());
    }

    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public ModelAndView deleteEmployee(HttpServletRequest request,HttpServletResponse response) {
        return new ModelAndView("delete","employee",new Employee());
    }

    @RequestMapping(value = "/deleteEmployee",method = RequestMethod.POST)
    public ModelAndView removeEmployee(@ModelAttribute ("employee") Employee employee) {
        employeeService.removeEmployee(employee);
        return new ModelAndView("deleted");
    }*/
}
