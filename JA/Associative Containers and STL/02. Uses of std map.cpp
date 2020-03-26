// github.com/andy489

#include<iostream>
#include<string>
#include<utility>
#include<map>

int main() {
    using namespace std;

    map<string, int> cityPopulations = {
        pair<string, int>{"Gabrovo", 58950},
        pair<string, int>{"Sofia", 1307376},
        pair<string, int>{"Melnik", 385},
    };

    cityPopulations["Sofia"]++;
    cityPopulations["Veliko Tarnovo"] = 72938;
    cityPopulations.insert(pair<string, int>("Pliska", 0));

    for (map<string, int>::iterator i = cityPopulations.begin(); i != cityPopulations.end(); i++) {
        cout << i->first << " " << i->second << endl;
    }

    cout << endl;

    // "Pliska" isn't really a city, it's an ancient settlement, let's remove it
    cityPopulations.erase("Pliska");

    for (pair<string, int> element : cityPopulations) {
        cout << element.first << " " << element.second << endl;
    }

    cout << endl;

    cout << "Enter a city name to see it's population:" << endl;
    string searchCityName;
    getline(cin, searchCityName);

    map<string, int>::iterator foundCity = cityPopulations.find(searchCityName);
    if (foundCity != cityPopulations.end()) {
        cout << foundCity->first << " " << foundCity->second << endl;
    } 
    else {
        cout << "No information about " << searchCityName << endl;
    }

    return 0;
}
