#include <iostream>
#include <stack>
using namespace std;

void transfer(stack<int>& from, stack<int>& to){
    while (!from.empty()){
        to.push(from.top()), from.pop();
    }
}

int main(){
    stack<int> a, b;
    int q, type, x;
    cin >> q;
    while (q--){
        cin >> type;
        switch (type){
        case 1: //enqueue
            cin >> x;
            a.push(x);
            break;
        case 2: //dequeue
            if (!b.empty()){
                b.pop();
            }
            else{
                if (a.empty()){
                    cout << "no element to pop\n";
                }
                else{
                    transfer(a, b);
                }
                b.pop();
            }
            break;
        case 3: //front
            if (!b.empty()){
                cout << b.top() << '\n';
            }
            else{
                if (a.empty()){
                    cout << "no element to top\n";
                }
                else{
                    transfer(a, b);
                    cout << b.top() << '\n';
                }
            }
            break;
        }        
    }
    return 0;
}
