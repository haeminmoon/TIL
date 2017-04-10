#include <string>
#include <algorithm>
#include <vector>
#include <iostream>
#include <cstring>
using namespace std;

int main(){
  int T;

  cin >> T;

  for(int tc = 1;tc <= T; tc++){
    cout << "Case #" << tc << endl;
    char str[10001];
    cin >> str;
    int len = strlen(str);
    for(int i=0;i<len;i++){
      bool flag=true;
      if(str[i]!='1'){
        for(int j=i+1;j<len;j++){
          if(str[i]==str[j]){
            str[j]='1';
            flag=false;
          }
        }
        if(flag) cout << str[i];
      }

    }
    cout << endl;


  }
  return 0;
}
