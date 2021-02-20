/**
 * 
 */
package com.vgroup.permutations.dao;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.vgroup.permutations.model.PermutationData;

/**
 * @author skadale
 *
 */

public interface PermutationsDao {

	/**
	 * @param list
	 * @return
	 */
	List<PermutationData> savePermutations(List<PermutationData> list);

	/**
	 * @param string
	 * @return
	 */
	List<PermutationData> getPermutations();

}
