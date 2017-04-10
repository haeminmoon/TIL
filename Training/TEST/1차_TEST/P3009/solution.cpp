#include <string>
#include <algorithm>
#include <vector>
#include <iostream>

using namespace std;
int N,NN;
int map[110][110];
vector<int> vset[110];
int visit[110],upperbound;

void move(int x,int y,int dx,int dy){
  int count=0,x1,y1;
  x1=x+dx;
  y1=y+dy;
  while(0<=x1&&x1<N&&0<=y1&&y1<N){
    if(map[x1][y1]==-1) break;
    vset[x*N+y].push_back(x1*N+y1);
    x1+=dx;
    y1+=dy;
  }
}

void initVertexList(int x,int y){
  vset[x*N+y].push_back(x*N+y);
  move(x,y,1,1);
  move(x,y,1,-1);
  move(x,y,-1,1);
  move(x,y,-1,-1);
}

void findUpperBound(){
  upperbound=0;
  bool flag=true;
  while(flag){
    flag=false;
    int max=0,idx=0;
    for(int i=0;i<N;i++){
      for(int j=0;j<N;j++){
        if(map[i][j]==0&&visit[i*N+j]==0){
          if(vset[i*N+j].size()>max){
            max=vset[i*N+j].size();
            idx=i*N+j;
            flag=true;
          }
        }
      }
    }
    if(flag){
      upperbound++;
      for(int i=0;i<vset[idx].size();i++){
        visit[vset[idx][i]]=1;
      }
    }
  }
}

bool isCoverAll(){
  for(int i=0;i<NN;i++){
    if(map[i/N][i%N]==0&&visit[i]==0)
    return false;
  }
  return true;
}

void bt(int cnt,int idx){
  if(isCoverAll()){
    if(cnt<upperbound){
      upperbound=cnt;
    }
    return;
  }
  if(cnt==upperbound-1) return;
  for(int i=idx;i<NN;i++){
    if(vset[i].size()>0 && visit[i] == 0){
      for(int j=0;j<vset[i].size();j++){
        visit[vset[i][j]]++;
      }
      bt(cnt+1,i);
      for(int j=0;j<vset[i].size();j++){
        visit[vset[i][j]]--;
      }
    }
  }
}

int main(){
  int T;
  cin >> T;
  for(int tc = 1;tc <= T; tc++){
    cin >> N;
    NN = N*N;
    bool norock=true;
    for(int i=0;i<N;i++){
      char data[11];
      cin >> data;
      for(int j=0;j<N;j++){
        vset[i*N+j].clear();
        if(data[j]=='0') map[i][j]=0;
        else{
          map[i][j]=-1;
          norock=false;
        }
      }
    }

    for(int i=0;i<N;i++){
      for(int j=0;j<N;j++){
        if(map[i][j]==0){
          initVertexList(i,j);
        }
      }
    }

    fill(visit,visit+NN,0);
    findUpperBound();
    
    if(!norock){
      fill(visit,visit+NN,0);
      bt(0,0);
    }

    cout << "Case #" << tc << endl;
    cout << upperbound << endl;

  }
  return 0;
}
/*
2
2
00
00
5
#####
#0#0#
0###0
#0#0#
##0##

*/
