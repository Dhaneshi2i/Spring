package com.ideas2it.controller;

import com.ideas2it.entity.Trainee;
import com.ideas2it.entity.Trainer;
import com.ideas2it.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
    public ModelAndView createTrainer() {
        return new ModelAndView("trainerRegister","trainer",new Trainer());
    }

    @PostMapping(value = "/saveTrainer")
    public ModelAndView addTrainer(@ModelAttribute ("trainer") Trainer trainer) {
        employeeService.saveEmployee(trainer);
        return new ModelAndView("addition","firstname", trainer.getFirstName());
    }

    /*@GetMapping("viewTraineeEmployee")
    public String viewTrainee(Model model) {
        List<Trainee> trainees = (List<Trainee>) employeeService.getTraineeEmployees();
        model.addAttribute("trainees",trainees);
        return "viewTrainees";
    }*/

    @GetMapping("viewTraineeEmployee")
    public ModelAndView viewTrainee() {
        List<Trainee> trainees = (List<Trainee>) employeeService.getTraineeEmployees();
        //model.addAttribute("trainees",trainees);
        return new ModelAndView("viewTrainees","trainees",trainees);
    }

    /*@GetMapping("viewTrainerEmployee")
    public String viewTrainer(Model model) {
        List<Trainer> trainers = (List<Trainer>) employeeService.getTrainerEmployees();
        model.addAttribute("trainers",trainers);
        return "viewTrainers";
    }*/

    @GetMapping("viewTrainerEmployee")
    public ModelAndView viewTrainer() {
        List<Trainer> trainers = (List<Trainer>) employeeService.getTrainerEmployees();
        //model.addAttribute("trainers",trainers);
        return new ModelAndView("viewTrainers","trainers",trainers);
    }

    /*@RequestMapping(value = "/editTrainee/{traineeId}")
    public String updateTrainee(@PathVariable(value = "traineeId") int traineeId, Model model) {
        Trainee trainee = (Trainee) employeeService.getTraineeById(traineeId);
        model.addAttribute("command",trainee);
        return "traineeEditForm";
    }

    @PutMapping(value = "editAndSaveTrainee")
    public String updateTrainee(Model model,@ModelAttribute("trainee") Trainee trainee) {
        employeeService.updateTrainee(trainee);
        model.addAttribute("firstName",trainee.getFirstName());
        return "updated";
    }*/

    /*@PutMapping(value = "/editTrainee/{traineeId}")
    public String updateTrainee(@PathVariable(value = "traineeId") int traineeId, Model model, @ModelAttribute("trainee") Trainee trainee){
        Trainee selectedTrainee = employeeService.getTraineeById(traineeId);
        if (selectedTrainee != null) {
            employeeService.updateTrainee(selectedTrainee);
            model.addAttribute("firstName",selectedTrainee.getFirstName());
            return "updated";
        } else {
            return "noDataFound";
        }
    }*/

    /*@PutMapping(value = "/editTrainer/{trainer_id}")
    public String updateTrainer(@PathVariable(value = "trainer_id") int trainer_id, Model model) {
        System.out.println("Id:" + trainer_id);
        Trainer trainer = (Trainer) employeeService.getTrainerById(trainer_id);
        if (trainer != null) {
            model.addAttribute("command", trainer);
            return "trainerEditForm";
        } else {
            return "noDataFound";
        }
    }

    @PutMapping(value = "editAndSaveTrainer")
    public String updateTrainer(@ModelAttribute("trainer") Trainer trainer) {
        employeeService.updateTrainer(trainer);
        return "updated";
    }

    @DeleteMapping("/deleteTrainee/{traineeId}")
    public String deleteTrainee(@PathVariable(value = "traineeId") int traineeId) {
        System.out.println("Id:" + traineeId);
        employeeService.removeTraineeEmployee(traineeId);
        return "viewTrainees";
    }

    @DeleteMapping("deleteTrainer/{employeeId}")
    public String deleteTrainer(@PathVariable("trainerId") int trainerId) {
        employeeService.removeTrainerEmployee(trainerId);
        return "redirect:/viewTrainers";
    }*/

    @RequestMapping(value = "/updateTrainee",method = RequestMethod.GET)
    public ModelAndView updateEmployee(HttpServletRequest request, HttpServletResponse response) {
        return new ModelAndView("getById","trainee",new Trainee());
    }

    @RequestMapping(value = "traineeUpdate")
    public ModelAndView employeeUpdate(HttpServletRequest request, HttpServletResponse response,
                                       @ModelAttribute("trainee") Trainee trainee){
        ModelAndView modelAndView = new ModelAndView();
        employeeService.updateTrainee(trainee);
        return new ModelAndView ("updated", "firstname", trainee.getFirstName());
    }

    @RequestMapping(value = "/traineeDelete", method = RequestMethod.GET)
    public ModelAndView deleteEmployee(HttpServletRequest request,HttpServletResponse response) {
        return new ModelAndView("delete","trainee",new Trainee());
    }

    @RequestMapping(value = "/deleteEmployee",method = RequestMethod.POST)
    public ModelAndView removeEmployee(@ModelAttribute ("trainee") Trainee trainee) {
        employeeService.removeTraineeEmployee(trainee);
        return new ModelAndView("deleted");
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
