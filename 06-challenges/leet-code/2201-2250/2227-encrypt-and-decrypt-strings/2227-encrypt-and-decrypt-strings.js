// https://leetcode.com/problems/encrypt-and-decrypt-strings/
class Encrypter {
    constructor(keys, values, dictionary) {
        this.encryptMap = new Map();
        for (let i = 0; i < keys.length; i++) {
            this.encryptMap.set(keys[i], values[i]);
        }
        this.decryptCount = new Map();
        for (const word of dictionary) {
            const encrypted = this.encrypt(word);
            if (encrypted !== '') {
                this.decryptCount.set(encrypted, (this.decryptCount.get(encrypted) || 0) + 1);
            }
        }
    }

    encrypt(word1) {
        const parts = [];
        for (const c of word1) {
            if (!this.encryptMap.has(c)) {
                return '';
            }
            parts.push(this.encryptMap.get(c));
        }
        return parts.join('');
    }

    decrypt(word2) {
        return this.decryptCount.get(word2) || 0;
    }
}
