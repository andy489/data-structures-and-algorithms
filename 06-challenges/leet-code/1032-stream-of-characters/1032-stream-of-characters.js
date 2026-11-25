// https://leetcode.com/problems/stream-of-characters/

var StreamChecker = function(words) {
    this.trie = {};
    for (const w of words) {
        let node = this.trie;
        for (let i = w.length - 1; i >= 0; i--) {
            const c = w[i];
            if (!node[c]) node[c] = {};
            node = node[c];
        }
        node['#'] = true;
    }
    this.active = [];
};
StreamChecker.prototype.query = function(letter) {
    const nxt = [this.trie];
    let result = false;
    for (const node of [this.trie, ...this.active]) {
        if (node[letter]) {
            const child = node[letter];
            nxt.push(child);
            if (child['#']) result = true;
        }
    }
    this.active = nxt.slice(1);
    return result;
};
