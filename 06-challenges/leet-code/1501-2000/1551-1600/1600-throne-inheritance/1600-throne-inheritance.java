// https://leetcode.com/problems/throne-inheritance/

// Solution: N-ary Tree with HashMap — O(n) per getInheritanceOrder, O(n) space
class ThroneInheritance {
    private final String king;
    private final Map<String, List<String>> children;
    private final Set<String> dead;

    public ThroneInheritance(String kingName) {
        this.king = kingName;
        this.children = new HashMap<>();
        this.dead = new HashSet<>();
    }

    public void birth(String parentName, String childName) {
        children.computeIfAbsent(parentName, k -> new ArrayList<>()).add(childName);
    }

    public void death(String name) {
        dead.add(name);
    }

    public List<String> getInheritanceOrder() {
        List<String> order = new ArrayList<>();
        dfs(king, order);
        return order;
    }

    private void dfs(String name, List<String> order) {
        if (!dead.contains(name)) {
            order.add(name);
        }
        for (String child : children.getOrDefault(name, Collections.emptyList())) {
            dfs(child, order);
        }
    }
}
