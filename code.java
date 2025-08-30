import java.util.*;

public class ExpressionResults {
    public static Set<Integer> evaluate(String expr) {
        Set<Integer> results = new HashSet<>();
        for (int i = 0; i < expr.length(); i++) {
            char c = expr.charAt(i);
            if (c == '+' || c == '-' || c == '*' || c == '/') {
                String left = expr.substring(0, i);
                String right = expr.substring(i + 1);
                Set<Integer> leftResults = evaluate(left);
                Set<Integer> rightResults = evaluate(right);

                for (int l : leftResults) {
                    for (int r : rightResults) {
                        if (c == '+') results.add(l + r);
                        else if (c == '-') results.add(l - r);
                        else if (c == '*') results.add(l * r);
                        else if (c == '/' && r != 0) results.add(l / r);
                    }
                }
            }
        }
        if (results.isEmpty()) results.add(Integer.parseInt(expr));
        return results;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String expr = sc.nextLine();
        Set<Integer> results = evaluate(expr);

        System.out.println("Results for expression: " + expr);
        System.out.println("Possible results: " + results);
        int sum = 0;
        for (int val : results) sum += val;
        System.out.println("Sum of results: " + sum);
    }
}
