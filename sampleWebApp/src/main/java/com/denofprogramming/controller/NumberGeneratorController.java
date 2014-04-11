package com.denofprogramming.controller;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.denofprogramming.random.RandomGenerator;

@Controller
public class NumberGeneratorController
{

    @Inject
    private RandomGenerator numberGenerator;

    @RequestMapping("/new")
    public String showNewNumber(Model model)
    {
	final String implName = numberGenerator.name();
	final Integer number = numberGenerator.generate();

	model.addAttribute("implName", implName);
	model.addAttribute("number", number);

	return "newNumber";
    }

}
