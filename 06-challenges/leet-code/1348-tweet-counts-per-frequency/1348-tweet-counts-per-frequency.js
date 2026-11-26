// https://leetcode.com/problems/tweet-counts-per-frequency/

class TweetCounts {
    constructor() { this.tweets = new Map(); }
    recordTweet(tweetName, time) {
        if (!this.tweets.has(tweetName)) this.tweets.set(tweetName, []);
        this.tweets.get(tweetName).push(time);
    }
    getTweetCountsPerFrequency(freq, tweetName, startTime, endTime) {
        const delta = freq==='minute'?60:freq==='hour'?3600:86400;
        const buckets = Math.floor((endTime-startTime)/delta)+1;
        const res = new Array(buckets).fill(0);
        const times = this.tweets.get(tweetName)||[];
        for (const t of times) {
            if(t>=startTime&&t<=endTime) res[Math.floor((t-startTime)/delta)]++;
        }
        return res;
    }
}
