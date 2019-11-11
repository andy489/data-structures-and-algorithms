#include <iostream>  
#include <vector>
#include <stack>
using namespace std;
typedef vector<int> vi;
#define F(i,k,n) for(int i=k;i<n;++i)

bool fmiTrucks()
{
    int n, truck, count(1);
    cin >> n;

    stack<int> help, final;


    F(i, 0, n)
    {
        cin >> truck;
        if (truck == count)
        {
            final.push(truck);
            count++;
        }
        else
        {
            help.push(truck);
        }
    }

    while (!help.empty())
    {
        if (help.top() != count)
        {            
            return false;
        }
        else
        {
            final.push(help.top());
            help.pop();
            count++;
        }
    }
    return true;
}

int main()
{
    int T;
    cin >> T;
    F(i, 0, T)
    {
        fmiTrucks()?cout<<"yes\n":cout<<"no\n";
    }
    return 0;
}
