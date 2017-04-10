#include <cstdio>
#include <iostream>

using namespace std;
long long int fac(int x){
  return x==1 ? 1 : x*fac(x-1);
}
int main(){
  int T;
  cin >> T;
  long long int table[30]={0,};
  table[0]=1;
  table[1]=1;
  table[2]=2;
  for(int i=3;i<30;i++){
    for(int j=0;j<i;j++){
      table[i]+=table[j]*table[i-j-1];
    }
  }
  for(int tc = 1;tc <= T; tc++){
    long long int N;
    cin >> N;
    cout << "Case #" << tc << endl;
    cout << table[N] << endl;
  }
  return 0;
}
