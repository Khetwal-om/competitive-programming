


2. Win the game
  1. probability of selecting a red ball from total *in the first chance* = r/(r+g)
  2. if satyam selects: green [ g/(r+g) ] ; then kunal selects green ball [ (g-1)/(r+g) ]; and then probability of satyam getting the red ball [ dp[r][g-2] ].


```c++
#include <bits/stdc++.h> 
using namespace std ;
#define ll long long int
double dp[1003][1003];
int main()
{

  ll t;
  cin>>t;
  while(t--){
     ll n,m;
     memset(dp,0, sizeof(dp));
     cin>>n>>m;
     for (int i = 0; i <=n; i++)
     {
        for (int j = 0; j <=m; j++)
        {
          if(i==0){ dp[i][j]=1; continue;}
          if(j==0){ dp[i][j]=1; continue;}
          dp[i][j]= i*1.0/(i+j)+ (j*1.0/(i+j))*((j-1)*1.0/(i+j-1))*dp[i][j-2];
        }
     }
     printf("%.6f\n",dp[n][m]);
  }

return 0;
}
```
