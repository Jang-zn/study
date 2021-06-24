package test;

import java.util.Date;
import java.util.Calendar;

public class test {
	public static void main(String[] args) {
		
		Calendar cal = Calendar.getInstance();
		int last = cal.getActualMaximum(cal.DAY_OF_MONTH); //월 길이 (length로 사용)
		int today = cal.get(cal.DATE);
		System.out.println(last-today+1);
		
		
		int y = cal.get(cal.YEAR);
		String year = (""+y).substring(2); //YY
		
		
		int m = cal.get(cal.MONTH);
		String month="";  //MM
		if(m>10) {
			month=""+(m+1);
		}else {
			month="0"+(m+1);
		}
		String[] arrayCal = new String[last];
		
		for(int i = 0;i<last;i++) {
			cal.set(y, m, i+1);
			int wnum = cal.get(cal.DAY_OF_WEEK);
			String week ="";
			switch(wnum) {
				case 1: week="일"; break;
				case 2: week="월"; break;
				case 3: week="화"; break;
				case 4: week="수"; break;
				case 5: week="목"; break;
				case 6: week="금"; break;
				case 7: week="토"; break;
			}
			if(i<9) {
				arrayCal[i] = (""+year+"/"+month+"/0"+(i+1)+","+week);
			}else {
				arrayCal[i] = (""+year+"/"+month+"/"+(i+1)+","+week);
			}		
		}
		
		for(String s : arrayCal) {
			System.out.println("됐냐? " + s);
		}
	}
}
