// https://www.hackerrank.com/challenges/bigger-is-greater/problem
// 1st solution (binary search)

#include <iostream>
#include <algorithm>

using namespace std;

int main() {
    int q, i;
    cin >> q;

    while (q--) {
        string word;
        cin >> word;

        int length = word.length();
        int index = -1;

        char curr = word[length - 1];

        for (i = length - 1; i > 0; --i) {
            if (word[i] > word[i - 1]) {
                index = i - 1;
                curr = word[index];
                break;
            }
        }

        if (index == -1) cout << "no answer"<< endl;
        else { // binary search to find the best swap
            int l = index + 1;
            int r = length - 1;
            int mid;
            int ans;

            while (l <= r) {
                mid = l + (r - l) / 2;

                if (word[mid] > curr) {
                    ans = mid;
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            }
            swap(word[index], word[ans]);
            reverse(word.begin() + index + 1, word.end());

            cout << word << endl;
        }
    }
}
