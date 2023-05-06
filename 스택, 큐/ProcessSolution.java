package StackAndQueue;

import java.util.*;

class Process {
    int priority;
    int location;

    public Process(int priority, int location) {
        this.priority = priority;
        this.location = location;
    }
}

public class ProcessSolution {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        Queue<Process> queue = new LinkedList<>();

        for(int i=0; i< priorities.length; i++) {
            queue.offer(new Process(priorities[i], i));
        }

        while(!queue.isEmpty()) {
            Process tmp = queue.poll();
            for(Process x : queue) {
                if(x.priority > tmp.priority) {
                    queue.offer(tmp);
                    tmp = null;
                    break;
                }
            }
            if(tmp != null) {
                answer++;
                if(tmp.location == location) {
                    return answer;
                }
            }
        }
        return answer;
    }
}
