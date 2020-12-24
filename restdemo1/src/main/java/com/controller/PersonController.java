package com.controller;

import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import org.springframework.web.bind.annotation.RestController;

import com.model.Person;
import com.service.PersonService;

@RestController
public class PersonController {
	@Autowired
	private PersonService personService;
	//For add and update person both
		@PostMapping(value= "/person/add")
		public String addPerson(@ModelAttribute("person") Person person){
			
			if(person.getId() == 0){
				//new person add it
				this.personService.addPerson(person);
			}else{
				//existing person call update
				this.personService.updatePerson(person);
			}
			
			return "redirect:/persons";
			
		}
	
	
	@GetMapping(value = "/persons")
	public String listPersons(Model model) {
		model.addAttribute("person", new Person());
		model.addAttribute("listPersons", this.personService.listPersons());
		return "person";
	}
	
	
	
	@DeleteMapping("/remove/{id}")
    public String removePerson(@PathVariable("id") int id){
		
        this.personService.removePerson(id);
        return "redirect:/persons";
    }
 
    @PutMapping("/edit/{id}")
    public String editPerson(@PathVariable("id") int id, Model model){
        model.addAttribute("person", this.personService.getPersonById(id));
        model.addAttribute("listPersons", this.personService.listPersons());
        return "person";
    }
	
}
