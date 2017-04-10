/*
* 너와 나의 연결 고리 이건 우리 안의 소리
*/
#include<cstdio>
#include<iostream>

using namespace std;
int city[1001][2];

int find(int u){
    return ((city[u][0]==u) ? u : find(city[u][0]));
}

void merge(int u,int v){
    u = find(u);
    v = find(v);
    if (u == v) return;
    city[u][0] = v;
    city[v][1] += city[u][1];
}

int main(){
    int N,K,M,A,B,T;
    bool flag;
    cin >> T;

    for(int tc=1; tc<=T;tc++){
        cin >> N >> K >> M;
        for(int i=1;i<=N;i++){
            city[i][0]=i;
            city[i][1]=1;
        }

        for(int i=0;i<K;i++){
            cin >> A >> B;
            merge(A,B);
        }
        flag=true;
        cin >> A;
        for(int i=1;i<M;i++){ 
            cin >> B;
            if(find(A)!=find(B)) flag=false;
            B=A;
        }        
        cout << "Case #" << tc << endl;
        cout << (flag ? "YES":"NO") << endl;    
    }
    
   
    return 0;
}
/*
2
5 5 5
1 2
2 3
1 4
2 4
5 1
5 3 2 3 4
5 3 5
1 2
2 3
4 5
1 2 5 4 1


*/



 