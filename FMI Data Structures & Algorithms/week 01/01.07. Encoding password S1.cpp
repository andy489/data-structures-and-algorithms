// github.com/andy489

include <iostream>
#include <string>
#include <vector>

using namespace std;

void encode(const string &pass, vector<int> &reps, vector<char> &syms) {
    int SIZE = pass.size(), i(0), j;
    reps.reserve(SIZE); // stock up to avoid frequent resize
    syms.reserve(SIZE); // stock up
    for (; i < SIZE; i++) {
        int currCount(0);
        char curr = pass[i];
        for (j = i; j < SIZE; j++) {
            if (curr == pass[j]) {
                currCount++;
                if (j == SIZE - 1) {
                    reps.push_back(currCount);
                    syms.push_back(curr);
                    return; //reached end
                }
            } else {
                reps.push_back(currCount);
                syms.push_back(curr);
                i += currCount - 1; // update index
                break;
            }
        }
    }
}

int main() {
    string pass;
    cin >> pass;

    vector<int> reps;
    vector<char> syms;
    encode(pass, reps, syms);

    int SIZE = syms.size(), i(0);
    for (; i < SIZE; ++i)
        cout << reps[i] << syms[i];
    return 0;
}
