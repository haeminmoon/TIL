#include <cstdio>
#include <iostream>

using namespace std;
int data[6];
int N=6,sum;

int main(){
  int T;

  cin >> T;
  for(int tc = 1;tc <= T; tc++){
    sum=0;
    for(int i=0;i<N;i++){
      cin >> data[i];
      sum+=data[i];
    }
    int res=0;
    for(int i=0;i<N;i++){
      for(int j=i+1;j<N;j++){
        for(int k=j+1;k<N;k++){
          if((data[i]+data[j]+data[k])*2>sum){
            res++;
          }
        }
      }
    }
    cout << "Case #" << tc << endl;
    cout << res << endl;

  }
  return 0;
}
/*
3
1 2 3 4 5 6
22 34 23 30 21 20
2 8 6 14 8 10
*/
