#include <cstdio>
#include <iostream>
#include <algorithm>
using namespace std;

int min(int a,int b){
  if(a<=b) return a;
  else return b;
}
int main(){
  int T,l1;
  char temp[10];
  cin >> T;
  cin.getline(temp,10);
  char ori[22]="Welcome to Hanwha S&C";
  l1=strlen(ori);

  for(int tc = 1;tc <= T; tc++){
    int map[23][10002]={0,},l2;
    char str[10001];
    cin.getline(str,10001);
    l2=strlen(str);
    for(int i=1;i<=l1;i++){
      map[i][0]=i;
      for(int j=1;j<=l2;j++){
        map[0][j]=j;
        map[i][j]=min(min(map[i-1][j]+1,map[i][j-1]+1),map[i-1][j-1]+(ori[i-1]==str[j-1]?0:1));
      }
    }
    cout << "Case #" << tc << endl;
    cout << map[l1][l2] << endl;
  }
  return 0;
}
/*
3
Qelcome to HanwhaSn&
Welcome to our company
Challenge Hanwha
*/
