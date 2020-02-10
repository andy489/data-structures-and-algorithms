#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int main() {
    int N, M, a, b,overlapping(0);
    cin >> N >> M;

    vector<int> opening,closing;

    while (N--) {
        cin >> a >> b;
        opening.push_back(a);
        closing.push_back(b);
    } 

    sort(opening.begin(),opening.end());
    sort(closing.begin(),closing.end());

    while (M--) {
        cin >> a >> b;
        overlapping+=upper_bound(opening.begin(),opening.end(),b)-opening.begin();
        overlapping-=lower_bound(closing.begin(),closing.end(),a)-closing.begin();
    }
    cout << overlapping;
}

