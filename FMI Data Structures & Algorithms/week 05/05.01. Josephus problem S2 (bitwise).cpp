// github.com/andy489

#include <iostream>

using namespace std;

// function to find the position of the Most Significant Bit
int msbPos(long N) {
    int pos = 0;
    while (N) {
        ++pos;
        // keeps shifting bits to the right until we are left with 0
        N = N >> 1;
    }
    return pos;
}

// function to return at which place Josephus should sit to avoid being killed
int josephify(long N) {
    /* Getting the position of the Most Significant
    Bit(MSB). The leftmost '1'. If the number is
    '41' then its binary is '101001'.
    So msbPos(41) = 6 */
    long position = msbPos(N);

    /* 'j' stores the number with which to XOR the
    number 'n'. Since we need '100000'
    We will do 1<<6-1 to get '100000' */
    long j = 1 << (position - 1);

    /* Toggling the Most Significant Bit. Changing
    the leftmost '1' to '0'.
    101001 ^ 100000 = 001001 (9) */
    N = N ^ j;

    /* Left-shifting once to add an extra '0' to
    the right end of the binary number
    001001 = 010010 (18) */
    N = N << 1;

    /* Toggling the '0' at the end to '1' which
    is essentially the same as putting the
    MSB at the rightmost place. 010010 | 1
    = 010011 (19) */
    N = N | 1;

    return N;
}

int main() {
    long N;
    cin >> N;
    return cout << josephify(N), 0;
}
// See also https://en.wikipedia.org/wiki/Josephus_problem
