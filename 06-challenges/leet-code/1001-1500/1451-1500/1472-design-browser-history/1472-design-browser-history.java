// https://leetcode.com/problems/design-browser-history/

// Solution: List + Pointer — O(1) per op time, O(n) space
class BrowserHistory {
    private List<String> hist = new ArrayList<>();
    private int curr = 0;
    public BrowserHistory(String homepage) { hist.add(homepage); }
    public void visit(String url) {
        while (hist.size() > curr + 1) hist.remove(hist.size()-1);
        hist.add(url); curr++;
    }
    public String back(int steps) { curr = Math.max(0, curr-steps); return hist.get(curr); }
    public String forward(int steps) { curr = Math.min(hist.size()-1, curr+steps); return hist.get(curr); }
}
