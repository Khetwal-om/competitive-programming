public class Answer{

public static void main(String[] args) {
	System.out.println(romanToInt("IX"));
}

 private static int romanToInt(String s){
   int number;
   int 
   int[] charArray=s.toCharArray();
   for(int i=0;i<s.length;i++){
	if((charArray[i]=='I')  && ( charArray[i+1]=='V'||charArray[i+1]=='X')){
	  number=number+charArray[i+1]-I;
	}
	else if((charArray[i]=='X') &&(charArray[i+1]=='L'||charArray[i+1]=='C')){
	  number=number+charArray[i+1]-X;
	}

	else if((charArray[i]=='C') &&((charArray[i+1]=='D')||(charArray[i+1]=='M'))){
		number=number+charArray[i+1]-C;
	}
	else{
		
		if(charArray[i]=='M'){
		  number=number+M;
		}
		if(charArray[i]=='D'){
		  number=number+D;
		}
		if(charArray[i]=='C'){
		 number=number+C;
		}
		if(charArray[i]=='L'){
		 number=number+L;
		}
		if(charArray[i]=='X'){
		number=number+X;
		}
		if(charArray[i]=='V'){
		number=number+V;
		}
		if(charArray[i]=='III'){
		 number=number+III;
		}
		if(charArray[i]=='II'){
		 number=number+II;
		}
		if(charArray[i]=='I'){
		 number=number+I;
		}
		
		
	
	}

	return number;

}





}