package com.denofprogramming.controller;

import javax.inject.Inject;

//logger imports
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.log4j.Logger;

//spring imports
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


// denOfProgramming imports
import com.denofprogramming.random.RandomGenerator;

/**
 * 
 * Example mvc controller class, generates a new number and returns it to the view layer
 * 
 * - Also shows the various logging levels and the "Simple Logging Facade" (slf4j api) and its "Apache Commons Logging (JCL)" bindings in action.
 * 
 * 
 * See:
 * http://www.slf4j.org/index.html
 * https://commons.apache.org/proper/commons-logging/guide.html
 * https://logging.apache.org/log4j/1.2/
 * 
 * @author denOfProgramming
 *
 */
@Controller
public class NumberGeneratorController
{
	// using the slf4j api directly
	//private static final Logger logger = LoggerFactory.getLogger(NumberGeneratorController.class);
	
	// using the log4j api, jar provided by our specific dependency
	private static final Logger logger = Logger.getLogger("com.denofprogramming.controller.NumberGeneratorController");
	
	
	// using the JCL api, jar provided by transient dependency via spring-core
	private Log log = LogFactory.getLog(NumberGeneratorController.class);

    @Inject
    private RandomGenerator numberGenerator;

    @RequestMapping("/new")
    public String showNewNumber(Model model)
    {
	final String implName = numberGenerator.name();
	final Integer number = numberGenerator.generate();

	// Only provided as an example to show different logging dependencies included in our project.
	// Better, is to use only one and its good practice to use slf4j.	
	
	//debug from JCL
	log.debug("log.info is using Class: " + log.getClass().getCanonicalName());	
	
	//debug from log4j
	logger.debug("logger.info is using CLass: " + logger.getClass().getCanonicalName());
	
	
	model.addAttribute("implName", implName);
	model.addAttribute("number", number);

	return "newNumber";
    }

}
