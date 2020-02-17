#include <cmath>
#include <cstdio>
#include <vector>
#include <iostream>
#include <algorithm>
#include <string>
using namespace std;
class AdvancedArithmetic{
    public:
        virtual int divisorSum(int n)=0;
};
class Calculator : public AdvancedArithmetic {
public:
    int divisorSum(int n) {
        int i, sum(0), s((int)sqrt(n));
        for (i = 2;i <= s;++i) {
            if (n % i == 0) {
                sum += i + n / i;
            }
        }        
        return n==1?1:sum+1+n+((s*s==n)?-s:0);
    }
};
int main(){
    int n;
    cin >> n;
    AdvancedArithmetic *myCalculator = new Calculator(); 
    int sum = myCalculator->divisorSum(n);
    cout << "I implemented: AdvancedArithmetic\n" << sum;
    return 0;
}
