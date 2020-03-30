

1. Arrays and  Strings , The use of ArrayList (Dynamic array)

```java
import java.util.ArrayList;

public class Hi {
    public static void main(String[] args) {

        System.out.println("hi");
        ArrayList<String> sentence=merge(args,args);
        for(String s:sentence){
            System.out.print(s+" ");
        }

        System.out.println("");
        System.out.print(joinwords(args));
    }

     private static ArrayList<String> merge(String[] words,String[] more){
        ArrayList<String> sentence=new ArrayList<String>();
        for(String w:words)
            sentence.add(w);
        for(String m:more)
            sentence.add(m);

        return sentence;

    }

    private  static String joinwords(String[] words){
        StringBuilder sentence=new StringBuilder();
        for(String w:words) sentence.append(w);


        return sentence.toString();
    }

}
 


```






2. String permutation   **DevBox**   :)





```java

public class Unique{
    public static void main(String[] args) {
        String s="ABCD";
        int n=s.length();
        calculate(s,0,n-1);
    }


    private static void calculate(String str,int left,int right){
        if(left==right){
            System.out.println(str);
        }
        else{
            for(int i=left;i<=right;i++){
                String swapped=swap(str,left,i);
                calculate(swapped,left+1,right);
            }
        }
    }



    private static String swap(String str,int i,int j){
        char temp;
        char[] charArray=str.toCharArray();

        temp=charArray[i];
        charArray[i]=charArray[j];
        charArray[j]=temp;

        return String.valueOf(charArray);
    }

}
```



