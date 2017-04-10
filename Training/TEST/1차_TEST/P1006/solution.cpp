#include <cstdio>
#include <iostream>
#include <cstring>
using namespace std;

int main(){
  int T;

  cin >> T;
  for(int tc = 1;tc <= T; tc++){
    char N[10010];
    int X[10011];
    cin >> N;
    cout << "Case #" << tc << endl;
    int len = strlen(N);
    for(int i=0;i<len;i++){
      X[i]=N[len-1-i]-'0';
    }
    X[0]+=1;
    for(int i=0;i<len;i++){
      if(i==len-1) continue;
      X[i+1]+=X[i]/10;
      X[i]%=10;
    }
    for(int i=len-1;i>=0;i--){
      cout << X[i];
    }
    cout << endl;
  }
  return 0;
}


/*
3
30
140
9999999999999999999
*/
