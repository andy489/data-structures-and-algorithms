// https://www.hackerrank.com/contests/practice-7-sda/challenges/file-systems

#include <iostream>
#include <map>
#include <utility>

using namespace std;

struct Dir {
    string name;
    map<string, Dir> subdirs;
    Dir *parent;

    explicit Dir(const string& name, Dir *parent = nullptr) : name(move(name)), parent(parent) {}

    bool operator<(const Dir &d) const {
        return name < d.name;
    }

    ostream &pwd(ostream &os) const {
        if (!parent) {
            return os << '/';
        }

        parent->pwd(os);
        return os << name << '/';
    }
};

class File_System {
    Dir *state;
public:
    File_System() : state(new Dir("")) {}

    bool mkdir(const string &arg) {
        return state->subdirs.emplace(make_pair(arg, Dir(arg, state))).second;
    }

    bool chdir(const string &arg) {
        if (arg == "..") {
            if (!state->parent) {
                return false;
            }

            state = state->parent;
            return true;
        }

        auto it = state->subdirs.find(arg);

        if (it == state->subdirs.end()) {
            return false;
        }

        state = &it->second;
        return true;
    }

    ostream &pwd(ostream &os) const {
        return state->pwd(os);
    }

    ostream &ls(ostream &os) const {
        for (auto &x: state->subdirs) {
            os << x.first << ' ';
        }

        return os << endl;
    }

    ~File_System() {
        while (chdir(".."));
        delete state;
    }
};

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int n;
    cin >> n;

    string command, dir_name;
    File_System fs;

    while (n--) {
        cin >> command;

        if (command == "ls") {
            fs.ls(cout);
        } else if (command == "pwd") {
            fs.pwd(cout) << endl;
        } else {
            cin >> dir_name;
            if (command == "cd") {
                if (!fs.chdir(dir_name)) {
                    cout << "No such directory" << endl;
                }
            } else if (!fs.mkdir(dir_name)) {
                cout << "Directory already exists" << endl;
            }
        }
    }

    return 0;
}
