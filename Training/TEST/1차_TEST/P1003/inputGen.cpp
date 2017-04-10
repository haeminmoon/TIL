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
    cout << (rand()%100)+1 << endl;
  }

  return 0;
}
