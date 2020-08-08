// github.com/andy489

#include <iostream>
#include <vector>

using namespace std;

int min(int a, int b) {
    return a > b ? b : a;
}

int main() {
    int N, i(0), j;
    cin >> N;
    vector<int> walls(N);

    for (; i < N; ++i)
        cin >> walls[i];

    int maxWater(0);

    for (i = 0; i < N; ++i) {
        for (j = i + 1; j < N; ++j)
            if ((j - i) * min(walls[i], walls[j]) > maxWater)
                maxWater = (j - i) * min(walls[i], walls[j]);
    }
    return cout << maxWater, 0;
}
