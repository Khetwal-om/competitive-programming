# STL features in C++

1. Vector

```c++
#include "stdfix.h"
#include <iostream>
#include <vector>

using namespace std;

int main()
{
    //c++ STL features

    vector<int> Abc;

    Abc.push_back(32);
    Abc.push_back(34);
    Abc.push_back(43);
    
    
}

```

2. Sort

```c++
#include "stdfix.h"
#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int main()
{
    //c++ STL features
    vector<int> A;

    A.push_back(34);
    A.push_back(4);
    A.push_back(2);
    A.push_back(334);
    A.push_back(43);

    sort(A.begin(),A.end());  // O(nLogn)

    for(int i=0;i<A.size();i++)
    {

        cout<<A[i]<<endl;
    }


}
```

3. binary_search 


```c++
#include "stdfix.h"
#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int main()
{
    //c++ STL features
    vector<int> A;

    A.push_back(34);
    A.push_back(4);
    A.push_back(2);
    A.push_back(334);
    A.push_back(43);

    sort(A.begin(),A.end());  // O(nLogN)

    for(int i=0;i<A.size();i++)
    {
        cout<<A[i]<<endl;
    }

    //binary search  O(LogN)
    bool present= binary_search(A.begin(),A.end(),4); //true     1
    cout<<"First instance of present"<<present<<endl;
    present=binary_search(A.begin(),A.end(),7);  //false       0
    cout<<"second instance of present"<<present<<endl;

}

```

4. Adding more elements, Iterator
  
 > The position of it is and position of it2 is subtracted in difference of two iterators.

```c++
#include "stdfix.h"
#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int main()
{
    //c++ STL features
    vector<int> A;

    A.push_back(2);
    A.push_back(4);
    A.push_back(22);
    A.push_back(14);
    A.push_back(43);

    sort(A.begin(),A.end());  // O(nLogN)

    for(int i=0;i<A.size();i++)
    {
        cout<<A[i]<<endl;
    }

    //binary search  O(LogN)
    bool present= binary_search(A.begin(),A.end(),4); //true
    cout<<"First instance of present"<<present<<endl;
    present=binary_search(A.begin(),A.end(),7);  //false
    cout<<"second instance of present"<<present<<endl;

    A.push_back(100);
    A.push_back(100);
    A.push_back(100);
    A.push_back(100);
    A.push_back(123);

    // First occurence of 7
    //lower bound means first value >= x

    vector<int>::iterator it=lower_bound(A.begin(),A.end(),100);

    // upper bound means element strictly greater    >
    vector<int>::iterator it2=upper_bound(A.begin(),A.end(),100);
    cout<<"It :"<<*it<<"IT2 : "<<*it2<<endl;
    cout<<"Difference"<<it2-it<<endl; //4 iterators are random arithmetic operation is possible
    //lower bound and upper bound on a sorted vector is done in logn time using binary search


}

```

5. 

```c++
#include "stdfix.h"
#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int main()
{
    //c++ STL features
    vector<int> A;

    A.push_back(2);
    A.push_back(4);
    A.push_back(22);
    A.push_back(14);
    A.push_back(43);

    sort(A.begin(),A.end());  // O(nLogN)

    for(int i=0;i<A.size();i++)
    {
        cout<<A[i]<<endl;
    }

    //binary search  O(LogN)
    bool present= binary_search(A.begin(),A.end(),4); //true
    cout<<"First instance of present"<<present<<endl;
    present=binary_search(A.begin(),A.end(),7);  //false
    cout<<"second instance of present"<<present<<endl;

    A.push_back(7);
    A.push_back(7);
    A.push_back(7);
    A.push_back(7);
    A.push_back(88);
    A.push_back(55);
    A.push_back(99);

    // First occurence of 7
    //lower bound means first value >= x

    vector<int>::iterator it=lower_bound(A.begin(),A.end(),100);

    // upper bound means element strictly greater    >
    vector<int>::iterator it2=upper_bound(A.begin(),A.end(),100);
    cout<<"It :"<<*it<<"IT2 : "<<*it2<<endl;
    cout<<"Difference"<<it2-it<<endl; //4 iterators are random arithmetic operation is possible
    //lower bound and upper bound on a sorted vector is done in logn time using binary search

    cout << "***************************"<<endl;
    for(int i=0;i<A.size();i++)
    {
        cout<<A[i]<<"  ";
    }

     vector<int>::iterator it3=lower_bound(A.begin(),A.end(),7);

    // upper bound means element strictly greater    >
    vector<int>::iterator it4=upper_bound(A.begin(),A.end(),7);
    cout<<"It3 :"<<*it3<<"IT4 : "<<*it4<<endl;
    cout<<"Difference"<<it4-it3<<endl;
}




Explore this

First instance of present1
second instance of present0
It :0IT2 : 0
Difference0
***************************
2  4  14  22  43  7  7  7  7  88  55  99  It3 :14IT4 : 88
Difference7

```


