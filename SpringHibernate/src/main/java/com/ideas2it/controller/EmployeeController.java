package com.ideas2it.controller;

import com.ideas2it.entity.Trainee;
import com.ideas2it.entity.Trainer;
import org.apache.log4j.Logger;
import com.ideas2it.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class EmployeeController {

    @Autowired
    private EmployeeService  employeeService;

    private static final Logger logger = Logger.getLogger(EmployeeController.class);

    @RequestMapping("/traineeRegister")
    public ModelAndView createTrainee() {
        return new ModelAndView("traineeRegister","trainee",new Trainee());
    }

    @PostMapping("/saveTrainee")
    public ModelAndView addTrainee(@ModelAttribute("trainee") Trainee trainee) {
        logger.info("Employee Added");
        employeeService.saveEmployee(trainee);
        return new ModelAndView("addition","firstname",trainee.getFirstName());
    }

    @RequestMapping("/trainerRegister")
    public ModelAndView createTrainer() {
        return new ModelAndView("trainerRegister","trainer",new Trainer());
    }

    @PostMapping("/saveTrainer")
    public ModelAndView addTrainer(@ModelAttribute ("trainer") Trainer trainer) {
        employeeService.saveEmployee(trainer);
        return new ModelAndView("addition","firstname", trainer.getFirstName());
    }

    @GetMapping("viewTraineeEmployee")
    public ModelAndView viewTrainee() {
        List<Trainee> trainees = (List<Trainee>) employeeService.getTraineeEmployees();
        return new ModelAndView("viewTrainees","trainees",trainees);
    }

    @GetMapping("viewTrainerEmployee")
    public ModelAndView viewTrainer() {
        List<Trainer> trainers = (List<Trainer>) employeeService.getTrainerEmployees();
        return new ModelAndView("viewTrainers","trainers",trainers);
    }

    @RequestMapping("/displayTraineeById")
    public ModelAndView displayTraineeById() {
        return new ModelAndView("getTrainee","trainee",new Trainee());
    }

    @PostMapping("/getTraineeById")
    public ModelAndView displayTraineeById(@ModelAttribute("trainee") Trainee selectedTrainee) {
        Trainee trainee = employeeService.getTraineeById(selectedTrainee.getEmployeeId());
        return new ModelAndView("displayTraineeById","trainee",trainee);
    }

    @RequestMapping("/displayTrainerById")
    public ModelAndView displayTrainerById() {
        return new ModelAndView("getTrainer","trainer",new Trainer());
    }

    @PostMapping("/getTrainerById")
    public ModelAndView displayTrainerById(@ModelAttribute("trainer") Trainer selectedTrainer) {
        Trainer trainer = employeeService.getTrainerById(selectedTrainer.getEmployeeId());
        return new ModelAndView("displayTrainerById","trainer",trainer);
    }

    @RequestMapping("/updateTrainee")
    public ModelAndView updateTrainee() {
        return new ModelAndView("updateTrainee","trainee",new Trainee());
    }

    @PostMapping("traineeUpdate")
    public ModelAndView traineeUpdate(@ModelAttribute("trainee") Trainee selectedTrainee){
        Trainee trainee = employeeService.getTraineeById(selectedTrainee.getEmployeeId());
        trainee.setFirstName(selectedTrainee.getFirstName());
        employeeService.updateTrainee(trainee);
        return new ModelAndView ("updated", "firstname", trainee.getFirstName());
    }

    @RequestMapping("/updateTrainer")
    public ModelAndView updateTrainer() {
        return new ModelAndView("updateTrainer","trainer",new Trainer());
    }

    @PostMapping("trainerUpdate")
    public ModelAndView trainerUpdate(@ModelAttribute("trainer") Trainer selectedTrainer){
        Trainer trainer = employeeService.getTrainerById(selectedTrainer.getEmployeeId());
        trainer.setFirstName(selectedTrainer.getFirstName());
        employeeService.updateTrainer(trainer);
        return new ModelAndView ("updated", "firstname", trainer.getFirstName());
    }

    @RequestMapping("/traineeDelete")
    public ModelAndView deleteTrainee() {
        return new ModelAndView("traineeDeleteForm","trainee",new Trainee());
    }

    @PostMapping("/deleteTrainee")
    public ModelAndView removeTrainee(@ModelAttribute ("trainee") Trainee selectedTrainee) {
        Trainee trainee = employeeService.getTraineeById(selectedTrainee.getEmployeeId());
        trainee.setActiveEmployee(true);
        employeeService.updateTrainee(trainee);
        return new ModelAndView("deleted");
    }

    @RequestMapping("/trainerDelete")
    public ModelAndView deleteTrainer() {
        return new ModelAndView("trainerDeleteForm","trainer",new Trainer());
    }

    @PostMapping("/deleteTrainer")
    public ModelAndView removeTrainer(@ModelAttribute ("trainer") Trainer selectedTrainer) {
        Trainer trainer = employeeService.getTrainerById(selectedTrainer.getEmployeeId());
        trainer.setActiveEmployee(true);
        employeeService.updateTrainer(trainer);
        return new ModelAndView("deleted");
    }

    @RequestMapping("/associateTrainee")
    public ModelAndView associateTrainee(){
        return new ModelAndView("associateTrainee");
    }

    @RequestMapping("/traineeAssociation")
    public ModelAndView associateTrainee(@RequestParam("traineeEmployeeId") String traineeEmployeeId,
                                         @RequestParam("trainerEmployeeId") String trainerEmployeeId) {
        Trainer trainer = employeeService.getTrainerById(trainerEmployeeId);
        Trainee trainee = employeeService.getTraineeById(traineeEmployeeId);
        trainer.getTrainees().add(trainee);
        employeeService.updateTrainer(trainer);
        return new ModelAndView("updated","firstname",trainer.getFirstName());
    }
    /*@RequestMapping(value = "/editTrainee/{traineeId}")
    public String updateTrainee(@PathVariable(value = "traineeId") int traineeId, Model model) {
        Trainee trainee = (Trainee) employeeService.getByTraineeId(traineeId);
        model.addAttribute("command",trainee);
        return "traineeEditForm";
    }

    @PostMapping(value = "/editAndSaveTrainee")
    public ModelAndView updateTrainee(@ModelAttribute("trainee") Trainee trainee) {
        employeeService.updateTrainee(trainee);
        return new ModelAndView("updated","firstname",trainee.getFirstName());
    }*/

}
