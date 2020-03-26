// github.com/andy489

#include <bits/stdc++.h>
using namespace std;

vector<int>xd{0,0,0,-1,-2,-2,-2},
           yd{0,-1,-2,-1,0,-1,-2};

int calc_hourglass(vector<vector<int>>& arr,int x, int y){
    int i, curr_hourglass(0);
    for(i=0;i<7;++i){
        curr_hourglass+=arr[x+xd[i]][y+yd[i]];
    }
    return curr_hourglass;
}

int main(){
    vector<vector<int>> arr(6,vector<int>(6));
    int i,j,cur,maxHourGlass(-7*9);
    for (i = 0; i < 6; i++) {
        for (j = 0; j < 6; j++) {
            cin >> arr[i][j];
            if(i>1&&j>1){
                cur=calc_hourglass(arr,i,j);
                maxHourGlass=cur>maxHourGlass?cur:maxHourGlass;
            }
        }
    }    
    cout<<maxHourGlass;
    return 0;
}
