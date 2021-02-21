/**
 * 
 */
package com.vgroup.permutations.daoImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

import com.vgroup.permutations.dao.PermutationsDao;
import com.vgroup.permutations.model.PermutationData;

/**
 * @author skadale
 *
 */
@Repository
public class PermutationsDaoImpl implements PermutationsDao{
	
	@Autowired
	MongoTemplate mongoTemplate;
	
	@Override
	public List<PermutationData> savePermutations(List<PermutationData> data) {
		List<PermutationData> save = (List<PermutationData>) mongoTemplate.insertAll(data);
		return save;
	}


	@Override
	public List<PermutationData> getPermutations() {
		List<PermutationData> allPermutations = mongoTemplate.findAll(PermutationData.class);
		return allPermutations;
	}



}
