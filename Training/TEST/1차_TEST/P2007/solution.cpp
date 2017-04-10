#include <cstdio>
#include <iostream>
#include <algorithm>
using namespace std;

int main(){
  int T;
  cin >> T;
  for(int tc = 1;tc <= T; tc++){
    char man[101],rail[101];
    int manl,raill;
    cin >> rail;
    cin >> man;
    manl=strlen(man);
    raill=strlen(rail);
    int cnt=0;
    for(int i=0;i<manl;i+=raill){
      bool flag=true;
      for(int j=0;j<raill;j++){
        if(rail[j]=='B' && man[i+j]=='S'){
          flag=false;
          break;
        }
      }
      if(flag) cnt++;
    }

    cout << "Case #" << tc << endl;
    cout << cnt << endl;
  }
  return 0;
}
/*
3
GGGB
RRRRRRRRRRSSRRRSRSRSRSSSRRRRRSRR
GBGBGBGB
RRRRRRRSRSRSRSSSSSSRRRRRRSRSRRRRRSRSRSRSRRRRRSRS
BBGGGGG
SSSSSRRRRRRRRSSSRRRRRRSRSRRRRRSRRRRRRRRSSRRRRRRSRRRRRRRR
*/
