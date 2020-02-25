### Dynamic programming



1. Simple solution . Perform further optimizations

```c++
#include <bits/stdc++.h>
using namespace std;





int main(){

    string value;
    cin>>value;
    int count=0;
    vector<int> yeah;

    for (int i = 0; i < value.size(); ++i) {
        if(value[i]%2==0){
            count+=1;
        }

       yeah.push_back(count);

    }
    cout<<endl;
    for(auto y:yeah){
        cout<<y<<" ";
    }

    return 0;
}
```