/*
* 너와 나의 연결 고리 이건 우리 안의 소리
*/
#include<cstdio>
#include<iostream>

using namespace std;
int friends[1001][2];

int find(int u){
    return ((friends[u][0]==u) ? u : find(friends[u][0]));
}

void merge(int u,int v){
    u = find(u);
    v = find(v);
    if (u == v) return;
    friends[u][0] = v;
    friends[v][1] += friends[u][1];
}

int main(){
    int N,M,A,B,T;

    cin >> T;

    for(int tc=1; tc<=T;tc++){
        cin >> N >> M;
        for(int i=1;i<=N;i++){
            friends[i][0]=i;
            friends[i][1]=1;
        }

        for(int i=0;i<M;i++){
            cin >> A >> B;
            merge(A,B);
        }
        int max=0;
        for(int i=1;i<=N;i++){ 
            max = (max>friends[i][1])?max:friends[i][1];
        }        
        cout << "Case #" << tc << endl;
        cout << max << endl;    
    }
    
   
    return 0;
}
/*
2
5 3
1 2
3 4
3 2
10 10
10 1
1 2
2 3
3 4
3 4
3 4
3 4
3 4
1 2
1 2
*/



 