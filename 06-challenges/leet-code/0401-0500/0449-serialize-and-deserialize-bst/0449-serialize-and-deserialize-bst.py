# https://leetcode.com/problems/serialize-and-deserialize-bst/

class Codec:
    def serialize(self, root) -> str:
        tokens = []
        def preorder(node):
            if not node:
                return
            tokens.append(str(node.val))
            preorder(node.left)
            preorder(node.right)
        preorder(root)
        return ' '.join(tokens)

    def deserialize(self, data: str):
        if not data:
            return None
        from collections import deque
        queue = deque(int(x) for x in data.split())

        def build(min_val, max_val):
            if not queue or not (min_val < queue[0] < max_val):
                return None
            val = queue.popleft()
            node = TreeNode(val)
            node.left = build(min_val, val)
            node.right = build(val, max_val)
            return node

        return build(float('-inf'), float('inf'))
