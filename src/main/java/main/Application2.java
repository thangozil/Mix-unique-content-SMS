package main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.common.collect.Lists;

public class Application2 {
	
	public static void main(String[] args) {		
		List<String> loiChao = Arrays.asList("CHAO", "HI", "GUI");
		List<String> danhXung = Arrays.asList("A", "C", "ANH ", "CHI");
		List<String> noidung1 = Arrays.asList("BEN E CO GOI VAY_LS 0.9-1.25%",
											  "BEN NGANNHANG E CO GOI VAYVON LS:0,9_1,25%",
											  "NGANHANG BEN E CO GOI VAYTIEN LS 0,9-1,25% ",
											  "A CANVAY_TIEN BEN E CO GOI LS-0.9-1.25%",
											  "NEU A CANVA.Y, NGANHANG E CO LS THAP_0,9-1,25%",
											  "BEN E CO GOIVAY LS0,9_1,25%",
											  "BEN E CO GOIVAY_VON LS:0,9_1,25%",
											  "E DG CO GOIVAYVON LS/ 0,9-1.25%",
											  "NGANHANG E DUYET GOIVAY LS-0,9:1,25%");
	    List<String> noidung2 = Arrays.asList(",HANMUC 10-60TR",
											  ",HAN_MUC 10-55t",
											  ",HAN.MUC 10-56T",
											  ",HAN-MUC 10-58T",
											  ",HAN MUC$ 10-59T",
											  ",KVAY_ 10_51T",
											  ",GIAI_NGAN 10_55T",
											  ",VAYTU 10_59T",
											  ",GOI_VAY 11-59T");
	    List<String> noidung3 = Arrays.asList(",KO LAM THU TUC",
											  ",KHONG THE_CHAP",
											  ",KHONG LAM HO SO",
											  ",KHONG CAN GIAY TO",
											  ",KHONG CAN DUYET",
											  ",KHONG CAN LAM HOSO",
											  ",GIAINGAN NGAY",
											  ",GIAINGAN TRG NGAY",
											  ",GIAINGAN TRG 60P");
		List<String> noidung4 = Arrays.asList(",NHAN E NHE",
											  ",NHAN E NHA",
											  ",NHAN LAI E",
											  ",NHAN CHO E",
											  ",NHAN E NHO",
											  ",SMS CHO E",
											  ",SMS LAI E",
											  ",INB LAI E",
											  ",INB CHO E");
		List<String> noidung5 = Arrays.asList(",E NHI NGANHANG LANG SON",
											  ",E MY NGANHANG LANG SON",
											  ",E LY NGAN-HANG LANGSON",
											  ",E LAN NGAN.HANG LANG-SON",
											  ",E LINH NGAN,HANG LS",
											  ",E LAM NGAN.HANG LS",
											  ",E HA NGAN/HANG LS",
											  ",E HOA NGANHANG LS",
											  ",E HUE NGAN.HANG LS");
		
		List<List<String>> originalListSMS = Lists.cartesianProduct(loiChao, danhXung, noidung1, noidung2, noidung3, noidung4, noidung5);
		
		List<String> originalSMS = new ArrayList<String>();
		
		for(List<String> originalList : originalListSMS) {
			String sms = String.join(" ", originalList);
			originalSMS.add(sms);
		}
		
		System.out.println(originalSMS.size());
		
		new MixSms(originalSMS).GetUniqueSMS();
		
	}

}
