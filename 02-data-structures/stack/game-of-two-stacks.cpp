// https://www.hackerrank.com/challenges/game-of-two-stacks/problem

#include <iostream>
#include <vector>

using namespace std;

int main() {
    int g;
    cin >> g;
    
    while (g--) {
        int n, m, x;
        cin >> n >> m >> x;

        vector<int> a(n), b(m);

        for (int i = 0; i < n; ++i) {
            cin >> a[i];
        }

        for (int i = 0; i < m; ++i) {
            cin >> b[i];
        }

        int sum = 0;
        int score;
        int i = 0;
        int j = 0;

        while (i < n && sum + a[i] <= x) {
            //considering only first stack and calculating count
            sum += a[i];
            ++i;
        }
        score = i;

        while (j < m) {
            /*now adding one element of second stack at a time 
            and subtracting the top element of first stack and calculating the count*/
            sum += b[j];
            j++;

            while (sum > x && i > 0) {
                --i;
                sum -= a[i];
            }

            if (sum <= x && i + j > score) {
                score = i + j;
            }
        }

        cout << score << endl;
    }
    
    return 0;
}