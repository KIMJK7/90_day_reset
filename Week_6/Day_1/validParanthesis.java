package Week_6.Day_1;

import java.util.ArrayDeque;

public class validParanthesis {
    boolean isValid(String s) {
        ArrayDeque<Character> Stack = new ArrayDeque<>();
        for (int i = 0; i < s.length(); i++) {
            char str = s.charAt(i);
            if (str == '(' || str == '{' || str == '[') {
                Stack.push(str);
            } else {
                if (Stack.isEmpty()) {
                    return false;
                } else if (str == ')' && Stack.peek() == '(' || str == '}' && Stack.peek() == '{'
                        || str == ']' && Stack.peek() == '[') {
                    Stack.pop();
                } else {
                    return false;
                }
            }

        }
        return Stack.isEmpty();
    }
}
