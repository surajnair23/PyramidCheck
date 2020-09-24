package com.frassessment.app.services;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;

import org.springframework.stereotype.Service;

@Service
public class PyramidServiceImpl  implements PyramidService{
	
	@Override
	public boolean isPyramid(String s) {
		TreeMap<Character,Integer> map = new TreeMap();
		
		//create a map with count of occurrences
		for(char c:s.toCharArray()) {
			map.put(c, map.getOrDefault(c, 0)+1);
		}
		
		ArrayList<Map.Entry<Character,Integer>> list = new ArrayList(map.entrySet());
		//sort on basis of value
		Collections.sort(list, (Map.Entry<Character,Integer> m1, Map.Entry<Character,Integer> m2) -> m1.getValue()- m2.getValue());
		map.clear();
		
		//loop through the list of map values to find a sequence
		for(int i=1;i<list.size();i++){
            if(list.get(i).getValue() - list.get(i-1).getValue() != 1){
                return false;
            }
        }
        return true;
    }
}
