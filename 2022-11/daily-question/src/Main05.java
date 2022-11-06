/**
 * 1106. 解析布尔表达式
 *
 * @author yangxiaozhuo
 * @date 2022/11/05
 * <p>
 * 给你一个以字符串形式表述的 布尔表达式（boolean） expression，返回该式的运算结果。
 * 有效的表达式需遵循以下约定：
 * "t"，运算结果为 True
 * "f"，运算结果为 False
 * "!(expr)"，运算过程为对内部表达式 expr 进行逻辑 非的运算（NOT）
 * "&(expr1,expr2,...)"，运算过程为对 2 个或以上内部表达式 expr1, expr2, ... 进行逻辑 与的运算（AND）
 * "|(expr1,expr2,...)"，运算过程为对 2 个或以上内部表达式 expr1, expr2, ... 进行逻辑 或的运算（OR）
 * <p>
 * 示例 1：
 * 输入：expression = "!(f)"
 * 输出：true
 */
public class Main05 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.parseBoolExpr("|(&(t,f,t),!(t))"));
    }

    static class Solution {
        public boolean parseBoolExpr(String expression) {
            if (expression.length() == 0) {
                return true;
            }
            if (expression.length() == 1) {
                return expression.equals("t");
            }
            if (expression.charAt(0) == '!') {
                return !parseBoolExpr(expression.substring(2, expression.length() - 1));
            }
            if (expression.charAt(0) == '|') {
                int start = 2;
                int i = 2;
                int count = 0;
                for (; i < expression.length(); i++) {
                    if (expression.charAt(i) == '(') {
                        count++;
                    }
                    if (expression.charAt(i) == ')') {
                        count--;
                    }
                    if ((expression.charAt(i) == ',' && count == 0) || i == expression.length() - 1) {
                        String temp = expression.substring(start, i);
                        if (parseBoolExpr(temp)) {
                            return true;
                        }
                        start = i + 1;
                    }
                }
                return false;
            }
            if (expression.charAt(0) == '&') {
                int start = 2;
                int i = 2;
                int count = 0;
                for (; i < expression.length(); i++) {
                    if (expression.charAt(i) == '(') {
                        count++;
                    }
                    if (expression.charAt(i) == ')') {
                        count--;
                    }
                    if ((expression.charAt(i) == ',' && count == 0) || i == expression.length() - 1) {
                        String temp = expression.substring(start, i);
                        if (!parseBoolExpr(temp)) {
                            return false;
                        }
                        start = i + 1;
                    }
                }
                return true;
            }
            return true;
        }
    }
}
