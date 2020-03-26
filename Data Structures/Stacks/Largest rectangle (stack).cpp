// github.com/andy489

#include <iostream>
#include <stack>
using namespace std;

int maxHistoArea(int* h, int n) {
    int max_area(0), i(0),t;

    stack<int> s;
     
    int curr_area; 

    while (i < n){        
        if (s.empty() || h[i]>=h[s.top()]) {
            s.push(i++);
        }
        else{
            t = s.top(), s.pop();  
            
            curr_area = h[t] * (s.empty() ? i :    i - s.top() - 1);
                        
            if (max_area < curr_area) {
                max_area = curr_area;
            }
        }
    }

    while (s.empty() == false)
    {
        t = s.top();
        s.pop();
        curr_area = h[t] * (s.empty() ? i :    i - s.top() - 1);

        if (max_area < curr_area) {
            max_area = curr_area;
        }
    }
    return max_area;
}

int main() {
    int n, i;
    cin >> n;
    int* h = new int[n];
    for (i = 0;i < n;++i) {
        cin >> h[i];
    }
    cout << maxHistoArea(h, n);
    delete[] h;
}
