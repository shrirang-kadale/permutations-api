/**
 * 
 */
package com.vgroup.permutations.model;

import java.util.Set;

import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * @author skadale
 *
 */

@Document("permutationData")
public class PermutationData {
	
	@JsonInclude(Include.NON_NULL)
	private String inputString;
	
	@JsonInclude(Include.NON_NULL)
	private Set<String> permutations;
	
	@JsonInclude(Include.NON_NULL)
	private Integer totalPerm;

	public String getInputString() {
		return inputString;
	}

	public void setInputString(String inputString) {
		this.inputString = inputString;
	}

	public Set<String> getPermutations() {
		return permutations;
	}

	public void setPermutations(Set<String> permutations) {
		this.permutations = permutations;
	}

	public Integer getTotalPerm() {
		return totalPerm;
	}

	public void setTotalPerm(Integer totalPerm) {
		this.totalPerm = totalPerm;
	}

	@Override
	public String toString() {
		return "PermutationData [inputString=" + inputString + ", permutations=" + permutations + ", totalPerm="
				+ totalPerm + "]";
	}
	

}
