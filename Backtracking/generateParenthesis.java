import java.util.ArrayList;
import java.util.List;

class generateParenthesis {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        backtrack(result, "", 0, 0, n);
        return result;
    }
    
    private void backtrack(List<String> result, String current, int openCount, int closeCount, int n) {
        if (openCount == n && closeCount == n) {
            result.add(current);
            return;
        }
        
        if (openCount < n) {
            backtrack(result, current + "(", openCount + 1, closeCount, n);
        }
        if (closeCount < openCount) {
            backtrack(result, current + ")", openCount, closeCount + 1, n);
        }
    }
    public static void main(String[] args) {
        generateParenthesis gp = new generateParenthesis();
        int n = 3;
        List<String> parenthesesCombinations = gp.generateParenthesis(n);
        System.out.println(parenthesesCombinations);
    }

}