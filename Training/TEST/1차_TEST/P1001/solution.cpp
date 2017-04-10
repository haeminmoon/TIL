#include <cstdio>
#include <iostream>
#include <cmath>
using namespace std;
struct circle{
  double r,v,p,t;

};

int main(){
  int T;

  cin >> T;
  for(int tc = 1;tc <= T; tc++){
    circle A,B;
    double t,collisiont;
    cin >> A.r >> A.v >> A.p;
    cin >> B.r >> B.v >> B.p;
    cin >> t;
    if(A.p>B.p){
        circle temp = A;
        A=B;
        B=temp;
    }
    B.p-=A.p;
    A.p=0;
    B.v+=A.v;
    A.v=0;
    collisiont= (B.p-sqrt((A.r+B.r)*(A.r+B.r)-(A.r-B.r)*(A.r-B.r)))/B.v;

    cout << "Case #" << tc << endl;
    if(collisiont>t) cout << "before" << endl;
    else if(collisiont==t) cout << "boom" << endl;
    else cout << "after" << endl;

  }
  return 0;
}
/*
3
1 2 10
4 1 0
2
1 1 1
1 3 7
1
4 1 1
10 10 100
2
1 2 3
20 3 30
7
*/
