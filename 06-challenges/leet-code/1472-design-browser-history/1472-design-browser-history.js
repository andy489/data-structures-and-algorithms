// https://leetcode.com/problems/design-browser-history/

class BrowserHistory {
    constructor(homepage) { this.hist = [homepage]; this.curr = 0; }
    visit(url) { this.hist = this.hist.slice(0,this.curr+1); this.hist.push(url); this.curr++; }
    back(steps) { this.curr = Math.max(0,this.curr-steps); return this.hist[this.curr]; }
    forward(steps) { this.curr = Math.min(this.hist.length-1,this.curr+steps); return this.hist[this.curr]; }
}
