// github.com/andy489

#include <iostream>
#include <sstream>
#include <unordered_map>

using namespace std;

vector<int> readLineOfNumbers(){
	vector<int> numbers;

	string line;
	getline(cin, line);

	istringstream lineIn(line);
	int currentNumber;
	while (lineIn >> currentNumber)
	{
		numbers.push_back(currentNumber);
	}

	return numbers;
}

int readSingleNumberOnLine(){
	return readLineOfNumbers()[0];
}

int toInteger(string s){
	istringstream sIn(s);
	int number;
	sIn >> number;
	return number;
}

int main(){
	typedef pair<double, double> Location;

	unordered_map<string, vector<Location > > personPositions;

	int numPositions;
	cin >> numPositions;

	for (size_t i = 0; i < numPositions; i++){
		string name;
		double lat, lon;
		cin >> name >> lat >> lon;

		personPositions[name].push_back({ lat, lon });
	}

	int numRequests;
	cin >> numRequests;
	for (size_t i = 0; i < numRequests; i++){
		string person;
		cin >> person;

		unordered_map<string, vector<pair<double, double> > >::iterator positionsIterator = personPositions.find(person);
		if (positionsIterator != personPositions.end()){
			vector<pair<double, double> > locations = positionsIterator->second;
			for (pair<double, double> loc : locations){
				cout << loc.first << " " << loc.second << endl;
			}
		}
		else{
			cout << "not found" << endl;
		}
	}

	return 0;
}
