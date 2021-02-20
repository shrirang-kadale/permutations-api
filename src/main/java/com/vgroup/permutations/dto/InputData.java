/**
 * 
 */
package com.vgroup.permutations.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * @author skadale
 *
 */
public class InputData {
	
	@Size(max=5, min=2, message="Invalid Input1 size : Length should be greater than equal to 2 and less than equal to 5")
	@NotNull
	private String input1;
	
	@Size(max=6, min=2, message="Invalid Input2 size : Length should be greater than equal to 2 and less than equal to 6")
	@NotNull
	private String input2;
	
	@Size(max=4, min=0, message="Invalid Input3 size : Length should be greater than equal to 0 and less than equal to 4")
	private String input3;
	
	public String getInput1() {
		return input1;
	}
	public void setInput1(String input1) {
		this.input1 = input1;
	}
	public String getInput2() {
		return input2;
	}
	public void setInput2(String input2) {
		this.input2 = input2;
	}
	public String getInput3() {
		return input3;
	}
	public void setInput3(String input3) {
		this.input3 = input3;
	}
	
	@Override
	public String toString() {
		return "InputData [input1=" + input1 + ", input2=" + input2 + ", input3=" + input3 + "]";
	}

	

}
