package com.spring5JokesApp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.spring5JokesApp.services.JokesService;

@Controller
public class JokeController {
	
	private final JokesService jokesService;  //Having a final means it can never be changed by anything in the class.

	@Autowired                //Optional
	public JokeController(JokesService jokesService) {
		this.jokesService = jokesService;
	}
	 
	@RequestMapping({"/", ""})                  //The url at which we can access the view
	public String showJoke(Model model) {
		
		model.addAttribute("joke", jokesService.getJoke());    //The model has the data
		
		return "index";             //Return the model to the index.html view
	}
	
	
	
}
