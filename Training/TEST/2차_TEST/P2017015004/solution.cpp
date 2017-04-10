#include <iostream>
#include <algorithm>

#define MOD 1000000007
using namespace std;

int table(int N,int K){
  int dp[110][510]={0,};

  for(int j=0;j<N;j++){
    for(int i=min(j+1,K);i>0;i--){
      if(i==1){
        dp[i][j]=1;
      }
      else{
        for(int k=0;k<N;k++){
          dp[i][(j+k)%N]=(dp[i][(j+k)%N]+dp[i-1][k])%MOD;
        }
      }
    }
  }
  return dp[K][0];
}

int main(){
  int T,N,K;
  cin >> T;
  for(int tc=1; tc<=T; tc++){
    cin >> N >> K;
    cout << "Case #" << tc << endl;
    cout << table(N,K) << endl;
  }
  return 0;
}
