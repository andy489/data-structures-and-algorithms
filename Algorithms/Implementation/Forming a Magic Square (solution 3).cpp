// github.com/andy489

#include <iostream>
using namespace std;

int compute_diff(const int* a, const int* b) {
    int out = 0;
    for(int i = 0; i < 9; ++i) {
        out += abs(a[i] - b[i]);
    }
    return out;
}

void transpose(int* sq) {
    std::swap(sq[1], sq[3]);
    std::swap(sq[2], sq[6]);
    std::swap(sq[5], sq[7]);
}

void flip_horizontal(int* sq) {
    for(int i = 0; i < 3; ++i) {
        std::swap(sq[i], sq[6+i]);
    }
}

int main() {
    int input[9];
    for(int i = 0; i < 9; ++i) {
        cin >> input[i];
    }
    int ms[] = {4, 3, 8, 9, 5, 1, 2, 7, 6};
    int out = compute_diff(input, ms);
    
    for(int i = 0; i < 8; ++i) {
        if(i % 2 == 0) transpose(ms);
        else flip_horizontal(ms);
        int diff = compute_diff(input, ms);
        if(diff < out) out = diff;
    }    
    cout << out;
    
    return 0;
}
