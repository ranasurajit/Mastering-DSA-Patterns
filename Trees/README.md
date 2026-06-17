# Binary Tree & Binary Search Tree - Interview Patterns Mastery

**Complete Guide to Crack BT and BST Problems in Coding Interviews (FAANG, Google, Amazon, Microsoft, etc.)**

This README contains:
- All major patterns with clear explanations
- Description of the common easy reusable approach for each pattern
- Curated list of problems in increasing order of difficulty (Easy → Medium → Hard)
- Enough practice problems per pattern for solid preparation

**How to Use This Guide:**
1. Understand the reusable approach for each pattern
2. Implement the approach yourself while solving problems in the given order
3. Revise all patterns and approaches every 10–15 days
4. Pay special attention to edge cases: null, single node, skewed trees, duplicates in BST

Last Updated: June 2026

---

## Binary Tree Patterns

### 1. DFS Traversals (Preorder, Inorder, Postorder)
**Description:** Foundational pattern. Master both recursive and iterative (using Stack) versions. Almost every tree problem uses some form of DFS.

**Reusable Approach:** Recurse with a helper function that visits nodes in pre/in/post order. For iterative version, use a stack to simulate recursion. Track visited nodes and result list.

**Reusable Java Template:**

```java
class Solution {
    // Recursive DFS
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        dfs(root, result);
        return result;
    }
    
    private void dfs(TreeNode node, List<Integer> result) {
        if (node == null) return;
        // Preorder: result.add(node.val); dfs(left); dfs(right);
        dfs(node.left, result);           // Inorder
        result.add(node.val);
        dfs(node.right, result);          // Postorder: add after right
    }
    
    // Iterative Inorder (easily modifiable for Pre/Postorder)
    public List<Integer> inorderIterative(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;
        while (curr != null || !stack.isEmpty()) {
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            result.add(curr.val);
            curr = curr.right;
        }
        return result;
    }
}
```

