#include <cstdio>
#include <iostream>
#include <cstdlib> 
#include <cstring>
using namespace std;
struct circle{
  double r,v,p,t;

};

int main(){
  int T;

  cin >> T;
  for(int tc = 1;tc <= T; tc++){
    char data[101],compress[210];
    memset(&compress[0], 0, sizeof(compress));
    cin >> data;
    int len = strlen(data);
    int lenc = 0,c=1,idx=1;
    while(idx<len){
      if(data[idx-1]==data[idx]){
        c++;
      }else{
        compress[lenc++]=data[idx-1];
        compress[lenc++]='0'+c;

        c=1;
      }
      idx++;
    }
    compress[lenc++]=data[idx-1];
    compress[lenc++]='0'+c;
    cout << "Case #" << tc << endl;
    if(lenc>=len){
      cout << data << endl;
    }else{
      cout << compress << endl;
    }


  }
  return 0;
}
/*
3
gooooooood
hanwha
bbbbbbbnnnm
*/
