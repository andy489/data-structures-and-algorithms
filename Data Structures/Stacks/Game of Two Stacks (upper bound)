// github.com/andy489

#include<iostream>
#include<algorithm>
using namespace std;
#define MAXNM 100000
long long a[MAXNM], b[MAXNM];

int main() {
    int g, n, m, x, i;
    cin >> g;

    while (g--) {
        cin >> n >> m >> x;

        for (i = 0;i < n;++i) {
            cin >> a[i];
            if (i)a[i] += a[i - 1];
        }
        for (i = 0; i < m;++i) {
            cin >> b[i];
            if (i)b[i] += b[i - 1];
        }

        int score = upper_bound(b, b + m, x)-b;
        
        for (i = 0;i < n;++i) {

            int r = upper_bound(b, b + m, x - a[i]) - b - 1;
            
            if (a[i] + b[r] <= x){
                score = max(score, i + r + 2);
            }
        }

        cout << score << '\n';
    }
    return 0;
}
/*
1
9 10 67
19 9 8 13 1 7 18 0 19
11 17 1 18 14 12 9 18 14 3
*/
