// https://www.hackerrank.com/contests/practice-8-sda/challenges/christmas-decoration/problem

#include <iostream>
#include <unordered_map>

using namespace std;

int main() {
    unordered_map<int, int> comps;

    int n, m;
    cin >> n >> m;

    comps.reserve(m);

    int curr_comp = 0;

    int from, to;
    while (m--) {
        cin >> from >> to;
        if (!comps.count(from) && !comps.count(to)) {
            --n;
            comps.insert({from, curr_comp});
            comps.insert({to, curr_comp});
            ++curr_comp;
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

            for (auto kvp: comps) {
                if (kvp.second == toComp) {
                    comps[kvp.first] = fromComp;
                }
            }
        }
    }

    cout << n;

    return 0;
}
