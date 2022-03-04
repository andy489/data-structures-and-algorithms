 #include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

void print_vec_of_vectors(vector<vector<int>> &a) {
    int N = a.size();

    if (N == 0) {
        cout << "No such combination" << endl;
    } else {
        for (const auto &v :a) {
            int M = v.size();
            if (M > 0) {
                cout << "(";
                for (int j = 0; j < M; ++j) {
                    if (j == M - 1) {
                        cout << v[j];
                    } else {
                        cout << v[j] << ", ";
                    }
                }
                cout << ")" << endl;
            }
        }
    }
}

void find_sum_comb(vector<int> &a, int sum, vector<vector<int>> &res, vector<int> &r, int i) {
    if (sum < 0) { // if current sum becomes negative
        return;
    }

    if (sum == 0) { // if we get the wanted sum
        res.push_back(r);
        return;
    }

    while (i < a.size() && sum - a[i] >= 0) {
        r.push_back(a[i]);

        find_sum_comb(a, sum - a[i], res, r, i); // without repetitions: i + 1, instead of i
        i++;

        r.pop_back(); // backtrack
    }
}

vector<vector<int>> combination_sum(vector<int> &a, int sum) {
    sort(a.begin(), a.end());

    // remove duplicates
    a.erase(unique(a.begin(), a.end()), a.end());

    vector<int> r;
    vector<vector<int> > res;
    find_sum_comb(a, sum, res, r, 0);

    return res;
}

int main() {
    vector<int> a = {4, 2, 6, 2, 8, 4};
    int X = 8;
    sort(a.begin(), a.end());

    a.erase(unique(a.begin(), a.end()), a.end());

    vector<vector<int>> res = combination_sum(a, X);
    print_vec_of_vectors(res);

    return 0;
}