# https://leetcode.com/problems/serialize-and-deserialize-binary-tree/

class Codec:
    def serialize(self, root) -> str:
        parts = []
        def dfs(node):
            if not node:
                parts.append('#')
                return
            parts.append(str(node.val))
            dfs(node.left)
            dfs(node.right)
        dfs(root)
        return ','.join(parts)

    def deserialize(self, data: str):
        tokens = iter(data.split(','))
        def dfs():
            token = next(tokens)
            if token == '#':
                return None
            node = TreeNode(int(token))
            node.left = dfs()
            node.right = dfs()
            return node
        return dfs()
