#include<cstdio>
#include<iostream>
#include<algorithm>
#include<cstdlib>
#include<ctime>

using namespace std;

int main(){
  srand((unsigned int) time (NULL));

  int T=100,N,M;
  cout << T << endl;

  for(int i=0;i<T;i++){
      N=rand()%1000 + 1;
      M=rand()%10000 + 1;
      cout << N << " " << M << endl;
      for(int j=0;j<M;j++){
          cout << rand()%N+1 << " " << rand()%N+1 << endl;
      }
  }

  return 0;
}
