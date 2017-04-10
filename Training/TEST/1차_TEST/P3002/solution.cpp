#include<cstdio>
#include<iostream>
#include<algorithm>

using namespace std;

int main(){
  int T;
  cin >> T;
  for(int tc=1;tc<=T;tc++){
    int N,res=0;
    cin >> N;
    for(int i=5;i<=N;i++){
      int x=i;
      while(x%5==0){
        res++;
        x/=5;
      }
    }
    cout << "Case #" << tc << endl;
    cout << res << endl;
  }
  return 0;
}
