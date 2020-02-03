#include <bits/stdc++.h>
using namespace std;

vector<int>xd{-1,-1,-1,0, 1,1,1},
           yd{-1, 0, 1,0,-1,0,1};

int calc_hourglass(vector<vector<int>>& arr,int x, int y){
    int i;
    int curr_hourglass(0);
    for(i=0;i<7;++i){
        curr_hourglass+=arr[x+xd[i]][y+yd[i]];
    }
    return curr_hourglass;
}

int max_hourglass(vector<vector<int>>& arr){
    int temp_hourglass(0),max_hourglass(-9*7);
    int i,j;
    for(i=1;i<5;++i){
        for(j=1;j<5;++j){
            temp_hourglass=calc_hourglass(arr,i,j);
            max_hourglass=max(temp_hourglass,max_hourglass);            
        }
    }
    return max_hourglass;
}

int main()
{
    vector<vector<int>> arr(6);
    for (int i = 0; i < 6; i++) {
        arr[i].resize(6);

        for (int j = 0; j < 6; j++) {
            cin >> arr[i][j];
        }

        cin.ignore(numeric_limits<streamsize>::max(), '\n');
    }    
    cout<<max_hourglass(arr);

    return 0;
}
