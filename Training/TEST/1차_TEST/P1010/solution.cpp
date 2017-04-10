#include <cstdio>
#include <iostream>
#include <algorithm>
#include <vector>

using namespace std;

int main(){
  int T;

  cin >> T;
  for(int tc = 1;tc <= T; tc++){
    int N;
    cin >> N;
    vector<int> data;
    while(N!=0){
      data.push_back(N%10);
      N/=10;
    }
    sort(data.begin(),data.end(), greater<int>() );

    cout << "Case #" << tc << endl;
    vector<int>::iterator iter;
    for (iter = data.begin(); iter != data.end(); ++iter){
      cout << *iter;
    }
    cout << endl;
  }
  return 0;
}
