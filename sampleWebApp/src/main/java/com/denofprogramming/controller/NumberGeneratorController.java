package com.denofprogramming.controller;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

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
	private static final Logger logger = LoggerFactory.getLogger(NumberGeneratorController.class);
	
	// using the JCL binding provided by slf4j (NOT the Spring transient dependency on JCL, as that is excluded now in the maven pom)
	//private Log log = LogFactory.getLog(NumberGeneratorController.class);

    @Inject
    private RandomGenerator numberGenerator;

    @RequestMapping("/new")
    public String showNewNumber(Model model)
    {
	final String implName = numberGenerator.name();
	final Integer number = numberGenerator.generate();

	// Only provided as an example to show using slf4j-JCL binding and slf4j-api -> all going to log4j.
	// You would only use the slf4j-api for new real world projects,
	// but bindings are needed for backward compatibility for Spring dependency on JCL.
	// slf4j uses log4j as an example but others can be used instead.
	//log.debug("log.debug is using Class: " + log.getClass().getCanonicalName());	
	logger.debug("logger.debug is using CLass: " + logger.getClass().getCanonicalName());
	
	//log.info("log.info is using Class: " + log.getClass().getCanonicalName());	
	logger.info("logger.info is using CLass: " + logger.getClass().getCanonicalName());

	//log.warn("log.warn is using Class: " + log.getClass().getCanonicalName());	
	logger.warn("logger.warn is using CLass: " + logger.getClass().getCanonicalName());

	
	model.addAttribute("implName", implName);
	model.addAttribute("number", number);

	return "newNumber";
    }

}
