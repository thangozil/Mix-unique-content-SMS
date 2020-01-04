package main;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import com.google.common.collect.Lists;

public class Application {
	public static void main(String[] args) {
			
		List<String> contentList = new ArrayList<String>();
		contentList.add("CHAO A BEN E CO GOI VAY_LS 0.9-1.25%, HANMUC 10-60TR, KO LAM THU TUC, NHAN E NHE, E NHI NGANHANG LANG SON");
		contentList.add("HI	C BEN NGANNHANG E CO GOI VAYVON LS:0,9_1,25%, HAN_MUC 10-55t, KHONG THE_CHAP, NHAN E NHA, E MY NGANHANG LANG SON");
		contentList.add("GUI ANH NGANHANG BEN E CO GOI VAYTIEN LS 0,9-1,25%, HAN.MUC 10-56T, KHONG LAM HO SO, NHAN LAI E, E LY NGAN-HANG LANGSON");
		contentList.add("CHI A CANVAY_TIEN BEN E CO GOI LS-0.9-1.25%, HAN-MUC 10-58T, KHONG CAN GIAY TO, NHAN CHO E, E LAN NGAN.HANG LANG-SON");
		contentList.add("NEU A CANVA.Y, NGANHANG E CO LS THAP_0,9-1,25%, HAN MUC$ 10-59T, KHONG CAN DUYET, NHAN E NHO, E LINH NGAN,HANG LS");
		contentList.add("BEN E CO GOIVAY LS0,9_1,25%, KVAY_ 10_51T, KHONG CAN LAM HOSO, SMS CHO E, E LAM NGAN.HANG LS");
		contentList.add("BEN E CO GOIVAY_VON LS:0,9_1,25%, GIAI_NGAN 10_55T, GIAINGAN NGAY, SMS LAI E, E HA NGAN/HANG LS");
		contentList.add("E DG CO GOIVAYVON LS/ 0,9-1.25%, VAYTU 10_59T, GIAINGAN TRG NGAY, INB LAI E, E HOA NGANHANG LS");
		contentList.add("NGANHANG E DUYET GOIVAY LS-0,9:1,25%, GOI_VAY 11-59T, GIAINGAN TRG 60P, INB CHO E, E HUE NGAN.HANG LS");
		
		Map<Character, List<Character>> alternativeMap = new HashMap<Character, List<Character>>();
		alternativeMap.put('I', Arrays.asList('I', 'j', '!', 'i', 'l', '|'));
		alternativeMap.put('E', Arrays.asList('E', '€'));
		alternativeMap.put('O', Arrays.asList('O', '0'));
		alternativeMap.put('Y', Arrays.asList('Y', '¥'));
		alternativeMap.put('0', Arrays.asList('0', 'O'));
		
		long totalMessage = 0;
		try {
			FileWriter writer = new FileWriter("output.txt");
			
			for (String content: contentList) {			
				Map<Integer, List<Character>> indexsToChange = new TreeMap<Integer, List<Character>>();
				
				for(Character c : alternativeMap.keySet()) {
					findAllIndexOfCharacter(content, c, indexsToChange, alternativeMap);
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
					//writer.write(current_result.toString() + System.lineSeparator());
				}
				System.out.println(String.format("Finish content: %s", changesList.size()));
			}
			writer.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		System.out.println(totalMessage);
		
	}
		

	private static void findAllIndexOfCharacter(String content, Character c, Map<Integer, List<Character>> indexsMatch, Map<Character, List<Character>> alternativeMap)
	{
		int index = content.indexOf(c);
		while (index >= 0) {
			indexsMatch.put(index, alternativeMap.get(c));
		    index = content.indexOf(c, index + 1);
		}
	}
}
