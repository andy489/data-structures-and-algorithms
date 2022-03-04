#include <algorithm>
#include <vector>
#include <list>
#include <iostream>

using namespace std;

class Hash_Table {
private:
    const int START_SIZE = 10;

    vector<list<int>> table;
    int item_cnt = 0;

    static int hash(int value, int size) {
        return value % size;
    }

    [[nodiscard]] bool list_contains(int list, int value) const {
        return find(table[list].begin(), table[list].end(), value) != table[list].end();
    }

    [[nodiscard]] double calc_load_factor() const {
        return double(item_cnt) / table.size();
    }

    [[nodiscard]] bool is_growing_needed() const {
        double load_factor = calc_load_factor();
        return load_factor > 0.65;
    }

    void grow_hash_table() {
        vector<list<int>> new_table;
        new_table.resize(table.size() * 2);
        
        for (const auto& list : table) {
            for (auto element : list) {
                int listIndex = hash(element, new_table.size()); // recalculated hash
                new_table[listIndex].push_back(element);
            }
        }

        table = new_table;
    }

    [[nodiscard]] bool is_shrinking_needed() const {
        double load_factor = calc_load_factor();
        return load_factor < 0.3 && table.size() > 10;
    }

    void shrink_hash_table() {
        vector<list<int>> new_table;
        new_table.resize(table.size() / 2);
        
        for (const auto& list : table) {
            for (auto element : list) {
                int listIndex = hash(element, new_table.size()); // recalculated hash
                new_table[listIndex].push_back(element);
            }
        }

        table = new_table;
    }

public:
    Hash_Table() {
        table.resize(START_SIZE);
    }

    void insert(int value) {
        int list_index = hash(value, table.size()); // hash
        
        if (!list_contains(list_index, value)) {
            table[list_index].push_back(value);
            ++item_cnt;

            if (is_growing_needed()) {
                grow_hash_table();
            }
        }
    }

    [[nodiscard]] bool contains(int value) const {
        int list_index = hash(value, table.size()); // hash
        return list_contains(list_index, value);
    }

    void remove(int value) {
        int list_index = hash(value, table.size()); // hash
        int old_list_size = table[list_index].size();

        table[list_index].remove(value);

        if (table[list_index].size() != old_list_size) {
            --item_cnt;
        }

        if (is_shrinking_needed()) {
            shrink_hash_table();
        }
    }

    void print() const {
        for (const auto& list : table) {
            for (auto element : list) {
                cout << element << ", ";
            }
        }
        cout << endl;
    }
};

int main() {
    Hash_Table t;
    t.insert(1);
    t.insert(5);
    t.insert(12);
    t.insert(13);

    t.insert(15);
    t.remove(15);

    t.print();
}
