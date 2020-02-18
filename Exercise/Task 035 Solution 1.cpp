#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;
#define N 3
#define M N*N

bool is_magic(vector<int>& v) {
    int i, j,magic_num(M*(M+1)/(2*N));
    int diag1(0), diag2(0);

    vector<vector<int>>m(N, vector<int>(N));
    for (i = 0;i < N;++i) {
        for (j = 0;j < N;++j) {
            m[i][j] = v[N * i + j];
        }
    }
    
    for (i = 0;i < N;++i) {
        int row(0),col(0);
        for (j = 0;j < N;++j) {            
            row += m[i][j];
            col += m[j][i];
        }        
        if (row != col || row != magic_num) {
            return false;
        }
        diag1 += m[i][i];
        diag2 += m[i][N - i - 1];
    }
    if (diag1 != diag2 || diag1 != magic_num) {
        return false;
    }
    return true;
}

void gen_all_magic_squares(vector<vector<int>>&magic_squares) {
    vector<int>v(M);
    int i;
    for (i = 0;i <M; ++i) {
        v[i] = i + 1;
    }
    do {
        if (is_magic(v)) {
            magic_squares.push_back(v);
        }
    } while (next_permutation(v.begin(), v.end()));
}

int diff(const vector<int>& x,const vector<int>y) {
    int i,res(0);
    for (i = 0;i < M;++i) {
        res += abs(x[i] - y[i]);
    }
    return res;
}

int get_min_diff(const vector<int>& v, const vector<vector<int>>& ms) {
    int i,min_diff(100),size(ms.size());
    for (i = 0;i < size;++i) {
        min_diff = min(min_diff, diff(v, ms[i]));
    }
    return min_diff;
}

int main() {    
    vector<vector<int>> magic_squares;
    gen_all_magic_squares(magic_squares);

    int q = 1,i;
    while (q--) {
        vector<int>input(M);
        for (i = 0;i < M;++i) {
            cin >> input[i];
        }
        cout<<get_min_diff(input, magic_squares);
    }
    return 0;
}
