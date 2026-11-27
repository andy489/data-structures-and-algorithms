# https://leetcode.com/problems/longest-substring-of-one-repeating-character/
class Solution:
    def longestRepeating(self, s: str, queryCharacters: str, queryIndices: List[int]) -> List[int]:
        n = len(s)
        arr = list(s)
        max_len = [0] * (4 * n)
        pref_len = [0] * (4 * n)
        suf_len = [0] * (4 * n)
        pref_char = [''] * (4 * n)
        suf_char = [''] * (4 * n)

        def set_leaf(node, pos):
            max_len[node] = pref_len[node] = suf_len[node] = 1
            pref_char[node] = suf_char[node] = arr[pos]

        def merge(node, left, mid, right):
            pref_char[node] = pref_char[2 * node]
            suf_char[node] = suf_char[2 * node + 1]
            left_size = mid - left + 1
            right_size = right - mid
            pref_len[node] = pref_len[2 * node]
            if pref_len[2 * node] == left_size and pref_char[2 * node] == pref_char[2 * node + 1]:
                pref_len[node] = left_size + pref_len[2 * node + 1]
            suf_len[node] = suf_len[2 * node + 1]
            if suf_len[2 * node + 1] == right_size and suf_char[2 * node + 1] == suf_char[2 * node]:
                suf_len[node] = right_size + suf_len[2 * node]
            max_len[node] = max(max_len[2 * node], max_len[2 * node + 1])
            if suf_char[2 * node] == pref_char[2 * node + 1]:
                max_len[node] = max(max_len[node], suf_len[2 * node] + pref_len[2 * node + 1])

        def build(node, left, right):
            if left == right:
                set_leaf(node, left)
                return
            mid = (left + right) // 2
            build(2 * node, left, mid)
            build(2 * node + 1, mid + 1, right)
            merge(node, left, mid, right)

        def update(node, left, right, pos):
            if left == right:
                set_leaf(node, pos)
                return
            mid = (left + right) // 2
            if pos <= mid:
                update(2 * node, left, mid, pos)
            else:
                update(2 * node + 1, mid + 1, right, pos)
            merge(node, left, mid, right)

        build(1, 0, n - 1)
        result = []
        for i, qi in enumerate(queryIndices):
            arr[qi] = queryCharacters[i]
            update(1, 0, n - 1, qi)
            result.append(max_len[1])
        return result
