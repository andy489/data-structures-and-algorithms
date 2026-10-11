// https://www.hackerrank.com/contests/practice-6-sda/challenges/elitism

#include <cstdio>
#include <set>

using namespace std;

int main() {
    int n;
    scanf("%d", &n);

    multiset<int> r;
    multiset<int, greater<int> > l;

    int a;
    while (n--) {
        scanf("%d", &a);

        if (l.empty()) {
            l.insert(a);
        } else if (a > *l.begin()) {
            r.insert(a);
        } else {
            l.insert(a);
        }

        if (l.size() > r.size() + 1) {
            r.insert(*l.begin()), l.erase(l.begin());
        } else if (r.size() > l.size()) {
            l.insert(*r.begin()), r.erase(r.begin());
        }

        if (l.size() > r.size()) {
            printf("%d.0\n", *l.begin());
        } else {
            printf("%.1f\n", (*l.begin() + *r.begin()) / 2.0);
        }
    }

    return 0;
}
