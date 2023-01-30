package com.lab.studentDebate.model.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.lab.studentDebate.model.Student;
import com.lab.studentDebate.service.StudentService;

@Controller
@RequestMapping("/student")
//@RestController("/student")
public class StudentController {
	@Autowired
	private StudentService  studentService;
	
	@RequestMapping("/list")
	public String listStudent(Model theModel) {

		// get Students from db
		List<Student> theStudents = studentService.findAll();

		// add to the spring model
		theModel.addAttribute("Students", theStudents);

		return "list-students";
	}
	@RequestMapping("/showFormForRegistration")
	public String showForm(Model theModel) {

		// create a student object
		Student theStudent = new Student();

		// add student object to the model
		theModel.addAttribute("Student", theStudent);

		return "student-form";
	}

	@RequestMapping("/processForm")
	public String processForm(@ModelAttribute("student") Student theStudent) {

		// log the input data
		System.out.println("theStudent: " + theStudent.getFirstName() + " " + theStudent.getLastName());

		return "student-confirmation";
	}
	
	@PostMapping("/save")
	public String SaveStudent(@RequestParam("id") int id,
							  @RequestParam("FirstName") String firstname,
							  @RequestParam("LastName") String lastname,
							  @RequestParam("Course") String course,
							  @RequestParam("Country") String country) {

		System.out.println(id);
		Student theStudent;
		if (id != 0) {
			theStudent = studentService.findById(id);
			theStudent.setFirstName(firstname);
			theStudent.setLastName(lastname);
			theStudent.setCourse(course);
			theStudent.setCountry(country);
		} else
			theStudent = new Student(firstname,lastname,course,country);
		
		studentService.save(theStudent);

		
		return "redirect:/student/list";

	}
	@RequestMapping("/delete")
	public String delete(@RequestParam("studentId") int theId) {

		
		studentService.deleteById(theId);

	    return "redirect:/student/list";

	}
	
	@RequestMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("studentId") int theId,Model theModel) {

	
		Student theStudent = studentService.findById(theId);
		theModel.addAttribute("Student", theStudent);
	
		return "student-form";

	}


}
