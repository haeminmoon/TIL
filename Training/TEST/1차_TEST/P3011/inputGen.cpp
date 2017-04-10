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
    int N = rand()%500+1;
    int K = rand()%(min(N,100))+1;
    cout << N << " " << K << endl;
  }

  return 0;
}
/*
3 3
1 1
1 1
1 1
*/
