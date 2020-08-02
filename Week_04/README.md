学习笔记

# Depth First Search

```
visited = set()

def dfs(node, visited):
    if node in visited:
        return
    
    visited.add(node)

    for next_node in node.children():
        if not next_node in visited:
            dfs(next_node, visited)
```

# Breadth First Search

```
def bfs(graph, start end):
    queue = []
    queue.append([start])

    while queue:
        node = queue.pop()
        visited.add(node)

        process(node)

        nodes = generate_related_nodes(node)
        queue.push(nodes)
```

