package StackAndQueue;

import java.util.*;

public class DoNotLikeSameNumber {
    public ArrayList<Integer> solution(int[] arr) {
        ArrayList<Integer> answer = new ArrayList<>();

        int num = -1; /* num: 배열 arr 의 원소는 숫자 0부터 9까지로 이루어져 있기 때문에, -1로 초기화 */
        for(int i=0; i<arr.length; i++) {
            if(arr[i] != num) {
                answer.add(arr[i]);
            }
            num = arr[i];
        }
        return answer;
    }
}
