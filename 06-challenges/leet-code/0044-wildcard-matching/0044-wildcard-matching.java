// https://leetcode.com/problems/wildcard-matching/

// Solution: 2D DP — O(m·n) time, O(m·n) space
class Solution {
    public boolean isMatch(String s, String p) {
        int m = s.length(), n = p.length();
        boolean[][] dp = new boolean[m + 1][n + 1];
        dp[0][0] = true;
        for (int j = 1; j <= n; j++) {
            if (p.charAt(j - 1) == '*') {
                dp[0][j] = dp[0][j - 1];
            }
        }
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                char pc = p.charAt(j - 1);
                if (pc == s.charAt(i - 1) || pc == '?') {
                    dp[i][j] = dp[i - 1][j - 1];
                } else if (pc == '*') {
                    dp[i][j] = dp[i - 1][j] || dp[i][j - 1];
                }
            }
        }
        return dp[m][n];
    }
}

// Solution2: Greedy with backtracking — O(m·n) worst case, O(1) space
class Solution2 {
    public boolean isMatch(String s, String p) {
        int m = s.length(), n = p.length();
        int i = 0, j = 0, starJ = -1, matchI = 0;
        while (i < m) {
            if (j < n && (p.charAt(j) == s.charAt(i) || p.charAt(j) == '?')) {
                i++;
                j++;
            } else if (j < n && p.charAt(j) == '*') {
                starJ = j;
                matchI = i;
                j++;
            } else if (starJ != -1) {
                j = starJ + 1;
                matchI++;
                i = matchI;
            } else {
                return false;
            }
        }
        while (j < n && p.charAt(j) == '*') {
            j++;
        }
        return j == n;
    }
}

// Solution3: NFA simulation with OOP node hierarchy — O(m·n) time, O(n) space
//
// The pattern is compiled into an NFA: a list of Node objects, one per
// pattern character, plus a terminal AcceptNode at the end.
// Each node type knows its own matching rule and which nodes it can reach.
//
// Node types:
//   LiteralNode  — matches exactly one specific character
//   WildcardNode — matches exactly one arbitrary character ('?')
//   StarNode     — matches zero or more arbitrary characters ('*')
//   AcceptNode   — the goal; being here means the whole pattern matched
//
// Simulation:
//   activeNodes = set of nodes the NFA is currently "in" (may be many at once).
//   For each character of s: ask every active node to fire its read edges →
//   collect resulting nodes → follow epsilon edges (free jumps) → repeat.
//   After reading all of s: accept iff AcceptNode is in activeNodes.

abstract class Node {
    int id;           // position in the NFA (index into the nodes list)
    Node next;        // the node immediately after this one in the pattern

    // Fire this node on character c: add reachable nodes to the result set.
    // Returns true if this node itself should stay active (epsilon loop for '*').
    abstract void fire(char c, Set<Integer> result);

    // Epsilon edges: nodes reachable from here without consuming a character.
    // Default: none. StarNode overrides this to add next (star matches empty).
    void epsilonReach(Set<Integer> result) {}
}

class LiteralNode extends Node {
    private final char expected;
    LiteralNode(int id, char expected) { this.id = id; this.expected = expected; }

    @Override
    void fire(char c, Set<Integer> result) {
        if (c == expected) {
            result.add(next.id); // character matches: advance to next node
        }
    }
}

class WildcardNode extends Node {
    WildcardNode(int id) { this.id = id; }

    @Override
    void fire(char c, Set<Integer> result) {
        result.add(next.id); // '?' matches any character: always advance
    }
}

class StarNode extends Node {
    StarNode(int id) { this.id = id; }

    @Override
    void fire(char c, Set<Integer> result) {
        result.add(id);      // loop: '*' absorbs this character, stays on itself
        result.add(next.id); // or treat as empty and advance to next node
    }

    @Override
    void epsilonReach(Set<Integer> result) {
        result.add(next.id); // free jump: '*' can match nothing, advance for free
    }
}

class AcceptNode extends Node {
    AcceptNode(int id) { this.id = id; }

    @Override
    void fire(char c, Set<Integer> result) {
        // accept node has no outgoing edges; nothing to do
    }
}

class Nfa {
    private final Node[] nodes;

    Nfa(String pattern) {
        int n = pattern.length();
        nodes = new Node[n + 1];
        for (int i = 0; i < n; i++) {
            char pc = pattern.charAt(i);
            if (pc == '?') {
                nodes[i] = new WildcardNode(i);
            } else if (pc == '*') {
                nodes[i] = new StarNode(i);
            } else {
                nodes[i] = new LiteralNode(i, pc);
            }
        }
        nodes[n] = new AcceptNode(n);
        for (int i = 0; i < n; i++) {
            nodes[i].next = nodes[i + 1]; // wire each node to the one after it
        }
    }

    boolean matches(String s) {
        Set<Integer> activeNodes = new HashSet<>();
        activeNodes.add(0);
        followEpsilonEdges(activeNodes); // handle leading '*'s before we start

        for (int i = 0; i < s.length(); i++) {
            char sc = s.charAt(i);
            Set<Integer> nextActiveNodes = new HashSet<>();
            for (int id : activeNodes) {
                nodes[id].fire(sc, nextActiveNodes);
            }
            followEpsilonEdges(nextActiveNodes);
            activeNodes = nextActiveNodes;
        }

        return activeNodes.contains(nodes.length - 1); // AcceptNode reachable?
    }

    // Follow epsilon edges (free jumps) until no new nodes are discovered.
    // Only StarNode has epsilon edges (it can match the empty string).
    private void followEpsilonEdges(Set<Integer> activeNodes) {
        Queue<Integer> toExplore = new ArrayDeque<>(activeNodes);
        while (!toExplore.isEmpty()) {
            int id = toExplore.poll();
            Set<Integer> reached = new HashSet<>();
            nodes[id].epsilonReach(reached);
            for (int newId : reached) {
                if (activeNodes.add(newId)) {
                    toExplore.add(newId);
                }
            }
        }
    }
}

class Solution3 {
    public boolean isMatch(String s, String p) {
        return new Nfa(p).matches(s);
    }
}
