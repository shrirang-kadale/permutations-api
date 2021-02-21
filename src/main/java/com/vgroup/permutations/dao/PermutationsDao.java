/**
 * 
 */
package com.vgroup.permutations.dao;

import java.util.List;

import com.vgroup.permutations.model.PermutationData;

/**
 * @author skadale
 *
 */

public interface PermutationsDao {

	/**
	 * @param list
	 * @return List<PermutationData>
	 */
	public List<PermutationData> savePermutations(List<PermutationData> list);

	/**
	 * @param string
	 * @return List<PermutationData>
	 */
	public List<PermutationData> getPermutations();

}
