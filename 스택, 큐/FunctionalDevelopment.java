package StackAndQueue;

import java.util.*;

public class FunctionalDevelopment {
    public ArrayList<Integer> solution(int[] progresses, int[] speeds) {
        ArrayList<Integer> answer = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();

        for(int i=0; i<progresses.length; i++) {
            queue.offer((int)(Math.ceil((100.0-progresses[i])/speeds[i])));  /* Math.ceil(): 소수점 이하를 반올림 */
        }

        while(!queue.isEmpty()) {
            int day = queue.poll();
            int cnt = 1;

            while(!queue.isEmpty() && day >= queue.peek()) {
                cnt++;
                queue.poll();
            }
            answer.add(cnt);
        }
        return answer;
    }
}
