/**
 * 
 */
package com.vgroup.permutations.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.vgroup.permutations.dto.InputData;
import com.vgroup.permutations.model.PermutationData;

/**
 * @author skadale
 *
 */
public interface PermutationsService {

	List<PermutationData> savePermutations(InputData inputData);

	List<PermutationData> getPermutations();

}
