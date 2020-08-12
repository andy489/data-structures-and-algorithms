// github.com/andy489

// https://www.hackerrank.com/contests/practice-8-sda/challenges/challenge-2303

#include <cstdio>
#include<unordered_map>

using namespace std;

int main() {
    unordered_map<int, int> comps;
    int n, m;
    scanf("%d%d", &n, &m);
    comps.reserve(m);
    int from, to;
    int currComp(0);
    while (m--) {
        scanf("%d%d", &from, &to);
        if (!comps.count(from) && !comps.count(to)) {
            --n;
            comps.insert({from, currComp});
            comps.insert({to, currComp});
            ++currComp;
        } else if (!comps.count(from)) {
            --n;
            comps.insert({from, comps[to]});
        } else if (!comps.count(to)) {
            --n;
            comps.insert({to, comps[from]});
        } else if (comps[to] != comps[from]) {
            --n;
            int toComp = comps[to];
            int fromComp = comps[from];
            for (auto kvp: comps)
                if (kvp.second == toComp)
                    comps[kvp.first] = fromComp;
        }
    }
    return printf("%d", n), 0;
}
