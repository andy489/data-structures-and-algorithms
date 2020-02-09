#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

vector<int> fill(int s) {
    vector<int>a(s+1);
    int i;
    for (i = 0;i < s; ++i) {
        cin >> a[i];
    }
    a[s]=0;
    return a;
}

void arrange(vector<int>& a) {
    int s = (int)a.size(), i;
    for (i = s - 1;i > 0;--i) {
        a[i - 1] += a[i];
    }    
    reverse(a.begin(),a.end());
}

bool equalTop(vector<int>& h1, vector<int>& h2, vector<int>& h3) {
    return h1.back() == h2.back() && h2.back() == h3.back();
}

int getMinTop(vector<int>& h1, vector<int>& h2, vector<int>& h3) {
    return min(h1.back(), min(h2.back(), h3.back()));
}

int main() {
    int s1, s2, s3;
    cin >> s1 >> s2 >> s3;
    vector<int> h1 = fill(s1), h2 = fill(s2), h3 = fill(s3);
    arrange(h1);    arrange(h2);    arrange(h3);
    while (!equalTop(h1, h2, h3)) {
        int min = getMinTop(h1, h2, h3);
        if (h1.back() > min) {
            h1.pop_back();
        }
        if (h2.back() > min) {
            h2.pop_back();
        }
        if (h3.back() > min) {
            h3.pop_back();
        }
    }
    cout << h1.back();
    return 0;
}

