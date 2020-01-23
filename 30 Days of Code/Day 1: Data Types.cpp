#include <iostream>
#include <iomanip>
#include <limits>

using namespace std;

int main() {
    int i = 4;
    double d = 4.0;
    string s = "HackerRank ";
    int a;
    double b;
    string c;

    cin >> a;
    cin >> b;
    while(cin>>c) {
        s.append(c);
        s.append(" ");
    }   

    cout << (a + i) <<  '\n';
    cout << setprecision(1) << fixed << (b + d) << '\n';
    cout << s <<  '\n';
    return 0;
}
