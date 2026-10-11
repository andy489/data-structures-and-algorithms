// https://www.hackerrank.com/contests/daa-2020-2021-winter-test1/challenges/challenge-2593

#include<cstdio>
#include<algorithm>

using namespace std;

const int mxN = 1e6 + 9;

struct Person {
    char name[7];
    int fn, points;

    bool operator<(const Person &target) const {
        if (this->points == target.points)return this->fn < target.fn;
        return this->points < target.points;
    }
} arr[mxN];

int n, q;

void init() {
    scanf("%d %d", &n, &q);

    for (int i = 0; i < n; i++) {
        scanf("%s %d %d", &arr[i].name, &arr[i].fn, &arr[i].points);
    }

    sort(arr, arr + n);
}

void ansQ(int target) {
    int left = 0;
    int right = n - 1;
    int mid;
    int ans = -1;

    while (left <= right) {
        mid = left + (right - left) / 2;

        if (arr[mid].points < target) {
            left = mid + 1;
        } else {
            ans = mid;
            right = mid - 1;
        }
    }

    printf("%s %d\n", arr[ans].name, arr[ans].fn);
}

void readQs() {
    int val;

    for (int i = 0; i < q; i++) {
        scanf("%d", &val);
        ansQ(val);
    }
}

int main() {
    init();

    readQs();
}