// https://leetcode.com/problems/basic-calculator-iv/

// Solution: Polynomial Arithmetic with Recursive Parser — O(n·2^n) time, O(2^n) space
class Solution {
    private Map<String, Integer> evalMap;

    public List<String> basicCalculatorIV(String expression, String[] evalvars, int[] evalints) {
        evalMap = new HashMap<>();
        for (int i = 0; i < evalvars.length; i++) {
            evalMap.put(evalvars[i], evalints[i]);
        }
        Map<List<String>, Integer> poly = parse(new ArrayDeque<>(Arrays.asList(expression.split(" "))));
        List<Map.Entry<List<String>, Integer>> terms = new ArrayList<>(poly.entrySet());
        terms.removeIf(e -> e.getValue() == 0);
        terms.sort((a, b) -> {
            if (a.getKey().size() != b.getKey().size()) return b.getKey().size() - a.getKey().size();
            for (int i = 0; i < a.getKey().size(); i++) {
                int cmp = a.getKey().get(i).compareTo(b.getKey().get(i));
                if (cmp != 0) return cmp;
            }
            return 0;
        });
        List<String> result = new ArrayList<>();
        for (Map.Entry<List<String>, Integer> e : terms) {
            StringBuilder sb = new StringBuilder();
            sb.append(e.getValue());
            for (String v : e.getKey()) {
                sb.append('*').append(v);
            }
            result.add(sb.toString());
        }
        return result;
    }

    private Map<List<String>, Integer> parse(Deque<String> tokens) {
        List<Map<List<String>, Integer>> addends = new ArrayList<>();
        List<Integer> signs = new ArrayList<>();
        signs.add(1);
        addends.add(parseMult(tokens));
        while (!tokens.isEmpty() && (tokens.peek().equals("+") || tokens.peek().equals("-"))) {
            String op = tokens.poll();
            signs.add(op.equals("+") ? 1 : -1);
            addends.add(parseMult(tokens));
        }
        Map<List<String>, Integer> result = new HashMap<>();
        for (int i = 0; i < addends.size(); i++) {
            int sign = signs.get(i);
            for (Map.Entry<List<String>, Integer> e : addends.get(i).entrySet()) {
                result.merge(e.getKey(), sign * e.getValue(), Integer::sum);
            }
        }
        return result;
    }

    private Map<List<String>, Integer> parseMult(Deque<String> tokens) {
        Map<List<String>, Integer> result = parseAtom(tokens);
        while (!tokens.isEmpty() && tokens.peek().equals("*")) {
            tokens.poll();
            result = multiply(result, parseAtom(tokens));
        }
        return result;
    }

    private Map<List<String>, Integer> parseAtom(Deque<String> tokens) {
        String token = tokens.poll();
        if (token.equals("(")) {
            Map<List<String>, Integer> inner = parse(tokens);
            tokens.poll(); // ')'
            return inner;
        }
        Map<List<String>, Integer> poly = new HashMap<>();
        if (Character.isDigit(token.charAt(0))) {
            poly.put(Collections.emptyList(), Integer.parseInt(token));
        } else if (evalMap.containsKey(token)) {
            poly.put(Collections.emptyList(), evalMap.get(token));
        } else {
            poly.put(Collections.singletonList(token), 1);
        }
        return poly;
    }

    private Map<List<String>, Integer> multiply(Map<List<String>, Integer> a, Map<List<String>, Integer> b) {
        Map<List<String>, Integer> result = new HashMap<>();
        for (Map.Entry<List<String>, Integer> ea : a.entrySet()) {
            for (Map.Entry<List<String>, Integer> eb : b.entrySet()) {
                List<String> combined = new ArrayList<>(ea.getKey());
                combined.addAll(eb.getKey());
                Collections.sort(combined);
                result.merge(combined, ea.getValue() * eb.getValue(), Integer::sum);
            }
        }
        return result;
    }
}
