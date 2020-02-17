#include <bits/stdc++.h>
using namespace std;

int consecutive_ones(int n){
    int max_count(0);
    int temp_count(0);
    while(n){
        if(n%2){
            ++temp_count;
            if(temp_count>max_count){
                max_count=temp_count;
            }
        }
        else{
            temp_count=0;            
        }
        n/=2;        
    }
    return max_count;
}

int main(){    
    int n;
    cin >> n;
    cin.ignore(numeric_limits<streamsize>::max(), '\n');
    cout<<consecutive_ones(n);
    return 0;
}
