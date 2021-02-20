/**
 * 
 */
package com.vgroup.permutations.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vgroup.permutations.dto.InputData;
import com.vgroup.permutations.exceptionHandling.InvalidInputException;
import com.vgroup.permutations.model.PermutationData;
import com.vgroup.permutations.service.PermutationsService;

/**
 * @author skadale
 *
 */

/**
 * @author skadale
 *
 */
@RestController
@RequestMapping(value="/permutations/1.0")
public class PermutationsController {
	
	@Autowired
	PermutationsService permutationsService;
	
	  /**
	 * @param string
	 * @return
	 * @throws Exception 
	 */
	@PostMapping("/savePermutations")
	  public List<PermutationData> savePermutations(@RequestBody(required=true) @Valid InputData inputData, BindingResult bindingResult) throws InvalidInputException {
	    
		if (bindingResult.hasErrors()) {
			List<String> s = new ArrayList<String>();
			for (FieldError element : bindingResult.getFieldErrors()) {
				s.add(element.getDefaultMessage());
			}
			throw new InvalidInputException(s.toString());
		}
		
		return permutationsService.savePermutations(inputData);
	  }
	  
	  
	  /**
	   * Specific to admin role only
	 * @return List<PermutationData>
	 */
	@GetMapping("/getPermutations")
	  public List<PermutationData> getPermutations() {
	    return permutationsService.getPermutations();
	  }
}
