#include <cstdio>
#include <iostream>

using namespace std;

int main(){
  int T;

  cin >> T;
  for(int tc = 1;tc <= T; tc++){
    int N;
    int divider=100000000,c=9,count=0;
    cin >> N;

    while(divider>0){
      int x = N/divider;
      count+=x*(divider/10)*(c-1);
      if(x==3){
        count+=N%divider+1;
      } else if(x>3){
        count+=divider;
      }

      N=N%divider;
      divider/=10;
      c--;
    }
    cout << "Case #" << tc << endl;
    cout << count << endl;

  }
  return 0;
}
