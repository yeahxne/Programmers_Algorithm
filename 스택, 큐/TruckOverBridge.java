package StackAndQueue;

import java.util.*;

public class TruckOverBridge {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int sum = 0;  /* sum: 현재 다리를 건너는 트럭 무게의 합 */
        int second = 0;  /* second: 경과 시간 */
        Queue<Integer> queue = new LinkedList<>();  /* queue: 대기 트럭 */

        for(int i=0; i<truck_weights.length; i++) {
            int truck = truck_weights[i];

            while(true) {
                if(queue.isEmpty()) {  /* queue 에 아무것도 없는 경우(어떠한 트럭도 다리 위에 없는 경우) */
                    queue.offer(truck);
                    sum += truck;
                    second++;  /* 다리에 오를 때만 시간 추가 */
                    break;
                } else if(queue.size() == bridge_length) {  /* queue 에 다리 길이만큼 트럭이 다 찬 경우 */
                    sum -= queue.poll();
                } else {  /* 다리 길이만큼 queue 가 가득차지 않은 경우 */
                    if(sum+truck <= weight) {  /* 다리에 트럭을 올릴 수 있는 경우 */
                        queue.offer(truck);
                        sum += truck;
                        second++;
                        break;
                    } else {  /* 다리에 트럭을 올릴 수 없는 경우 */
                        queue.offer(0);  /* 0kg 을 넣어 큐에 이미 있는 트럭이 다리를 지나가도록 만듬 */
                        second++;
                    }
                }
            }
        }
        return second+bridge_length;  /* 지금까지 걸린 second 에 마지막 트럭이 건너는 데 걸리는 시간(다리의 길이)을 합한다 */
    }
}
