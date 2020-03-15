


1. String compression


```c++


string compress(string s){
	int sum=1;
	int answer="";

	for(int i=0;i<s.size()-1;i++){
		if(s.at(i)==s.at(i+1)){
			sum+=1;
		}
		else{
			answer+=s.at(i)+sum;
			sum=1;
		}
	}
	answer=answer+s.at(s.size()-1)+sum;
}





```