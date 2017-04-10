#include <cstdio>
#include <iostream>

using namespace std;

int main(){
  int T;

  cin >> T;
  for(int tc = 1;tc <= T; tc++){
    int A,B;
    cin >> A >> B;
    cout << "Case #" << tc << endl;
    cout << A+B << endl;
  }
  return 0;
}
