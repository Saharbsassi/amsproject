package com.example.demo.controllers;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sip.ams.entities.Etudiant;

@Controller
public class FirstController {
	static ArrayList<Etudiant> students = new ArrayList<>();
	     @RequestMapping("/first")
	     public String home(Model m)
	     {
	    	 String nom = "Sahar Ben Sassi";
	    	 String universite = "Test";
	    	 String email ="saharbsassi@gmail.com";
	    	 String tel ="+216 58 767 443";
	    	 m.addAttribute("name", nom);
	    	 m.addAttribute("myUniversity", universite);
	    	 m.addAttribute("myEmail", email);
	    	 m.addAttribute("myTel", tel);
	    	 
	    	 ArrayList<String> cours = new ArrayList<>();
	    	 cours.add("Java OCA");
	    	 cours.add("Java OCP");	
	    	 cours.add("Spring");
	    	 cours.add("Microservices");
	    	 m.addAttribute("cours", cours);
	    	
	    	 return "home/app";
	     }
	     @RequestMapping("/list")
	     public String Etudiant(Model m)
	     {
	    	 m.addAttribute("students", students);
	    	
	    	 /*ArrayList<Etudiant> students = new ArrayList<>();
	    	 students.add(new Etudiant("Ala", 25, "ala@gmail.com", "Tunis", 20205306));
	    	 students.add(new Etudiant("Marwen", 27, "marou@gmail.com", "Tunis", 58124530));
	    	 students.add(new Etudiant("Sahar", 30, "Sahar@gmail.com", "Nabeul", 41258030));
	    	 m.addAttribute("students", students);*/
	    	 return "home/Etudiant";
	     }
	     
	     
	     @RequestMapping("/add")
	     public String addEtudiant(Model m)
	     {
	    	
	    	 return "home/addStudent";
	     }
	       
	     @PostMapping("/save")
	     //@ResponseBody
	     public String saveEtudiant(
	    		 @RequestParam("nom")String nom,
	    		 @RequestParam("email")String email,
	    		 @RequestParam("adr")String adresse,
	    		 @RequestParam("tel")int tel,
	    		 @RequestParam("age")int age
	    		 )
	   
	     {
	     //return "home/addStudent";
	    	 Etudiant temp = new Etudiant(nom,age,email,adresse,tel);
	    	 students.add(temp);
	    	return "redirect:/list";
	     }
	     //methode delete
	     @GetMapping("/delete/{email}")
	     //@ResponseBody
	     public String deleteEtudiant(@PathVariable("email")String mail)
	     {
	    	 Etudiant temp=null;
	    	 for(Etudiant e : students)
	    	 {
	    		 if (e.getEmail().equals(mail))
	    		 {
	    			 temp = e;
	    		 }
	    	 }
	    	 students.remove(temp);
	    	 //System.out.println(students);
	    	 return"redirect:../list";
	     }
}
