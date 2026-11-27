// https://leetcode.com/problems/find-all-possible-recipes-from-given-supplies/
class Solution {
    public List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {
        Map<String, Integer> recipeIndex = new HashMap<>();
        for (int i = 0; i < recipes.length; i++) {
            recipeIndex.put(recipes[i], i);
        }

        Set<String> available = new HashSet<>(Arrays.asList(supplies));
        int[] inDegree = new int[recipes.length];
        Map<String, List<Integer>> graph = new HashMap<>();

        for (int i = 0; i < recipes.length; i++) {
            for (String ing : ingredients.get(i)) {
                if (!available.contains(ing)) {
                    if (recipeIndex.containsKey(ing)) {
                        graph.computeIfAbsent(ing, k -> new ArrayList<>()).add(i);
                        inDegree[i]++;
                    } else {
                        inDegree[i] = Integer.MAX_VALUE;
                        break;
                    }
                }
            }
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < recipes.length; i++) {
            if (inDegree[i] == 0) {
                queue.offer(i);
            }
        }

        List<String> result = new ArrayList<>();
        while (!queue.isEmpty()) {
            int idx = queue.poll();
            result.add(recipes[idx]);
            if (graph.containsKey(recipes[idx])) {
                for (int next : graph.get(recipes[idx])) {
                    if (--inDegree[next] == 0) {
                        queue.offer(next);
                    }
                }
            }
        }
        return result;
    }
}