6. Sorting the vector in reverse order.

```c++

bool f(int x,int y)
{
    return x>y;
}

  // sorting in reverse order
    sort(A.begin(),A.end(),f);

    vector<int>::iterator it5;

    for(it5=A.begin();it5!=A.end();it5++)
    {
        cout<<*it5<<" ";
    }
    cout<<endl;
```

7. 

```c++

#include "stdfix.h"
#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;


bool f(int x,int y)
{
    return x>y;
}
int main()
{
    //c++ STL features
    vector<int> A;

    A.push_back(2);
    A.push_back(4);
    A.push_back(22);
    A.push_back(14);
    A.push_back(43);

    sort(A.begin(),A.end());  // O(nLogN)

    for(int i=0;i<A.size();i++)
    {
        cout<<A[i]<<endl;
    }

    //binary search  O(LogN)
    bool present= binary_search(A.begin(),A.end(),4); //true
    cout<<"First instance of present"<<present<<endl;
    present=binary_search(A.begin(),A.end(),7);  //false
    cout<<"second instance of present"<<present<<endl;

    A.push_back(7);
    A.push_back(7);
    A.push_back(7);
    A.push_back(7);
    A.push_back(88);
    A.push_back(55);
    A.push_back(99);

    // First occurence of 7
    //lower bound means first value >= x

    vector<int>::iterator it=lower_bound(A.begin(),A.end(),100);

    // upper bound means element strictly greater    >
    vector<int>::iterator it2=upper_bound(A.begin(),A.end(),100);
    cout<<"It :"<<*it<<"IT2 : "<<*it2<<endl;
    cout<<"Difference"<<it2-it<<endl; //4 iterators are random arithmetic operation is possible
    //lower bound and upper bound on a sorted vector is done in logn time using binary search

    cout << "***************************"<<endl;
    for(int i=0;i<A.size();i++)
    {
        cout<<A[i]<<"  ";
    }

     vector<int>::iterator it3=lower_bound(A.begin(),A.end(),7);

    // upper bound means element strictly greater    >
    vector<int>::iterator it4=upper_bound(A.begin(),A.end(),7);
    cout<<"It3 :"<<*it3<<"IT4 : "<<*it4<<endl;
    cout<<"Difference"<<it4-it3<<endl;

    // sorting in reverse order
    sort(A.begin(),A.end(),f);

 //   vector<int>::iterator it5;

   // for(it5=A.begin();it5!=A.end();it5++)
    //{
      //  cout<<*it5<<" ";
   // }
    //cout<<endl;

    // Alternative

    for(int x : A)
    {
        cout<<x<<"  ";
    }
    cout<<endl;

    // To iterate by reference

   // for(int &x:A)
 //   {
        //x++;
      //  cout<<x<<;
    //}



}

```

8. An alternative approach to iterator

```c++

     vector<int>::iterator it3=lower_bound(A.begin(),A.end(),7);
     auto it3=lower_bound(A.begin(),A.end(),7);  //alternative approach

```

9. To iterate by reference

```c++
 // To iterate by reference

    for(int &x:A)
    {
        x++;
        cout<<x<<;
    }

```


10. 