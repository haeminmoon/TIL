#include <string>
#include <algorithm>
#include <vector>
#include <iostream>

using namespace std;

int main(){
  int T;

  cin >> T;

  for(int tc = 1;tc <= T; tc++){
    int N,min=0,max=0;
    vector<int> data;
    cin >> N;
    while(N!=0){
      data.push_back(N%10);
      N/=10;
    }
    sort(data.begin(),data.end());
    int len = data.size();
    for(int i=0;i<len;i++){
      min=min*10+data[i];
      max=max*10+data[len-i-1];
    }

    cout << "Case #" << tc << endl;
    cout << min+max << endl;
  }
  return 0;
}
