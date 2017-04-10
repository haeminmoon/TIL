#include <cstdio>
#include <cmath>
#include <iostream>

using namespace std;
int L,N,data[30][2],maxpos;
double maxdis;
double distance(int x,int y){
  return sqrt((data[x][0]-data[y][0])*(data[x][0]-data[y][0]) + (data[x][1]-data[y][1])*(data[x][1]-data[y][1]));
}

void dfs(int curr,int depth){
  if(depth==4) return;
  if(maxdis<distance(0,curr)){
    maxdis=distance(0,curr);
    maxpos=curr;
  }
  for(int i=1;i<=N;i++){
    if(distance(curr,i)<=(depth+1)*L){
      dfs(i,depth+1);
    }
  }
}
int main(){
  int T;

  cin >> T;
  for(int tc = 1;tc <= T; tc++){
    cin >> L >> N;
    data[0][0]=0;
    data[0][1]=0;
    for(int i=1;i<=N;i++){
      cin >> data[i][0] >> data[i][1];
    }
    maxdis=0;
    maxpos=0;
    dfs(0,0);
    cout << "Case #" << tc << endl;
    cout << data[maxpos][0] << " " << data[maxpos][1] << endl;
  }
  return 0;
}
/*
2
2 6
1 0
1 1
5 8
3 8
12 1
3 4
3 7
1 1
2 2
4 4
5 4
6 5
7 8
1 9
*/
