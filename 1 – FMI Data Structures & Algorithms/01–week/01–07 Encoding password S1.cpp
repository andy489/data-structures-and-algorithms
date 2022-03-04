// https://www.hackerrank.com/contests/practice-1-sda/challenges
// Encoding Password

#include <iostream>
#include <string>
#include <vector>

using namespace std;

void encode(const string &pass, vector<int> &reps, vector<char> &chars) {
    int SIZE = pass.size();

    reps.reserve(SIZE); // stock up to avoid frequent resize
    chars.reserve(SIZE); // stock up

    for (int i = 0; i < SIZE; i++) {
        int curr_count = 0;
        char curr = pass[i];
        
        for (int j = i; j < SIZE; ++j) {
            if (curr == pass[j]) {
                ++curr_count;
                
                if (j == SIZE - 1) {
                    reps.push_back(curr_count);
                    chars.push_back(curr);
                    
                    return; //reached end
                }
            } else {
                reps.push_back(curr_count);
                chars.push_back(curr);
                
                i += curr_count - 1; // update index
                break;
            }
        }
    }
}

int main() {
    string pass;
    cin >> pass;

    vector<int> reps;
    vector<char> chars;

    encode(pass, reps, chars);

    const int SIZE = chars.size();

    for (int i = 0; i < SIZE; ++i) {
        cout << reps[i] << chars[i];
    }

    return 0;
}
