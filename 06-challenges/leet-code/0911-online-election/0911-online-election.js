// https://leetcode.com/problems/online-election/

var TopVotedCandidate = function(persons, times) {
    this.times = times;
    const n = persons.length;
    this.leaders = new Array(n);
    const votes = new Array(n).fill(0);
    let lead = -1;
    for (let i = 0; i < n; i++) {
        votes[persons[i]]++;
        if (lead === -1 || votes[persons[i]] >= votes[lead]) {
            lead = persons[i];
        }
        this.leaders[i] = lead;
    }
};

TopVotedCandidate.prototype.q = function(t) {
    let lo = 0, hi = this.times.length - 1;
    while (lo < hi) {
        const mid = (lo + hi + 1) >> 1;
        if (this.times[mid] <= t) lo = mid;
        else hi = mid - 1;
    }
    return this.leaders[lo];
};
