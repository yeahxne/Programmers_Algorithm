import java.util.Arrays;

public class KthNumber {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];

        for(int index=0; index<commands.length; index++) {  /* 2차원 배열 row 의 길이 */
            int i = commands[index][0];
            int j = commands[index][1];
            int k = commands[index][2];

            int[] sliceArray = Arrays.copyOfRange(array, i-1, j);  /* copyOfRange(arr,n1,n2): (원본배열, 복사할 시작 인덱스, 복사할 끝 인덱스) */
            Arrays.sort(sliceArray);  /* 배열 오름차수 정렬 */

            answer[index] = sliceArray[k-1];
        }
        return answer;
    }
}