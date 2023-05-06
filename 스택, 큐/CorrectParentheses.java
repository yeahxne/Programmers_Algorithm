package StackAndQueue;

import java.util.*;

public class CorrectParentheses {
    public boolean solution(String str) {
        boolean answer = true;
        Stack<Character> stack = new Stack<>();

        for(char c : str.toCharArray()) {
            if(c == '(') {
                stack.push(c);
            } else {  /* ')'괄호를 만난 상황 */
                if(stack.isEmpty()) {  /* ')'에 대한 짝이 존재하지 않는 상황 */
                    return false;
                }
                stack.pop();
            }
        }

        if(!stack.isEmpty()) {  /* '('가 ')'보다 더 많은 상황 */
            return false;
        }
        return answer;
    }
}
