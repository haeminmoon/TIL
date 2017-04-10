#include <cstdio>
#include <iostream>
#include <algorithm>
using namespace std;

double data[102][3];

bool overlap(int i,int j){
  return (data[i][0]-data[j][0])*(data[i][0]-data[j][0])+(data[i][1]-data[j][1])*(data[i][1]-data[j][1])<(data[i][2]+data[j][2])*(data[i][2]+data[j][2]);
}

int main(){
  int T;
  cin >> T;

  for(int tc = 1;tc <= T; tc++){
    int N;
    cin >> N;
    for(int i=0;i<N;i++){
      cin >> data[i][0] >> data[i][1] >> data[i][2];
    }
    int cnt=0;
    for(int i=0;i<N;i++){
      for(int j=0;j<N;j++){
        if(i==j) continue;
        if(overlap(i,j)){
           cnt++;
           break;
         }
      }
    }

    cout << "Case #" << tc << endl;
    cout << cnt << endl;
  }
  return 0;
}
/*
3
3
-10.00 -30.00 40
-10.00 -20.00 30
-10.00 -40.00 25
5
-10.00 20.00 15.00
30.10 10.00 10.00
20.10 10.00 10.00
0.00 20.00 5.00
10.00 20.00 10.00
4
-100 10 10
-1000 10 10
-10000 10 10
-10000 10 10
*/
