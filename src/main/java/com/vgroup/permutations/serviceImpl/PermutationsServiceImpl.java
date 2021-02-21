/**
 * 
 */
package com.vgroup.permutations.serviceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vgroup.permutations.dao.PermutationsDao;
import com.vgroup.permutations.dto.InputData;
import com.vgroup.permutations.model.PermutationData;
import com.vgroup.permutations.service.PermutationsService;
import com.vgroup.permutations.util.PermutationUtils;

/**
 * @author skadale
 *
 */

@Service
public class PermutationsServiceImpl implements PermutationsService{
	
	@Autowired
	private PermutationsDao permutationsDao;
	
	@Autowired
	private PermutationUtils utils;

	/**
	 * Return all permutations for all three inputs
	 * @return List<PermutationData>
	 * @param InputData
	 */
	@Override
	public List<PermutationData> savePermutations(InputData inputData) {
		List<PermutationData> list = new ArrayList<>();
		for(int i=1; i < 4; i++) {
			String str = getInputData(inputData, i);
			Set<String> permutations = utils.permutationFinder(str);
			PermutationData data = new PermutationData();
			if(Objects.nonNull(permutations)) {
				data.setInputString(str);
				data.setPermutations(permutations);
				data.setTotalPerm(permutations.size());
			}
			list.add(data);
		}
		return permutationsDao.savePermutations(list);
	}

	/**
	 * @return String 
	 * @param inputData
	 * @param i
	 */
	private String getInputData(InputData inputData, int i) {
		String str = null;
		switch(i) {
		case 1 : 
			str = inputData.getInput1();
			break;
		case 2 : 
			str = inputData.getInput2();
			break;
		case 3 : 
			str = inputData.getInput3();
			break;
		}
		return str;
	}

	@Override
	public List<PermutationData> getPermutations() {
		return permutationsDao.getPermutations();
	}

}
