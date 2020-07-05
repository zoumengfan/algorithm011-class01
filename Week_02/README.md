学习笔记
# Hash Table
## Hash Collisions
- Design the proper hash function
- Use list to store collision elements

# Tree
- No Circle (special graph)
- Tree Traversal
 ## Binary Search Tree
 - Find: O(logn)
 - Insert: O(logn)
 - Delete: O(logn)

# Heap
Find the max / min value
- FindMax: O(1)
- DeleteMax: O(logn)
- Insert: O(logn) or O(1)

There is a lot of different implementation for Heap. Binary Heap is a simple but in-efficient implementation for Heap. 

Better implementation: Fibonacci / Strict Fibonacci

## Binary Heap
- Complete Binary Tree

Use array to represent binary heap.
For each element at index i:
- Left child: 2 * i + 1
- Right child: 2 * i + 2
- Parent: (i - 1) / 2

Insert:
- Insert to the end
- Heapify Up (Compare with parent, and swap if needed)

Delete Max:
- Move end element to root
- Heapify Down (Compare with children, move the bigger one up)


# Graph
Vertex
- In-degree
- Out-degree

Edge
- Directional vs. Un-directional
- Weighted

