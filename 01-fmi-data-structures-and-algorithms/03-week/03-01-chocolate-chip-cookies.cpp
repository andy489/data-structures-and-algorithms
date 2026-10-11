// https://www.hackerrank.com/contests/practice-3-1/challenges
// FMI cake

#include <iostream>
#include <vector>

using namespace std;

int get_min_days_rec(int sections) {
    if (sections < 1) {
        return 0;
    }
    
    return get_min_days_rec(sections / 2) + 1;
}

int get_mid_days_iter(int sections) {
    int result = 0;
    
    while (sections > 0) {
        ++result;
        sections /= 2;
    }
    
    return result;
}

void print_result(vector<int> &res) {
    for (int r: res) {
        cout << r << endl;
    }
}

int main() {
    int t;
    cin >> t;

    vector<int> res(t);

    int n;
    for (int i = 0; i < t; ++i) {
        cin >> n;
        res[i] = get_min_days_rec(n);
    }

    print_result(res);

    return 0;
}
