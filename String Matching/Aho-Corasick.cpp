#include <bits/stdc++.h>

using namespace std;

static const int MAX_SYMBOLS = 256;
static const int MAX_SIZE = 100001;

struct automation_node {
    bool is_word;
    char letter;
    automation_node* par;
    automation_node* link;
    automation_node* child[MAX_SYMBOLS + 1];

    automation_node() {
        is_word = false;
        link = nullptr;
        letter = ' ';
        for (int i = 0; i < MAX_SYMBOLS; i++) {
            child[i] = nullptr;
        }
    }
};

automation_node* root;
automation_node memoryHolder[MAX_SIZE];
int memCnt;

void add_word(string word) {
    automation_node* node = root;                              
    for (char letter : word) {         
        if (node->child[letter] == nullptr) {
            node->child[letter] = &memoryHolder[memCnt++];
            node->child[letter]->par = node;
            node->child[letter]->letter = letter;
        }
        node = node->child[letter];               
    }
    node->is_word = true;                        
}

void put_links() {
    root->link = root;
    root->par = root;
    
    queue<automation_node*> q;     
    q.push(root);

    while (q.empty() == false) {
        automation_node* node = q.front();
        q.pop();

        for (int i = 0; i < MAX_SYMBOLS; i++) {
            if (node->child[i] != nullptr) {
                q.push(node->child[i]);
            }
        }

        automation_node* linkTo = node->par->link;

        while (linkTo->child[node->letter] == nullptr && linkTo != root) {
            linkTo = linkTo->link;
        }

        node->link = linkTo->child[node->letter];

        if (node->link == nullptr || node->link == node) {
            node->link = root;
        }
    }
}

void check_text(string text) {
    automation_node* node = root;                      
    for (int i = 0; i < text.size(); i++) { 
        automation_node* n = node;

        while (n->child[text[i]] == nullptr && n != root) {
            n = n->link;
        }

        if (n == root) {            
            n = n->child[text[i]];

            if (n == nullptr) {
                n = root;
            }
        } else {
            n = n->child[text[i]];
        }

        automation_node* n1 = n;  

        while (n1 != root) {     
            if (n1->is_word) { 
                cout << "Word ending at index: " << i << endl;
            }

            n1 = n1->link;
        }

        node = n;
    }
}

bool find_word(string word) {
    automation_node* node = root; 
    for (char letter : word) {
        if (node->child[letter] == nullptr) {
            return false;
        }
        node = node->child[letter];
    }
    return node->is_word;
}

void build() {
    root = new automation_node();

    int n;
    cin >> n;
    for (int i = 0; i < n; i++) {
        string word;
        cin >> word;
        add_word(word);
    }
    put_links();
}

void solve() {
    string text;
    cin >> text;
    check_text(text);
}

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(nullptr);
    cout.tie(nullptr);

    build();
    solve();

    return 0;
}
