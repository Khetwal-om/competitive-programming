#include<bits/stdc++.h>

using namespace std;


int main(){
    int N,K;
    cin>>N>>K;

    unordered_set<int> elements;
    vector<int> values;
    int element;

    for(int i=0;i<N;i++){
        cin>>element;
        values.push_back(element);
    }

    sort(values.begin(),values.end());

    for(int i=0;i<values.size()-1;i++){
            for(int j=i+1;j<values.size();j++){
                        if(abs(values[i]-values[j])==K){
           elements.insert(values[i]);
           elements.insert(values[j]);
           }
            }

    }

    for(auto x:elements){
        cout<<x<<"  "<<endl;
    }

    return 0;
}
