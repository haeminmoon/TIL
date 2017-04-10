#include <cstdio>
#include <iostream>
#include <cstring>
using namespace std;

int main(){
  int T;

  cin >> T;
  for(int tc = 1;tc <= T; tc++){
    char N[10001],stack[10001],p=0;
    cin >> N;
    int len = strlen(N);
    for(int i=0;i<len;i++){
      if(p==0){
        stack[p++]=N[i];
      }
      else{
        if(stack[p-1]==N[i]){
          p--;
        }else{
          stack[p++]=N[i];
        }
      }

    }

    cout << "Case #" << tc << endl;
    if(p==0) cout << "true" << endl;
    else cout << "false" << endl;

  }
  return 0;
}
