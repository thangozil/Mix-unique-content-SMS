package main;

import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import com.google.common.collect.Lists;

public class MixSms {
	private List<String> originalSMS;
	private Map<Character, List<Character>> alternativeMap;
	
	public MixSms(List<String> originalSMS) {
		this.originalSMS = originalSMS;
		
		this.alternativeMap = new HashMap<Character, List<Character>>();		
		alternativeMap.put('I', Arrays.asList('I', 'j', '!', 'i', 'l', '|'));
		alternativeMap.put('E', Arrays.asList('E', '€'));
		alternativeMap.put('O', Arrays.asList('O', '0'));
		alternativeMap.put('Y', Arrays.asList('Y', '¥'));
		alternativeMap.put('0', Arrays.asList('0', 'O'));
	}
		
	public void GetUniqueSMS() {		
		long totalMessage = 0;
		try {
			FileWriter writer = new FileWriter("output.txt");
			
			for (String content: originalSMS) {			
				Map<Integer, List<Character>> indexsToChange = new TreeMap<Integer, List<Character>>();
				
				for(Character c : alternativeMap.keySet()) {
					findAllIndexOfCharacter(content, c, indexsToChange);
				}
				
				
				List<List<Character>> indexsToChangeValue = new ArrayList<List<Character>>(indexsToChange.values());
				
				List<List<Character>> changesList = Lists.cartesianProduct(indexsToChangeValue);
				
				totalMessage += changesList.size();
				
				List<Integer> indexsToChangeKey = new ArrayList<Integer>(indexsToChange.keySet());
				
				StringBuilder current_result = new StringBuilder(content);
				for (List<Character> change: changesList) {
					for (int i = 0; i < indexsToChangeKey.size(); i++) {
						current_result.setCharAt(indexsToChangeKey.get(i), change.get(i));
					}
					writer.write(current_result.toString() + System.lineSeparator());
				}
				System.out.println(String.format("Finish content: %s", changesList.size()));
			}
			writer.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		System.out.println(totalMessage);
		
	}
		

	private void findAllIndexOfCharacter(String content, Character c, Map<Integer, List<Character>> indexsToChange)
	{
		int index = content.indexOf(c);
		while (index >= 0) {
			indexsToChange.put(index, alternativeMap.get(c));
		    index = content.indexOf(c, index + 1);
		}
	}
}
