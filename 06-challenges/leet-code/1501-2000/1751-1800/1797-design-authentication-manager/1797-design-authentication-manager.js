// https://leetcode.com/problems/design-authentication-manager/

var AuthenticationManager = function(timeToLive) {
    this.ttl = timeToLive;
    this.expiry = new Map();
};

AuthenticationManager.prototype.generate = function(tokenId, currentTime) {
    this.expiry.set(tokenId, currentTime + this.ttl);
};

AuthenticationManager.prototype.renew = function(tokenId, currentTime) {
    if ((this.expiry.get(tokenId) || 0) > currentTime) {
        this.expiry.set(tokenId, currentTime + this.ttl);
    }
};

AuthenticationManager.prototype.countUnexpiredTokens = function(currentTime) {
    let count = 0;
    for (const exp of this.expiry.values()) {
        if (exp > currentTime) count++;
    }
    return count;
};
