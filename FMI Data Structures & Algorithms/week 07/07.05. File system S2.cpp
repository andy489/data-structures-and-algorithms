// github.com/andy489

// https://www.hackerrank.com/contests/practice-7-sda/challenges/file-systems

#include <iostream>
#include <map>

using namespace std;

struct Dir {
    string name;
    map<string, Dir> subdirs;
    Dir *parent;

    Dir(const string &name, Dir *parent = nullptr) : name(name), parent(parent) {}

    bool operator<(const Dir &d) const {
        return name < d.name;
    }

    ostream &pwd(ostream &os) const {
        if (!parent) return os << '/';
        parent->pwd(os);
        return os << name << '/';
    }
};

class FileSystem {
    Dir *state;
public:
    FileSystem() : state(new Dir("")) {}

    bool mkdir(const string &arg) {
        return state->subdirs.emplace(make_pair(arg, Dir(arg, state))).second;
    }

    bool chdir(const string &arg) {
        if (arg == "..") {
            if (!state->parent) return false;
            state = state->parent;
            return true;
        }
        auto it = state->subdirs.find(arg);
        if (it == state->subdirs.end()) return false;
        state = &it->second;
        return true;
    }

    ostream &pwd(ostream &os) const {
        return state->pwd(os);
    }

    ostream &ls(ostream &os) const {
        for (auto &x: state->subdirs)
            os << x.first << ' ';
        return os << '\n';
    }

    ~FileSystem() {
        while (chdir(".."));
        delete state;
    }
};

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int n; cin >> n;
    string command, dirName;
    FileSystem fs;
    while (n--) {
        cin >> command;
        if (command == "ls")
            fs.ls(cout);
        else if (command == "pwd")
            fs.pwd(cout) << '\n';
        else {
            cin >> dirName;
            if (command == "cd") {
                if (!fs.chdir(dirName))
                    cout << "No such directory\n";
            } else if (!fs.mkdir(dirName))
                cout << "Directory already exists\n";
        }
    }
}
