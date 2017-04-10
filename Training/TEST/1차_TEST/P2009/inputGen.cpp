#include<cstdio>
#include<iostream>
#include<algorithm>
#include<cstdlib>
#include<ctime>

using namespace std;

int main(){
  srand((unsigned int) time (NULL));

  int T=100;
  cout << T << endl;
  for(int i=1;i<=T;i++){
    int N = rand()%(i*100)+1;
    cout << N << endl;
    for(int j=0;j<N-1;j++){
      cout << rand()%20000 - 10000 << " ";
    }
    cout << rand()%20000 - 10000 << endl;

  }

  return 0;
}
