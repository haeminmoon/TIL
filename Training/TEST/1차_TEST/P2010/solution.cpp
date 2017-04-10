#include <cstdio>
#include <iostream>
#include <algorithm>

using namespace std;

int main(){
  int T;

  cin >> T;
  for(int tc = 1;tc <= T; tc++){
    int N,K;
    int seq[102];
    bool use[102];

    cin >> N >> K;
    for(int i=0;i<K;i++){
      cin >> seq[i];
      use[i+1]=false;
    }

    int unplug=0;
    for(int i=0;i<K;i++){
      if(use[seq[i]]) continue;
      if(N<=0){
        int max=-1,target=-1;
        for(int j=1;j<=K;j++){
          if(use[j]){
            int curr=K;
            for(int k=i+1;k<K;k++){
              if(seq[k]==j){
                curr=k;
                break;
              }
            }
            if(max<curr){
              max=curr;
              target=j;
            }
            if(max==K){
              break;
            }
          }
        }
        use[target]=false;
        unplug++;
      }
      use[seq[i]]=true;
      N--;
    }

    cout << "Case #" << tc << endl;
    cout << unplug << endl;
  }
  return 0;
}
