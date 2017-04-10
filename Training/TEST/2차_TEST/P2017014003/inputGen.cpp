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
  for(int i=0;i<T;i++){
    int N = (rand()%50)+1;
    int K = (rand()%50)+51;
    cout << N << " " << K << endl;
    for(int j=0;j<K-1;j++){
      cout << rand()%K+1 << " ";
    }
    cout << rand()%K+1 <<endl;
  }

  return 0;
}
/*
3 3
1 1
1 1
1 1
*/
