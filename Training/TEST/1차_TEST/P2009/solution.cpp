#include <cstdio>
#include <iostream>

using namespace std;

int main(){
  int T;

  cin >> T;
  for(int tc = 1;tc <= T; tc++){
    int N,max=0,curr=0,x;
    cin >> N;
    while(N--){
      cin >> x;
      curr+=x;
      if(curr<0) curr=0;
      if(curr>max) max=curr;
    }
    cout << "Case #" << tc << endl;
    cout << max << endl;

  }
  return 0;
}
/*
3
4
1 2 3 4
3
-1 0 1
5
-1 -2 -3 -4 -1

*/
