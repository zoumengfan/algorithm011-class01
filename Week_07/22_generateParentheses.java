class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        dfs(result, n, n, "");
        return result;
    }

    private void dfs(List<String> result, int left, int right, String cur) {
        if (left == 0 && right == 0) {
            result.add(cur);
            return;
        }

        if (left > 0) {
            dfs(result, left - 1, right, cur + "(");
        }

        if (right > left) {
            dfs(result, left, right - 1, cur + ")");
        }
    }
}