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
    int N = (rand()%i*10)+1;
    cout << N << endl;
    for(int j=0;j<N;j++){
      cout << rand()%200000000+1 << " " << rand()%200000000+1 << " " << rand()%200000000+1 <<endl;;
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
