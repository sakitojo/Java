package test;
import dao.COUNTDAO;
	
	
public class test02 {
	
		public static void main(String[] args) {
		COUNTDAO dao = new COUNTDAO();
		
		System.out.println(dao.countrecord());
		
		}
	}
