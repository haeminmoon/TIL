#include <cstdio>
#include <iostream>
#include <algorithm>
using namespace std;

int main(){
  int T;

  cin >> T;
  for(int tc = 1;tc <= T; tc++){
    int N,l1,l2;
    char s1[21],s2[21];

    cout << "Case #" << tc << endl;
    cin >> s1;
    cin >> s2;
    l1=strlen(s1);
    l2=strlen(s2);
    bool flag=true;
    if(l1!=l2){
      flag=false;
    }else{
      sort(s1,s1+l1);
      sort(s2,s2+l2);
      for(int i=0;i<l1;i++){
        if(s1[i]!=s2[i]){
          flag=false;
        }
      }
    }
    if(flag){
      cout << "true" << endl;
    }else{
      cout << "false" << endl;
    }
  }
  return 0;
}
/*
3
asdf
dfas
aaaaaaaaaaaaaf
faaaaaaaaaafaa
hanwha
hahanw
*/
