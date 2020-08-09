// github.com/andy489

#include <iostream>
#include <vector>

using namespace std;
typedef vector<int> vi;

unsigned count_pairs(const vi &a, const vi &b, int sum) {
    unsigned answer(0);

    const int max = 1000000, min = 0, range = max - min;
    vi buffer_b(range, 0);

    for (const auto &el : b)
        ++buffer_b[el];

    for (const auto &el : a)
        if (sum - el >= 0 && buffer_b[sum - el] > 0)
            answer += buffer_b[sum - el];
    return answer;
}

int main() {
    int N, M, i(0), sum;
    cin >> N;
    vi a(N);
    for (; i < N; ++i)
        cin >> a[i];

    cin >> M;
    vi b(M);
    for (i = 0; i < M; ++i)
        cin >> b[i];

    cin >> sum;

    return cout << count_pairs(a, b, sum), 0;
}
