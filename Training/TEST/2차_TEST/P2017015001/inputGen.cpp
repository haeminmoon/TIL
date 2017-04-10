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
    int W = (rand()%20)+1;
    int H = (rand()%20)+1;
    int M = (rand()%W*H)+1;
    cout << W << " " << H << " " << M << endl;
  }

  return 0;
}
/*
3 3
1 1
1 1
1 1
*/
