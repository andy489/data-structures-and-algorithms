#include <iostream>
#include <map>
#include <stack>
#include <sstream>
using namespace std;
 
struct Dir {
    string name;
    Dir* parent;
    map<string, Dir*> dirs;
    Dir(string name = "root2019", Dir* parent = nullptr) :
        name(name), parent(parent) {}
};
 
class Ubunto20 {
    Dir* root,* curr;
    ostringstream ostr;
public:
    Ubunto20() {root=new Dir(); curr=root;}
    
    ostringstream& getOstr() {
        return this->ostr;
    }
    
    void mkdir(const string& DIR_NAME) {
        if (curr->dirs.count(DIR_NAME) != 0) {
            ostr << "Directory already exists\n";
        }
        else {
            curr->dirs[DIR_NAME] = new Dir(DIR_NAME, curr);
        }
    }
 
    void ls() {
        for (const auto& kvp : curr->dirs) {
            ostr << kvp.first << ' ';
        }
        ostr << '\n';
    }
 
    void pwd() {
        stack<string> S;
        Dir* traverse = curr;
        while (traverse != root) {
            S.push(traverse->name);
            traverse = traverse->parent;
        }ostr << '/';
        while (!S.empty()) {
            ostr << S.top();
            ostr << '/';
            S.pop();
        }
        ostr << '\n';
    }
 
    void cd(const string& DIR_NAME) {
        if (DIR_NAME == "..") {
            if (curr != root) {
                curr = curr->parent;
            }
            else {
                ostr << "No such directory\n";
            }
        }
        else {
            if (curr->dirs.find(DIR_NAME) != curr->dirs.end()) {
                curr = curr->dirs[DIR_NAME];
            }
            else {
                ostr << "No such directory\n";
            }
        }
    }
};
 
int main() { int n, i; cin>>n; 
    string command, dir_name;
    Ubunto20 U;
 
    for (i = 0;i < n;++i) {cin>>command;
        if (command == "mkdir") {
            cin >> dir_name;
            U.mkdir(dir_name);
        }
        else if (command == "cd") {cin>>dir_name;
            U.cd(dir_name);
        }
        else if (command == "ls") {
            U.ls();
        }
        else {
            U.pwd();
        }
    }
    cout << U.getOstr().str();
    return 0;
}
