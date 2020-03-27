import java.util.*;
public class Unique  {
	public static void main(String[] args) {
	 
        String s="aabcccccaaaaax";
        System.out.println(stringCompression(s));

	}


	private static String stringCompression(String s){
		int count;
		StringBuilder answer=new StringBuilder("");
		for (int i=0; i<s.length(); i++) {
			count=1;
			char c=s.charAt(i);
			while((i<s.length()-1)&&c==s.charAt(i+1)){
				count++;
				i++;
			}
			answer.append(c);
			answer.append(count);
		}
		return answer.toString();
	}

 
}	
 





