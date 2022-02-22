// https://www.hackerrank.com/challenges/deque-stl/problem

#include <iostream>
#include <deque>

using namespace std;

void print_k_max(int *arr, int n, int k) {
    deque<int> D;
    
    for (int i = 0; i < k; ++i) {
        while (!D.empty() && arr[i] >= arr[D.back()]) {
            D.pop_back();
        }
        D.push_back(i);
    }
    
    for (int i = k; i < n; ++i) {
        cout << arr[D.front()] << ' ';
        
        while (!D.empty() && D.front() <= i - k) {
            D.pop_front();
        }
        
        while (!D.empty() && arr[i] >= arr[D.back()]) {
            D.pop_back();
        }
        
        D.push_back(i);
    }
    
    cout << arr[D.front()] << endl;
}

int main() {
    int t;
    cin >> t;
    
    while (t > 0) {
        int n, k;
        cin >> n >> k;
        
        int arr[n];
        
        for (int i = 0; i < n; ++i) {
            cin >> arr[i];
        }
        
        print_k_max(arr, n, k);
        t--;
    }
    
    return 0;
}