// https://www.hackerrank.com/challenges/queue-using-two-stacks/problem

#include <stack>
#include <iostream>

using namespace std;

int main() {
    stack<int> front, rear;
    
    int q;
    cin >> q;
    while (q--) {
        int type, x;
        cin >> type;
        
        if (type == 1) {
            cin >> x;
            rear.push(x);
        } else {
            if (front.empty()) { // move all the elements from "rear" stack to "front" stack
                while (!rear.empty()) {
                    front.push(rear.top());
                    rear.pop();
                }
            }
            
            if (!front.empty()) {
                if (type == 2) {
                    front.pop();
                }
                
                if (type == 3) {
                    cout << front.top() << endl;
                }
            }
        }
    }
    
    return 0;
}
