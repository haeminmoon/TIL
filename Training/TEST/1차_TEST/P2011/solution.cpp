#include<cstdio>
#include<vector>
#include<iostream>

using namespace std;

vector<int> graph[1002];
bool chk[1002];
int rev[1002];

int dfs(int p){
  for (int i=0; i<graph[p].size(); i++){
    int n = graph[p][i];
    if (chk[n]){
      chk[n] = false;
      if (rev[n] == 0 || dfs(rev[n])){
        rev[n] = p;
        return true;
      }
    }
  }
  return false;
}

int main()
{
  int T;
  cin >> T;
  for(int tc=1; tc<=T; tc++){
    int N;
    int arr[1001][3] = {0, };
    cin >> N;
    for (int i=1; i<=N; i++){
      cin >> arr[i][0] >> arr[i][1] >> arr[i][2];
      graph[i].clear();
    }
    for (int i=1; i<=N; i++){
      for (int j=1; j<=N; j++){
        if (arr[i][0]>=arr[j][0] && arr[i][1]>=arr[j][1] && arr[i][2]>=arr[j][2]){
          if (arr[i][0]==arr[j][0] && arr[i][1]==arr[j][1] && arr[i][2]==arr[j][2] && i>=j) continue;
          graph[i].push_back(j);
        }
      }
    }
    int ans = 0;
    fill(rev,rev+N+1,0);
    for (int i=0; i<2*N; i++){
      fill(chk,chk+N+1,true);
      if(dfs(i%N+1)) ans++;
    }
    cout << "Case #" << tc << endl;
    cout << N - ans << endl;
  }
}
