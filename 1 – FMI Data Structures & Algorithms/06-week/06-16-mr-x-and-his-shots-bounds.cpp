// https://www.hackerrank.com/challenges/x-and-his-shots/problem

#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int main() {
    int n, m;
    cin >> n >> m;

    vector<int> opening, closing;

    int a, b;
    while (n--) {
        cin >> a >> b;
        
        opening.push_back(a);
        closing.push_back(b);
    }

    sort(opening.begin(), opening.end());
    sort(closing.begin(), closing.end());

    int overlapping = 0;
    
    while (m--) {
        cin >> a >> b;
        
        overlapping += upper_bound(opening.begin(), opening.end(), b) - opening.begin();
        overlapping -= lower_bound(closing.begin(), closing.end(), a) - closing.begin();
    }

    cout << overlapping;
}
