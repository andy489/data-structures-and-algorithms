// github.com/andy489

#include <iostream>
#include <deque> 
using namespace std;

void printKMax(int arr[], int n, int k){
    deque<int>d;
    int i;
    for(i=0;i<k;++i){
        while(!d.empty()&&arr[i]>=arr[d.back()]){
            d.pop_back();
        }
        d.push_back(i);
    }
    for(;i<n;++i){
        cout<<arr[d.front()]<<' ';
        while(!d.empty()&&d.front()<=i-k){
            d.pop_front();
        }
        while(!d.empty()&&arr[i]>=arr[d.back()]){
            d.pop_back();
        }
        d.push_back(i);
    }
    cout<<arr[d.front()]<<'\n';
}

int main(){
  
	int t;
	cin >> t;
	while(t>0) {
		int n,k;
    	cin >> n >> k;
    	int i;
    	int arr[n];
    	for(i=0;i<n;i++)
      		cin >> arr[i];
    	printKMax(arr, n, k);
    	t--;
  	}
  	return 0;
}
