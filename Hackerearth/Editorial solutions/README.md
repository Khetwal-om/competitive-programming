

# Arrays


1. Monk and welcome problem.


```c
#include<bits/stdc++.h>
using namespace std;
int main()
{
	int a[100005],b[100005];
	int n;
	scanf("%d",&n);
	for(int i=0;i<n;i++)
		scanf("%d",&a[i]);
	for(int i=0;i<n;i++)
	{
		scanf("%d",&b[i]);
		b[i]+=a[i];
	}
	for(int i=0;i<n;i++)
		printf("%d ",b[i]);
	return 0;
}
```


2. Help Jarvis

```c++
#include<bits/stdc++.h>
using namespace std;
int main(){
    int t;
    cin>>t;
    while(t--){
        int n,a[10]={0},mi=INT_MAX,ma=INT_MIN,i=0;
        string s;
        cin>>s;
        while(i<s.length()){
            mi=min(mi,s[i]-'1'+1);
            ma=max(ma,s[i]-'1'+1);
            a[s[i]-'1'+1]+=1;
            i++;
        }
        for(i=mi;i<=ma;i++){
            if(a[i]!=1){
                cout<<"NO\n";
                break;
            }
        }
        if(i==ma+1)
        cout<<"YES\n";
    }
}
```


3. Polygon possibility

---

:heart:

The main concept:(sum<=2\*mx)

---


```c++

#include<bits/stdc++.h>
using namespace std;
int main()
{
    ios::sync_with_stdio(0);
    cin.tie(0);
    int t;
    cin>>t;
    
    while(t--)
    {
        int n;
        cin>>n;
        int mx=0;
        int sum =0;
        for(int i=0;i<n;i++)
        {
            int n;
            cin>>n;
            mx=max(n,mx);
            sum+=n;
        }
        if(sum<=2*mx)
        {
            cout<<"No\n";
        }
        else
        cout<<"Yes\n";
    }
    return 0;
}

```



4. :heart:  Wow. Retrieving the elements from the right hand side which are greater than
those on the left.

```c
16 17 4 3 5 2
17 5 2
```


```c++
#include <stdio.h>
int main(void)
{
    int n;
    scanf("%i", &n);
    int arr[n],max=0,tmpwa[n],j=0;
    for(int i=0;i<n;++i)
    {
        scanf("%i",&arr[i]);
    }
    for(int i=n-1;i>=0;--i)
    {
        if(arr[i] >= max)
        {
            tmpwa[j++] = arr[i];
            max = arr[i];
        }
    }
    for(j-=1; j >=0;--j)
        printf("%i ",tmpwa[j]);
    return 0;
}
```



5. Mirco and Array update

```c++
#include<bits/stdc++.h>
using namespace std;
int main(){
	int t;cin>>t;
	while(t--){
		int n, k;cin>>n>>k;
		int ans = k;
		for(int i=1; i<=n; i++){
			int temp;cin>>temp;
			ans = min(ans, temp);
		}
		cout<<k-ans<<endl;
	}
	return 0;
}
```


6. Maximize the earning

```c++
 for(long long i=0;i<n;i++){
            cin>>x;
            if(i==0){
               s.push(x);//pushing first element to stack
               count++;
            }
            //check if next one is greater than top element of stack
            if(i>0){
                if(x>s.top()){
                    s.push(x);
                    count++;
                }
            }
            
        }
        cout<<count*k<<endl;

```



---


```c++
#include<iostream>
#include<stack>
#include<bits/stdc++.h>
using namespace std;
int main(){
    int t;
    cin>>t;
    for(int a=0;a<t;a++){
        long long n,k;
        cin>>n;
        cin>>k;
        stack<long long> s;
        long long x;
        long long count=0;//count initialise to 0.
        for(long long i=0;i<n;i++){
            cin>>x;
            if(i==0){
               s.push(x);//pushing first element to stack
               count++; 
            }
            //check if next one is greater than top element of stack
            if(i>0){
                if(x>s.top()){
                    s.push(x);
                    count++;
                }
            }
            
        }
        cout<<count*k<<endl;
        
    }
}
```



