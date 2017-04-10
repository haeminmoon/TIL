#include <cstdio>
#include <iostream>
#include <algorithm>

using namespace std;

int main(){
  int T;

  cin >> T;
  for(int tc = 1;tc <= T; tc++){
    int N,K,bc[11]={0,},bp[11][2001]={0,},table[11][2001]={0,};
    cin >> N >> K;

    for(int i = 0;i < N;i++){
      int c,g;
      cin >> c >> g;
      bp[g][bc[g]++]=c;
    }

    for(int i = 1;i <= 10;i++){
      sort(bp[i],bp[i] + bc[i],greater<int>());
    }

    for(int i = 1;i <= 10;i++){
      for(int j = 1;j <= K;j++){
        table[i][j] = max(table[i][j],table[i-1][j]);
      }
      for(int j = 1;j <= bc[i];j++){
        bp[i][j] += bp[i][j-1] + j*2;
        for(int l = j;l <= K;l++){
          table[i][l] = max(table[i][l],table[i-1][l-j]+bp[i][j-1]);
        }
      }
    }

    cout << "Case #" << tc << endl;
    cout << table[10][K] << endl;
  }
  return 0;
}
