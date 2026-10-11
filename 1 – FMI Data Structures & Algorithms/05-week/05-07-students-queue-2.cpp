// https://www.hackerrank.com/contests/practice-5-sda/challenges/challenge-2231

#include <iostream>
#include <queue>
#include <vector>

using namespace std;

struct Student {
    int group, start;
    char name[30];
};

int main() {
    int n, m;
    cin >> n >> m;

    auto *groups = new queue<Student>[m + 1];

    queue<int> line;

    for (int i = 0; i < n || !line.empty(); ++i) {
        if (i < n) {
            Student next{};
            cin >> next.name >> next.group;
            next.start = i;

            if (groups[next.group].empty()) {
                line.push(next.group);
            }

            groups[next.group].push(next);
        }
        if ((i & 1) == 0 && i > 1) {
            cout << groups[line.front()].front().name << ' '
                 << groups[line.front()].front().start << ' '
                 << i << endl;

            groups[line.front()].pop();

            if (groups[line.front()].empty()) {
                line.pop();
            }
        }
    }
}