// github.com/andy489

#include <iostream>
#include <queue>
using namespace std;

int main(){
    queue<int> a;
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
            a.pop();
            break;
        case 3: //front
            cout<<a.front()<<'\n';
            break;
        }        
    }
    return 0;
}
