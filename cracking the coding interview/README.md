

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


