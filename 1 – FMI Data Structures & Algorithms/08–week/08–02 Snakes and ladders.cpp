// https://www.hackerrank.com/challenges/the-quickest-way-up/problem

#include <iostream>
#include <vector>
#include <list>
#include <queue>
#include <sstream>

using namespace std;

const int BOARD = 100;   // board_adj size
const int DICE = 6;     // dice
const int FIN = 100;    // final

vector<list<int>> board_adj;

void init_adj_list() {
    for (int i = 1; i <= BOARD; ++i) {
        for (int j = 1; j <= DICE; ++j) {
            if (i + j <= BOARD) {
                board_adj[i].push_back(i + j);
            }
        }
    }
}

void put_ladders() {
    int ladders_cnt;
    cin >> ladders_cnt;

    int ls; // ladder start
    int le; // ladder end
    while (ladders_cnt--) {
        cin >> ls >> le;
        board_adj[ls].clear();

        for (int j = DICE; j >= 1; --j) {
            if (ls - j > 0) {
                board_adj[ls - j].push_back(le);
            }
        }
    }
}

void put_snakes() {
    int snakes_cnt;
    cin >> snakes_cnt;

    int head;
    int tail;

    while (snakes_cnt--) {
        cin >> head >> tail;
        board_adj[head].clear();

        for (int j = DICE; j >= 1; --j) {
            if (head - j > 0) {
                board_adj[head - j].push_back(tail);
            }
        }
    }
}

int bfs(int start) {
    int lvl = 0;

    queue<int> q;
    vector<bool> visited(BOARD + 1);

    q.push(start);
    visited[start] = true;

    int size = q.size();

    while (!q.empty()) {
        while (size--) {
            int curr = q.front();
            q.pop();

            for (int child:board_adj[curr]) {
                if (!visited[child]) {
                    if (child == FIN) {
                        return lvl + 1;
                    }
                    visited[child] = true;
                    q.push(child);
                }
            }
        }

        size = q.size();
        ++lvl;
    }
    return -1;
}

int main() {
    int tests;
    cin >> tests;

    ostringstream os;

    while (tests--) {
        board_adj.assign(BOARD + 1, list<int>());

        init_adj_list();
        put_ladders();
        put_snakes();

        os << bfs(1) << endl;
    }

    cout << os.str();

    return 0;
}