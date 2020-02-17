#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int main(){
	int n;
	cin>>n;
	vector<int>a(n);
	for (auto& x:a){
		cin>>x;
	}

	int q,y;
	cin >> q;

	while (q--){		
		cin>>y;
		auto it=lower_bound(a.begin(),a.end(),y);
		if(*it == y){
			cout<<"Yes ";
		}
		else{
			cout<<"No ";
		}
		cout<<(it-a.begin()+1)<<'\n';
	}
	return 0;
}
