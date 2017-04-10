#include <string>
#include <algorithm>
#include <vector>
#include <iostream>

using namespace std;

int main(){
  int T;
  cin >> T;

  for(int tc = 1;tc <= T; tc++){
    cout << "Case #" << tc << endl;

    int N,x;
    vector<int> a,b;
    cin >> N;
    for(int i=0;i<N;i++){
      cin >> x;
      a.push_back(x);
      b.push_back(x);
    }

    sort(b.begin(),b.end());
    
    for(int i=0;i<N;i++){
      if(a[i]!=b[i]){
        cout << i << " ";
        break;
      }
    }
    for(int i=N-1;i>0;i--){
      if(a[i]!=b[i]){
        cout << i <<endl;
        break;
      }
    }

  }
  return 0;
}
