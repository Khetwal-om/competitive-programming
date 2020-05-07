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













### Reverse the stack without  any additional data structure


> Insert at bottom is *O(n)* \
  runtime for reverse is also **O(n)** but we call
  insertAtBotto() so *O(n^2)*




> Space : \
InsertAtBottom = every item in stack  has to be stored in \
call stack , *O(n)* \
reverse = __O(n)+O(n)__

```java

public Stack<Integer> reverse(Stack<Integer> stack){
	if(stack.isEmpty()){
		return stack;
	}
	int temp=stack.pop();
	reverse(stack);
	insertAtBottom(stack,temp);
	return stack;
}


public void insertAtBottom(Stack<Integer> stack,int x){
	if(stack.isEmpty()){
		stack.push(x);
		return;
	}
	int temp=stack.pop();
	insertAtBottom(stack,x);
	stack.push(temp);
}


```

### Kth most frequent string

```java

public String KthMostFrequent(String[] strings,int k){
	HashMap<String,Integer> map=new HashMap<String,Integer>();


	for(String s:strings){
		Integer x=map.get(s);
		if(x==null) x=0;
		map.put(s,++x);
	}

	List<Map.Entry> list=new ArrayList(map.entrySet());

	Collection.sort(list,new Comparator(){
		public int compare(Object o1,Object o2){
			Integer v1=(Integer)((Map.Entry) o1).getValue();
			Integer v2=(Integer)((Map.Entry) o2).getValue();
			return v1.compareTo(v2);
		}
	})
}



```