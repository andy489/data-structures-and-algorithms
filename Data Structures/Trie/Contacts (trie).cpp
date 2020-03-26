// github.com/andy489

#include <iostream>
#include <string>
#include <unordered_map>
using namespace std;

struct Node{
    int count;
    unordered_map<char,Node*>symbols;
    Node(int count):count(count){}
};

struct Trie{
    Node* root;
    Trie(){
        root=new Node(0);
    }

    void add(string name){
        Node* traverse=root;
        for (const char&c:name){
            if (traverse->symbols.count(c)){
                traverse->symbols[c]->count++;               
            }
            else{
                traverse->symbols[c]=new Node(1);
            }
            traverse=traverse->symbols[c];
        }
    }

    int find(string name){
        int count(0);
        Node* traverse=root;
        for(const char&c:name){
            if(traverse->symbols.count(c)){
                traverse=traverse->symbols[c];
            }
            else{
                return count;
            }
        }
        count=traverse->count;
        return count;
    }
};

int main(){
    Trie t;
    string operation,name;

    int q;
    cin>>q;
    
    while(q--){
        cin>>operation>>name;
        if(operation=="add"){
            t.add(name);
        }
        else{
            cout<<t.find(name)<<'\n';
        }
    }
    return 0;
}
