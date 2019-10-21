#include<iostream>
#include<string>
#include<utility>

int main() 
{
    using namespace std;

    pair<string, string> contact("George", "not-telling-you@gmail.com");

    cout << contact.first << ", email: " << contact.second << endl;

    contact.first = "George Georgiev";
    contact.second = "still-not-telling-you@gmail.com";

    cout << contact.first << ", email: " << contact.second << endl;

    cout << endl;

    // Remember that () and {} can both be used to initialize objects (since C++11):
    pair<string, pair<double, double> > location
    {
        "Great Pyramid of Gyza",
        pair<double,double>{29.9792345, 31.1342019} 
	// NOTE: pair<double,double> here is redundant - C++11 can infer that, you can leave just the numbers in the {} brackets
    };

    cout << location.first
        << " GPS coords: "
        << location.second.first << "," << location.second.second << endl;

    cout << endl;

    pair<int, string> integerName(42, "forty-two");
    integerName.second = "Answer to the Ultimate Question of Life, the Universe, and Everything";

    cout << integerName.first << " is " << integerName.second << endl;

    return 0;
}
