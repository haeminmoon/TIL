/*
* 연아는 예쁜 케이크를 좋아해
*/
#include <cstdio>
#include <iostream>

#define MIN(X,Y) ((X) < (Y) ? (X) : (Y))  
#define MAX(X,Y) ((X) > (Y) ? (X) : (Y))  

using namespace std;

int table[21][21][401]={0,};

void process(){
    int w,h,m,min;
    for(int i=0;i<=20;i++){
        table[1][1][i]=1;
        for(int j=0;j<=20;j++){
            table[i][j][1]=i*j;     
        }
    }

    for(w=1;w<=20;w++){
        for(h=w;h<=20;h++){
            for(m=1;m<=400;m++){
                if(table[w][h][m]==0){
                    min=500;
                    for(int c=1;c<=w/2;c++){
						for(int l=1;l<m;l++){
							min=MIN(min,MAX(table[c][h][l],table[w-c][h][m-l]));
						}
                    }           
                    for(int c=1;c<=h/2;c++){
                        for(int l=1;l<m;l++){
							min=MIN(min,MAX(table[w][c][l],table[w][h-c][m-l]));							
						}
                    }           
                    table[w][h][m]=min;
                    table[h][w][m]=min;
                 }
            }
        }
    }     
}

int main(){
    int T,w,h,m;
    cin >> T;
    process();
    for(int tc = 1;tc <= T; tc++){
        cin >> w >> h >> m;
        cout << "Case #" << tc << endl;
        cout << table[w][h][m] << endl;
    }
 
}


 