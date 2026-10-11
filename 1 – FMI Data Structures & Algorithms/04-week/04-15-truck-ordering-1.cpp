// https://www.hackerrank.com/contests/practice-4-sda/challenges/truck-ordering/

#include <iostream>
#include <stack>

using namespace std;

bool fmiTrucks() {
    int n;
    cin >> n;

    stack<int> aux;
    stack<int> final;

    int truck;
    int cnt = 1;
    for (int i = 0; i < n; ++i) {
        cin >> truck;
        if (truck == cnt) {
            final.push(truck);
            ++cnt;
        } else {
            aux.push(truck);
        }
    }

    while (!aux.empty()) {
        if (aux.top() != cnt) {
            return false;
        } else {
            final.push(aux.top());
            aux.pop();
            ++cnt;
        }
    }
    
    return true;
}

int main() {
    int t;
    cin >> t;

    while (t--) {
        cout << (fmiTrucks() ? "yes" : "no") << endl;
    }

    return 0;
}
