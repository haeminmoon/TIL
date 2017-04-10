#include<cstdio>
#include<iostream>
#include<algorithm>
#include<cstdlib>
#include<ctime>

using namespace std;

int main(){
  srand((unsigned int) time (NULL));

  int T=100,N,M,K;
  cout << T << endl;

  for(int i=0;i<T;i++){
      N=rand()%200 + 1;
      K=rand()%1000 + 1;
      M=rand()%1000 + 1;
      cout << N << " " << K << " " << M << endl;
      for(int j=0;j<K;j++){
          cout << rand()%N+1 << " " << rand()%N+1 << endl;
      }
      cout << rand()%N+1;
      for(int j=1;j<M;j++){
          cout << " " << rand()%N+1;
      }
      cout << endl;
  }

  return 0;
}
