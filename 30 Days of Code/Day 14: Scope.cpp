#include <cmath>
#include <cstdio>
#include <vector>
#include <iostream>
#include <algorithm>

using namespace std;

class Difference {
    private:
    vector<int> elements;
  
  	public:
  	int maximumDifference;

	// Add your code here
    Difference(vector<int>a){
        int n=(int)a.size(),i;
        elements.resize(n);
        for(i=0;i<n;++i){
            elements[i]=a[i];
        }
    }

    void computeDifference(){
        sort(elements.begin(),elements.end());
        int ans=elements[0]-elements[(int)elements.size()-1];
        maximumDifference=ans<0?-ans:ans;
    }
}; // End of Difference class

int main() {
    int N;
    cin >> N;
    
    vector<int> a;
    
    for (int i = 0; i < N; i++) {
        int e;
        cin >> e;
        
        a.push_back(e);
    }
    
    Difference d(a);
    
    d.computeDifference();
    
    cout << d.maximumDifference;
    
    return 0;
}
