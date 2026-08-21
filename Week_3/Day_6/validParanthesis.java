package Week_3.Day_6;

import java.util.Stack;

public class validParanthesis {

    static boolean isValidParentheses(String s) {

        Stack<Character> st = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char curr = s.charAt(i);
            if (curr == '(' || curr == '{' || curr == '[') {
                st.push(curr);
            } else {
                if (st.empty()) {
                    return false;
                }
                char top = st.peek();
                if (top == '(' && curr == ')') {
                    st.pop();
                } else if (top == '{' && curr == '}') {
                    st.pop();
                } else if (top == '[' && curr == ']') {
                    st.pop();
                } else {
                    return false;
                }
            }
        }

        return st.empty();
    }

    public static void main(String[] args) {
        String par = "{({[})}";
        boolean isvalid = isValidParentheses(par);
        System.out.println("is \"{({[})}\" a valid paranthensis: " + isvalid);

    }
}
