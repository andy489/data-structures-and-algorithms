#include <iostream>
using namespace std;

struct Date{
    int year;
    int month;
    int day;
};

int main() {
    Date returned, due;
    cin >> returned.day >> returned.month >> returned.year;
    cin >> due.day >> due.month >> due.year;
    
    if(returned.year <= due.year){
        if(returned.month <= due.month){
            if(returned.day <= due.day)
                cout << 0;
            else
                cout << (returned.day - due.day) * 15;
        }
        else
            cout << (returned.month - due.month) * 500;
    }
    else
        cout << 10000;
    
}
