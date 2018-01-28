package Multithreading;

public class MyThread {

	public static void main(String args[]) {

		String s1 = "abc";
		String s2 = s1;
		String s3 = new String("abc");
		String s4="abc";
			
		System.out.println(" s1==s2 : "+(s1==s2)+" s1 "+s1.hashCode()+" s2 "+s2.hashCode());
		
		System.out.println(" s2==s3 : "+(s2==s3));
		
		System.out.println(" s1==s3 : "+(s1==s3));
		
		System.out.println(" s1==s4 : "+(s1==s4));
		
		System.out.println(" s1.equals(s2) : "+s1.equals(s2));
		
		System.out.println(" s1.equals(s3) : "+s1.equals(s3));
		
		System.out.println(" s2.equals(s3) : "+s2.equals(s3));
		
		System.out.println(" s1.equals(s4) : "+s1.equals(s4));
	}
}
