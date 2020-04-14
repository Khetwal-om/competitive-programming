1. Integer to roman

```java
public class Unique{
	public static void main(String[] args) {
		System.out.println(intToRoman(49));
	}


	private static final String[] romans=new String[]{"M","CM","D","CD","C","XC","L","XL",
	"X","IX","V","IV","I"};

	private static final int[] values=new int[]{1000,900,500,400,100,90,50,40,10,9,5,4,1};


	private static String intToRoman(int value){

		if(value>3999 || value<1) throw new IllegalArgumentException();

		StringBuilder numeral=new StringBuilder();
		int i=0;

		while(value>0){
			if(value-values[i]>=0){
				value=value-values[i];
				numeral.append(romans[i]);
			}
			else{
				i++;
			}
		}

		return numeral.toString();
	}



}
```