// https://www.hackerrank.com/contests/daa-2020-2021-winter-test1/challenges/challenge-2871

#include <cstdio>
#include <algorithm>

using namespace std;

const int MXN = 1e5 + 5;
int N, K, hotels[MXN];

void init() {
    scanf("%d%d", &N, &K);
    
    for (int i = 0; i < N; ++i) {
        scanf("%d", hotels + i);
    }
    
    sort(hotels, hotels + N);
}

bool valid(int m) {
    int pos = hotels[0];
    int fans = 1;
    for (int i = 1; i < N; ++i) {
        if (hotels[i] - pos >= m) {
            pos = hotels[i];
            ++fans;
            
            if (fans == K) {
                return true;
            }
        }
    }
    
    return false;
}

int bin_search_on_ans(int ans = -1) {
    int l = hotels[0];
    int r = hotels[N - 1];
    int mid;
    
    while (l <= r) {
        mid = l + (r - l) / 2; // l + r overflows
        
        if (valid(mid)) {
            ans = max(ans, mid);
            l = mid + 1;
        } else {
            r = mid - 1;
        }
    }
    return ans;
}

int main() {
    init(); 
    
    printf("%d", bin_search_on_ans());
    
    return 0;
}
