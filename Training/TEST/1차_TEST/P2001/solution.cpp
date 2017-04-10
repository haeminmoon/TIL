#include <cstdio>
#include <iostream>

using namespace std;
char text[10][4]={"","일","이","삼","사","오","육","칠","팔","구"};
char danwi[3][4]={"천","백","십"};
void print(int x){
  int a[4],dan=1000,i=0;
  for(int i=0;i<4;i++){
    int t=x/dan;
    x%=dan;
    dan/=10;
    if((t==1&&i==3)||(t>1)){
      cout << text[t];
    }
    if(i!=3&&t>0){
      cout << danwi[i];
    }
  }
}
int main(){
  int T;
  cin >> T;

  for(int tc = 1;tc <= T; tc++){

    cout << "Case #" << tc << endl;
    int N,man,il;
    cin >> N;
    man=N/10000;
    il=N%10000;
    if(man>0){
      print(man);
      cout << "만 ";
    }
    print(il);
    cout << endl;

  }
  return 0;
}


/*
3
43
510111
12345678
*/
