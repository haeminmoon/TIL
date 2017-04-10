#include <cstdio>
#include <iostream>

using namespace std;
int map[20][20];
int check(int x,int y,int z){
  if(x!=y&&y!=z&&z!=x){
    if(x+y+z==6){
      return true;
    }
  }
  return false;
}
int count(int i,int j){
  int cnt=0;
  if(check(map[i][j],map[i+1][j],map[i-1][j])) cnt++;
  if(check(map[i][j],map[i][j+1],map[i][j-1])) cnt++;
  if(check(map[i][j],map[i+1][j],map[i][j+1])) cnt++;
  if(check(map[i][j],map[i+1][j],map[i][j-1])) cnt++;
  if(check(map[i][j],map[i-1][j],map[i][j+1])) cnt++;
  if(check(map[i][j],map[i-1][j],map[i][j-1])) cnt++;
  return cnt;
}

int main(){
  int T;

  cin >> T;
  for(int tc = 1;tc <= T; tc++){
    int N,cnt=0;
    char data[20];
    cin >> N;

    for(int i=0;i<20;i++)
      fill(map[i],map[i]+20,-100);

    for(int i=0;i<N;i++){
      cin >> data;
      for(int j=0;j<N;j++){
        map[i+2][j+2]=data[j]-'0';
      }
    }

    for(int i=0;i<N;i++){
      for(int j=0;j<N;j++){
        cnt+=count(i+2,j+2);
      }
    }
    cout << "Case #" << tc << endl;
    cout << cnt << endl;

  }
  return 0;
}

 
