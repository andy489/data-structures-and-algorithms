// github.com/andy489

#include <algorithm>
#include <vector>
#include <list>
#include <iostream>
using namespace std;

class Hashtable {
private:
	const int START_SIZE = 10;

	vector<list<int>> table;
	int itemCount = 0;

	int hash(int value, int size) const {
		return value % size;
	}

	bool listContains(int list, int value) const {
		return find(table[list].begin(), table[list].end(), value) != table[list].end();
	}

	double calculateLoadFactor() const {
		return double(itemCount) / table.size();
	}

	bool isGrowingNeeded() const {
		double loadFactor = calculateLoadFactor();
		return loadFactor > 0.65;
	}

	void growHashtable() {
		vector<list<int>> newTable;
		newTable.resize(table.size() * 2);
		for (auto list : table) {
			for (auto element : list) {
				int listIndex = hash(element, newTable.size()); // recalculated hash
				newTable[listIndex].push_back(element);
			}
		}

		table = newTable;
	}

	bool isShrinkingNeeded() const {
		double loadFactor = calculateLoadFactor();
		return loadFactor < 0.3 && table.size() > 10;
	}

	void shrinkHashtable() {
		vector<list<int>> newTable;
		newTable.resize(table.size() / 2);
		for (auto list : table) {
			for (auto element : list) {
				int listIndex = hash(element, newTable.size()); // recalculated hash
				newTable[listIndex].push_back(element);
			}
		}

		table = newTable;
	}

public:
	Hashtable() {
		table.resize(START_SIZE);
	}

	void insert(int value) {
		int listIndex = hash(value, table.size()); // hash
		if (!listContains(listIndex, value)) {
			table[listIndex].push_back(value);
			itemCount++;

			if (isGrowingNeeded()) {
				growHashtable();
			}
		}
	}

	bool contains(int value) const {
		int listIndex = hash(value, table.size()); // hash
		return listContains(listIndex, value);
	}

	void remove(int value) {
		int listIndex = hash(value, table.size()); // hash
		int oldListSize = table[listIndex].size();
		
		table[listIndex].remove(value);

		if (table[listIndex].size() != oldListSize) {
			itemCount--;
		}

		if (isShrinkingNeeded()) {
			shrinkHashtable();
		}
	}

	void print() const {
		for (auto list : table) {
			for (auto element : list) {
				cout << element << ", ";
			}
		}
		cout << "\n";
	}
};

int main() {
	Hashtable t;
	t.insert(1);
	t.insert(5);
	t.insert(12);
	t.insert(13);
	
	t.insert(15);
	t.remove(15);
	
	t.print();
}
