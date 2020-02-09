#include <iostream>
#include <vector>
using namespace std;

int main(){
    int n, i, t;
    cin >> n;
    vector<int> aux(n);

    for (i = 0;i < n;++i){
        cin >> t;
        if (t != 0 && t != n){
            ++aux[(i+1)%n];
            --aux[(i - t + n+1) % n];
        }
    }

    int s(0),max_fin_stud(-n),min_indx(1);
    // we don't count 0's, so max_fin_stud could be negative
    for (i = 0;i < n+1;++i) {
        s += aux[i];
        if(s==n){ //optimization
            min_indx=i+1;
            break;
        }
        if (s > max_fin_stud) {
            max_fin_stud = s;
            min_indx = i + 1;
        }
    }

    cout << min_indx;

    return 0;
}
