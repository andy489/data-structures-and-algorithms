// https://leetcode.com/problems/design-twitter/

// Solution: HashMap + Max-Heap Merge — O(k log k) getNewsFeed, O(1) others, O(u·t) space
class Twitter {
    constructor() {
        this.time = 0;
        this.tweets = new Map();
        this.follows = new Map();
    }

    postTweet(userId, tweetId) {
        if (!this.tweets.has(userId)) this.tweets.set(userId, []);
        this.tweets.get(userId).push([this.time++, tweetId]);
    }

    getNewsFeed(userId) {
        const followees = new Set([...(this.follows.get(userId) || []), userId]);
        // Collect latest tweet per followee, sort by time desc, take top 10 via merge
        const candidates = [];
        for (const uid of followees) {
            const list = this.tweets.get(uid) || [];
            if (list.length) {
                candidates.push([uid, list.length - 1]);
            }
        }
        // Simple k-way merge using array sort (k is small <= 500)
        const result = [];
        while (candidates.length && result.length < 10) {
            candidates.sort((a, b) => {
                const ta = this.tweets.get(a[0])[a[1]][0];
                const tb = this.tweets.get(b[0])[b[1]][0];
                return tb - ta;
            });
            const [uid, idx] = candidates.shift();
            result.push(this.tweets.get(uid)[idx][1]);
            if (idx > 0) candidates.push([uid, idx - 1]);
        }
        return result;
    }

    follow(followerId, followeeId) {
        if (!this.follows.has(followerId)) this.follows.set(followerId, new Set());
        this.follows.get(followerId).add(followeeId);
    }

    unfollow(followerId, followeeId) {
        if (this.follows.has(followerId)) this.follows.get(followerId).delete(followeeId);
    }
}
