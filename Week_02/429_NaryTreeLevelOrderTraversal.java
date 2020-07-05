import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import org.w3c.dom.Node;

/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    // DFS
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> result = new ArrayList<>();
        traverse(root, result, 0);
        return result;
    }

    private void traverse(Node root, List<List<Integer>> result, int level) {
        if (root == null) {
            return;
        }

        if (result.size() <= level) {
            result.add(new ArrayList<>());
        }

        result.get(level).add(root.val);
        for (Node child: root.children) {
            traverse(child, result, level + 1);
        }
    }

    // BFS
    public List<List<Integer>> levelOrder2(Node root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            List<Integer> level = new ArrayList<>();
            int size = queue.size();
            for (int i = 0; i < size; ++i) {
                Node cur = queue.poll();
                level.add(cur.val);
                for (Node child: cur.children) {
                    queue.offer(child);
                }
            }
            result.add(level);
        }
        return result;
    }
}