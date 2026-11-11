package Recursion.ExpressionAddOperation;
import java.util.ArrayList;
import java.util.List;

class Optimal {
    private final List<String> res = new ArrayList<>();
    private String num;
    private long target;

    public List<String> addOperators(String num, int target) {
        this.num = num;
        this.target = target;
        dfs(new StringBuilder(), 0, 0, 0);
        return res;
    }

    private void dfs(StringBuilder path, int start, long resSoFar, long prevVal) {
        if (start == num.length()) {
            if (resSoFar == target) res.add(path.toString());
            return;
        }
        int len = path.length();
        long cur = 0;
        for (int i = start; i < num.length(); i++) {
            if (i > start && num.charAt(start) == '0') break;
            cur = cur * 10 + (num.charAt(i) - '0');   // grow operand in O(1)

            if (start == 0) {
                path.append(cur);
                dfs(path, i + 1, cur, cur);
            } else {
                path.append('+').append(cur);
                dfs(path, i + 1, resSoFar + cur, cur);
                path.setLength(len);

                path.append('-').append(cur);
                dfs(path, i + 1, resSoFar - cur, -cur);
                path.setLength(len);

                path.append('*').append(cur);
                // undo prev operation, do multiply first , then add it to ressofar
                //eg: 2+3*4 => 2+3=5 => 5-3 + 3*4 = 14
                dfs(path, i + 1, resSoFar - prevVal + prevVal * cur, prevVal * cur);
            }
            path.setLength(len);//backtrack to previous state for next iteration
        }
    }
}