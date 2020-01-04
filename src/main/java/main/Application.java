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
		List<String> originalSMS  = new ArrayList<String>();
		originalSMS.add("CHAO A BEN E CO GOI VAY_LS 0.9-1.25%, HANMUC 10-60TR, KO LAM THU TUC, NHAN E NHE, E NHI NGANHANG LANG SON");
		originalSMS.add("HI C BEN NGANNHANG E CO GOI VAYVON LS:0,9_1,25%, HAN_MUC 10-55t, KHONG THE_CHAP, NHAN E NHA, E MY NGANHANG LANG SON");
		originalSMS.add("GUI ANH NGANHANG BEN E CO GOI VAYTIEN LS 0,9-1,25%, HAN.MUC 10-56T, KHONG LAM HO SO, NHAN LAI E, E LY NGAN-HANG LANGSON");
		originalSMS.add("CHI A CANVAY_TIEN BEN E CO GOI LS-0.9-1.25%, HAN-MUC 10-58T, KHONG CAN GIAY TO, NHAN CHO E, E LAN NGAN.HANG LANG-SON");
		originalSMS.add("NEU A CANVA.Y, NGANHANG E CO LS THAP_0,9-1,25%, HAN MUC$ 10-59T, KHONG CAN DUYET, NHAN E NHO, E LINH NGAN,HANG LS");
		originalSMS.add("BEN E CO GOIVAY LS0,9_1,25%, KVAY_ 10_51T, KHONG CAN LAM HOSO, SMS CHO E, E LAM NGAN.HANG LS");
		originalSMS.add("BEN E CO GOIVAY_VON LS:0,9_1,25%, GIAI_NGAN 10_55T, GIAINGAN NGAY, SMS LAI E, E HA NGAN/HANG LS");
		originalSMS.add("E DG CO GOIVAYVON LS/ 0,9-1.25%, VAYTU 10_59T, GIAINGAN TRG NGAY, INB LAI E, E HOA NGANHANG LS");
		originalSMS.add("NGANHANG E DUYET GOIVAY LS-0,9:1,25%, GOI_VAY 11-59T, GIAINGAN TRG 60P, INB CHO E, E HUE NGAN.HANG LS");
		
		new MixSms(originalSMS).GetUniqueSMS();
	}
}
