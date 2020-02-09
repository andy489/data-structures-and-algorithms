#include <iostream>
#include <stack>
using namespace std;

int main() 
{
    int n,c,x;
    stack<int>s,max;
    cin>>n;
    while(n--)
    {   
        cin>>c;
        switch(c){
            case 1:
                cin>>x;
                if(max.empty()||x>=max.top()){
                    max.push(x);
                }                
                s.push(x);
            break;

            case 2:
                if(s.top()==max.top()){
                    max.pop();
                }
                s.pop();
            break;

            case 3:
                cout<<max.top()<<'\n';
            break;
        }  
    }
    return 0;
}
