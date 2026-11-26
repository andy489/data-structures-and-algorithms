# https://leetcode.com/problems/html-entity-parser/

class Solution:
    def entityParser(self, text: str) -> str:
        entities = [("&quot;", '"'), ("&apos;", "'"), ("&gt;", ">"), ("&lt;", "<"), ("&frasl;", "/"), ("&amp;", "&")]
        for entity, ch in entities:
            text = text.replace(entity, ch)
        return text
