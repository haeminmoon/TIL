#include<cstdio>
#include<iostream>
#include<algorithm>
#include<cstdlib>
#include<ctime>

using namespace std;

int main(){
  srand((unsigned int) time (NULL));

  int T=20;
  cout << T << endl;
  for(int i=0;i<T;i++){
    int N = (i+1)*100;
    int K = (rand()%N)+1;
    cout << N << " " << K << endl;
    for(int j=0;j<N;j++){
      cout << rand()%100000+1 << " " << rand()%10 + 1 << endl;
    }
  }

  return 0;
}
/*
3 3
1 1
1 1
1 1
*/