**Practice Problems:**
1. [Binary Tree Preorder Traversal (144)](https://leetcode.com/problems/binary-tree-preorder-traversal/)
2. [Binary Tree Inorder Traversal (94)](https://leetcode.com/problems/binary-tree-inorder-traversal/)
3. [Binary Tree Postorder Traversal (145)](https://leetcode.com/problems/binary-tree-postorder-traversal/)
4. [Binary Tree Preorder Traversal (Iterative)](https://leetcode.com/problems/binary-tree-preorder-traversal/)
5. [Binary Tree Inorder Traversal (Iterative)](https://leetcode.com/problems/binary-tree-inorder-traversal/)
6. [Flatten Binary Tree to Linked List (114)](https://leetcode.com/problems/flatten-binary-tree-to-linked-list/)

---

### 2. BFS / Level Order Traversals & Tree Views
**Description:** Process tree level-by-level using a queue. Essential for level order, zigzag, right side view, vertical order, top/bottom view.

**Reusable Approach:** Use a queue to process nodes level by level. Track level size in each iteration. Modify output logic based on the required view (right side, zigzag, vertical using map/ordering).

**Reusable Java Template:**

```java
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;
        
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            List<Integer> level = new ArrayList<>();
            
            for (int i = 0; i < levelSize; i++) {
                TreeNode node = queue.poll();
                level.add(node.val);
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }
            result.add(level);   // For Right Side View: just take level.get(level.size()-1)
        }
        return result;
    }
}
```

**Practice Problems:**
1. [Binary Tree Level Order Traversal (102)](https://leetcode.com/problems/binary-tree-level-order-traversal/)
2. [Binary Tree Right Side View (199)](https://leetcode.com/problems/binary-tree-right-side-view/)
3. [Binary Tree Zigzag Level Order Traversal (103)](https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/)
4. [Populating Next Right Pointers in Each Node (116)](https://leetcode.com/problems/populating-next-right-pointers-in-each-node/)
5. [Vertical Order Traversal of a Binary Tree (987)](https://leetcode.com/problems/vertical-order-traversal-of-a-binary-tree/)

---

### 3. Recursive DFS / Divide & Conquer
**Description:** Most important and frequent pattern. Recurse on left and right subtree, then combine results at the root node. Use a class variable when global state (like maximum) is needed.

**Reusable Approach:** Base case for null node. Call function recursively on left and right children. At each node combine the results from both subtrees (height, max path, balanced check, etc.) and return value to parent.

**Reusable Java Template:**

```java
class Solution {
    private int maxValue = Integer.MIN_VALUE;   // for global results like diameter/max path sum
    
    public int solve(TreeNode root) {
        if (root == null) {
            return 0;        // Return -1 for balanced, null for LCA style, etc.
        }
        
        int left = solve(root.left);
        int right = solve(root.right);
        
        // Problem-specific combine logic goes here
        // Example for diameter: maxValue = Math.max(maxValue, left + right);
        
        return 1 + Math.max(left, right);   // Modify return value as needed
    }
}
```

**Practice Problems:**
1. [Maximum Depth of Binary Tree (104)](https://leetcode.com/problems/maximum-depth-of-binary-tree/)
2. [Symmetric Tree (101)](https://leetcode.com/problems/symmetric-tree/)
3. [Same Tree (100)](https://leetcode.com/problems/same-tree/)
4. [Balanced Binary Tree (110)](https://leetcode.com/problems/balanced-binary-tree/)
5. [Diameter of Binary Tree (543)](https://leetcode.com/problems/diameter-of-binary-tree/)
6. [Invert Binary Tree (226)](https://leetcode.com/problems/invert-binary-tree/)
7. [Binary Tree Maximum Path Sum (124)](https://leetcode.com/problems/binary-tree-maximum-path-sum/)

---

### 4. Root-to-Leaf Path & Path Sum Problems (Backtracking)
**Description:** Track the current path from root to any leaf or target sum. Use backtracking to explore all possible paths.

**Reusable Approach:** Use a helper DFS function that maintains a current path list and remaining target. Add node to path at each step, check leaf condition, recurse on children, then remove node (backtrack) after recursion.

**Reusable Java Template:**

```java
class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int target) {
        List<List<Integer>> result = new ArrayList<>();
        dfs(root, target, new ArrayList<>(), result);
        return result;
    }
    
    private void dfs(TreeNode node, int target, List<Integer> path, List<List<Integer>> result) {
        if (node == null) return;
        
        path.add(node.val);
        target -= node.val;
        
        if (node.left == null && node.right == null && target == 0) {
            result.add(new ArrayList<>(path));   // deep copy
        }
        
        dfs(node.left, target, path, result);
        dfs(node.right, target, path, result);
        
        path.remove(path.size() - 1);   // backtrack
    }
}
```

**Practice Problems:**
1. [Path Sum (112)](https://leetcode.com/problems/path-sum/)
2. [Binary Tree Paths (257)](https://leetcode.com/problems/binary-tree-paths/)
3. [Path Sum II (113)](https://leetcode.com/problems/path-sum-ii/)
4. [Sum Root to Leaf Numbers (129)](https://leetcode.com/problems/sum-root-to-leaf-numbers/)
5. [Path Sum III (437)](https://leetcode.com/problems/path-sum-iii/)

---

### 5. Lowest Common Ancestor (Binary Tree)
**Description:** Find the lowest common ancestor of two given nodes in a normal Binary Tree (not BST).

**Reusable Approach:** Recurse on left and right subtrees. If both nodes are found in different subtrees, current root is the LCA. Return the non-null result from left or right, or root if it matches p or q.

**Reusable Java Template:**

```java
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) {
            return root;
        }
        
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        
        if (left != null && right != null) return root;
        return left != null ? left : right;
    }
}
```

**Practice Problems:**
1. [Lowest Common Ancestor of a Binary Tree (236)](https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/)
2. [All Nodes Distance K in Binary Tree (863)](https://leetcode.com/problems/all-nodes-distance-k-in-binary-tree/)

---

### 6. Binary Tree Construction from Traversals
**Description:** Build a tree from given traversals (preorder + inorder, inorder + postorder, sorted array to BST).

**Reusable Approach:** Use divide and conquer. HashMap for quick lookup of root index in inorder array. Recursively build left and right subtrees by calculating subtree ranges in both arrays.

**Reusable Java Template:**

```java
class Solution {
    private Map<Integer, Integer> inorderMap = new HashMap<>();
    
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for (int i = 0; i < inorder.length; i++) {
            inorderMap.put(inorder[i], i);
        }
        return build(preorder, 0, preorder.length - 1, 0, inorder.length - 1);
    }
    
    private TreeNode build(int[] preorder, int preStart, int preEnd, int inStart, int inEnd) {
        if (preStart > preEnd) return null;
        
        TreeNode root = new TreeNode(preorder[preStart]);
        int rootIndex = inorderMap.get(root.val);
        int leftSize = rootIndex - inStart;
        
        root.left = build(preorder, preStart + 1, preStart + leftSize, inStart, rootIndex - 1);
        root.right = build(preorder, preStart + leftSize + 1, preEnd, rootIndex + 1, inEnd);
        return root;
    }
}
```

**Practice Problems:**
1. [Convert Sorted Array to Binary Search Tree (108)](https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/)
2. [Construct Binary Tree from Preorder and Inorder Traversal (105)](https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/)
3. [Construct Binary Tree from Inorder and Postorder Traversal (106)](https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/)

---

### 7. Serialize, Deserialize & Flatten
**Description:** Convert tree to a string representation and reconstruct it back. Also includes flattening tree to linked list.

**Reusable Approach:** Use preorder DFS to serialize (add null markers). For deserialization, use a queue or iterator of values and recursively build nodes. For flatten, use postorder or stack to rearrange pointers.

**Reusable Java Template:**

```java
public class Codec {
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        dfsSerialize(root, sb);
        return sb.toString();
    }
    
    private void dfsSerialize(TreeNode node, StringBuilder sb) {
        if (node == null) {
            sb.append("N,");
            return;
        }
        sb.append(node.val).append(",");
        dfsSerialize(node.left, sb);
        dfsSerialize(node.right, sb);
    }
    
    public TreeNode deserialize(String data) {
        Queue<String> queue = new LinkedList<>(Arrays.asList(data.split(",")));
        return dfsDeserialize(queue);
    }
    
    private TreeNode dfsDeserialize(Queue<String> queue) {
        String val = queue.poll();
        if (val.equals("N")) return null;
        TreeNode node = new TreeNode(Integer.parseInt(val));
        node.left = dfsDeserialize(queue);
        node.right = dfsDeserialize(queue);
        return node;
    }
}
```

**Practice Problems:**
1. [Flatten Binary Tree to Linked List (114)](https://leetcode.com/problems/flatten-binary-tree-to-linked-list/)
2. [Serialize and Deserialize Binary Tree (297)](https://leetcode.com/problems/serialize-and-deserialize-binary-tree/)

---

### 8. Tree as Graph + Distance K Problems
**Description:** Treat the binary tree as an undirected graph. This pattern is useful when movement is allowed not only from parent to child, but also from child to parent. Common applications include finding all nodes at distance `K` from a target node and computing infection spread time.

**When to Use:**
- When traversal needs to move both upward and downward in the tree
- When the target is not necessarily the root
- When the problem asks for shortest distance / BFS-like expansion from a node in a tree

**Reusable Template Logic:**

**Main Logic:**
1. `buildGraph()`  
   Convert the binary tree into an undirected graph using an adjacency list.  
   - Every node is connected to its parent
   - Every parent is connected to its children  
   This allows free movement in both directions.

2. `bfs()`  
   Run a standard BFS from the target node.  
   - Use a queue for level-order traversal
   - Use a visited set to avoid revisiting nodes
   - Track distance level by level
   - When distance becomes `k`, collect all remaining nodes in the queue

**Common Modifications:**
- For [Amount of Time for Binary Tree to Be Infected (2385)](https://leetcode.com/problems/amount-of-time-for-binary-tree-to-be-infected/)  
  Change the return type to `int` and return the maximum distance reached during BFS instead of collecting nodes.
- To return nodes in sorted order  
  Sort the result list before returning.
- To start from any node  
  You can start BFS from any node value, not just `target.val`.

**Why This Pattern Works:**
A binary tree normally only gives access from parent to children. But in many problems, you also need to move upward to the parent. Converting the tree into a graph solves this by giving every node access to all of its neighbors.

**Time Complexity:**
- Building graph: `O(n)`
- BFS traversal: `O(n)`
- Overall: `O(n)`

**Space Complexity:**
- Graph storage: `O(n)`
- Queue + visited set: `O(n)`

**Reusable Java Template:**

```java
import java.util.*;

class Solution {
    
    private Map<Integer, List<Integer>> graph = new HashMap<>();
    
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        if (root == null) return new ArrayList<>();
        
        // Step 1: Convert Binary Tree into Undirected Graph
        buildGraph(root, null);
        
        // Step 2: BFS from target node to find all nodes at distance k
        return bfs(target.val, k);
    }
    
    /**
     * DFS to build adjacency list (treat tree as undirected graph)
     */
    private void buildGraph(TreeNode node, TreeNode parent) {
        if (node == null) return;
        
        graph.putIfAbsent(node.val, new ArrayList<>());
        
        if (parent != null) {
            graph.get(node.val).add(parent.val);
            graph.get(parent.val).add(node.val);
        }
        
        buildGraph(node.left, node);
        buildGraph(node.right, node);
    }
    
    /**
     * BFS from starting node to collect all nodes at exact distance k
     */
    private List<Integer> bfs(int start, int k) {
        List<Integer> result = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        
        queue.offer(start);
        visited.add(start);
        int distance = 0;
        
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            
            if (distance == k) {
                while (!queue.isEmpty()) {
                    result.add(queue.poll());
                }
                return result;
            }
            
            for (int i = 0; i < levelSize; i++) {
                int current = queue.poll();
                
                for (int neighbor : graph.getOrDefault(current, Collections.emptyList())) {
                    if (!visited.contains(neighbor)) {
                        visited.add(neighbor);
                        queue.offer(neighbor);
                    }
                }
            }
            
            distance++;
        }
        
        return result;
    }
}
```

**Practice Problems:**
1. [All Nodes Distance K in Binary Tree (863)](https://leetcode.com/problems/all-nodes-distance-k-in-binary-tree/)
2. [Amount of Time for Binary Tree to Be Infected (2385)](https://leetcode.com/problems/amount-of-time-for-binary-tree-to-be-infected/)

**Interview Tip:**  
If a tree problem allows moving “in all directions” from a node, immediately think:  
**Tree → Graph + BFS**

---

## Binary Search Tree Patterns

### 9. BST Validation & Range-based Recursion
**Description:** Validate if a tree is a valid BST or solve problems by passing valid min/max range down the recursion.

**Reusable Approach:** Pass lower and upper bounds in recursive calls. At each node check if value lies within bounds, then recurse left with updated upper bound and right with updated lower bound.

**Reusable Java Template:**

```java
class Solution {
    public boolean isValidBST(TreeNode root) {
        return validate(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
    
    private boolean validate(TreeNode node, long min, long max) {
        if (node == null) return true;
        if (node.val <= min || node.val >= max) return false;
        return validate(node.left, min, node.val) && 
               validate(node.right, node.val, max);
    }
}
```

**Practice Problems:**
1. [Validate Binary Search Tree (98)](https://leetcode.com/problems/validate-binary-search-tree/)
2. [Trim a Binary Search Tree (669)](https://leetcode.com/problems/trim-a-binary-search-tree/)
3. [Search in a Binary Search Tree (700)](https://leetcode.com/problems/search-in-a-binary-search-tree/)

---

### 10. Inorder Traversal Utilization on BST
**Description:** Take advantage of the fact that inorder traversal of BST gives nodes in sorted order.

**Reusable Approach:** Perform inorder traversal (recursive or iterative with stack). Count visited nodes or modify values during inorder to solve kth smallest, greater tree conversion, recover BST, etc.

**Reusable Java Template:**

```java
class Solution {
    private int count = 0;
    private int result = -1;
    
    public int kthSmallest(TreeNode root, int k) {
        inorder(root, k);
        return result;
    }
    
    private void inorder(TreeNode node, int k) {
        if (node == null || count >= k) return;
        inorder(node.left, k);
        count++;
        if (count == k) {
            result = node.val;
            return;
        }
        inorder(node.right, k);
    }
}
```

**Practice Problems:**
1. [Kth Smallest Element in a BST (230)](https://leetcode.com/problems/kth-smallest-element-in-a-bst/)
2. [Convert BST to Greater Tree (538)](https://leetcode.com/problems/convert-bst-to-greater-tree/)
3. [Increasing Order Search Tree (897)](https://leetcode.com/problems/increasing-order-search-tree/)
4. [Recover Binary Search Tree (99)](https://leetcode.com/problems/recover-binary-search-tree/)

---

### 11. BST Modification (Insert, Delete, Trim)
**Description:** Insert, delete or trim nodes while maintaining the BST property.

**Reusable Approach:** Compare value with root and recurse on left or right subtree. For insert/delete handle null cases and return updated subtree root. Maintain BST ordering in all operations.

**Reusable Java Template:**

```java
class Solution {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) return new TreeNode(val);
        if (val < root.val) {
            root.left = insertIntoBST(root.left, val);
        } else if (val > root.val) {
            root.right = insertIntoBST(root.right, val);
        }
        return root;
    }
}
```

**Practice Problems:**
1. [Insert into a Binary Search Tree (701)](https://leetcode.com/problems/insert-into-a-binary-search-tree/)
2. [Delete Node in a BST (450)](https://leetcode.com/problems/delete-node-in-a-bst/)
3. [Trim a Binary Search Tree (669)](https://leetcode.com/problems/trim-a-binary-search-tree/)

---

### 12. BST Advanced (Iterator, Successor, LCA in BST)
**Description:** Use BST property for efficient LCA, successor finding, or implement iterator with controlled inorder traversal.

**Reusable Approach:** For iterator, use a stack to simulate inorder and push all left children initially. For LCA in BST, move left or right based on comparison with p and q values without full traversal.

**Reusable Java Template:**

```java
class BSTIterator {
    private Stack<TreeNode> stack = new Stack<>();
    
    public BSTIterator(TreeNode root) {
        pushAllLeft(root);
    }
    
    public int next() {
        TreeNode node = stack.pop();
        pushAllLeft(node.right);
        return node.val;
    }
    
    public boolean hasNext() {
        return !stack.isEmpty();
    }
    
    private void pushAllLeft(TreeNode node) {
        while (node != null) {
            stack.push(node);
            node = node.left;
        }
    }
}
```

**Practice Problems:**
1. [Lowest Common Ancestor of a Binary Search Tree (235)](https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/)
2. [Binary Search Tree Iterator (173)](https://leetcode.com/problems/binary-search-tree-iterator/)
3. [Find Mode in Binary Search Tree (501)](https://leetcode.com/problems/find-mode-in-binary-search-tree/)

---

## Recommended Practice Strategy
1. Master Patterns 1, 2, 3, 9, and 10 first (they appear most frequently in interviews).
2. Solve all Easy problems + first 4 Medium problems in each pattern before moving to Hard.
3. Revise all patterns and their reusable approaches every 2 weeks.
4. Focus on understanding why each approach works rather than memorizing solutions.

**Common Interview Favorites:** Vertical Order Traversal, Serialize/Deserialize, Kth Smallest, Max Path Sum, LCA (both BT and BST versions), Diameter, Burning Tree (on GFG).

**Happy Coding!** Consistent practice with these 12 patterns will cover 90%+ of Binary Tree and BST questions asked in real interviews.

Made for serious interview preparation.
