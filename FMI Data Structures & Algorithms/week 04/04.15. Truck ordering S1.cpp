// github.com/andy489

// https://www.hackerrank.com/contests/practice-4-sda/challenges/truck-ordering/

#include <iostream>
#include <vector>
#include <stack>

using namespace std;
typedef vector<int> vi;
#define F(i, k, n) for(int i=k;i<n;++i)

bool fmiTrucks() {
    int n, truck, cnt(1);
    cin >> n;

    stack<int> aux, final;


    F(i, 0, n) {
        cin >> truck;
        if (truck == cnt)
            final.push(truck),++cnt;
        else
            aux.push(truck);
    }

    while (!aux.empty()) {
        if (aux.top() != cnt)
            return false;
        else 
            final.push(aux.top()), aux.pop(),++cnt;
    }
    return true;
}

int main() {
    int T;
    cin >> T;
    F(i, 0, T) fmiTrucks() ? cout << "yes\n" : cout << "no\n";
    return 0;
}
