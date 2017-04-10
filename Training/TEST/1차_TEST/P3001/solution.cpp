#include<cstdio>
#include<iostream>
#include<algorithm>

using namespace std;
string binary(int x){
  string b="";
  while(x>1){
    b.append(to_string(x%2));
    x/=2;
  }
  b.append(to_string(x%2));
  reverse( b.begin(), b.end() );
  b.append("(2) ");
  return b;
}

int main(){
  int T;
  cin >> T;
  for(int tc=1;tc<=T;tc++){
    int N;
    cin >> N;

    cout << "Case #" << dec << tc << endl;
    cout << binary(N) << oct << N << "(8) " << hex << uppercase << N << "(16)" << endl;
  }
  return 0;
}
