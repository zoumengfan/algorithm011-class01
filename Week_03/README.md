学习笔记

# Recursion

``` 
void recursion (int level, int param) {
    // terminator
    if (level > MAX_LEVEL) {
        // process_result;
        return;
    }

    // process logic in current level
    process(level, param);

    // drill down
    recursion(level + 1, newParam);

    // reverse the current level status if needed
}
```

- 不要进行人肉递归
- 找最近重复子问题
- 数学归纳法思维
