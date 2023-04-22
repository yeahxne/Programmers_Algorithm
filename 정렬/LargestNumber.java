import java.util.Arrays;
import java.util.Comparator;

public class LargestNumber {
    public String solution(int[] numbers) {
        String answer = "";
        String[] stringNumbers = new String[numbers.length];

        for(int i=0; i<numbers.length; i++) {
            stringNumbers[i] = String.valueOf(numbers[i]);  /* int 배열을 String 배열로 변환 */
        }

        /* compare(String o1, String o2): o1>o2 이면 양수, o1=o2 이면 0, o1<o2 이면 음수를 반환
        *  o1.compareTo(o2): o1>o2 이면 양수, o1=o2 이면 0, o1<o2 이면 음수를 반환
        *  오름차순 정렬일 경우, (o1).compareTo(o2)
        *  내림차순 정렬의 경우, (o2).compareTo(o1) */
        Arrays.sort(stringNumbers, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return (o2+o1).compareTo(o1+o2);  /* 내림차순 정렬 */
            }
        });

        /* 0 값이 중복일 경우, 0으로 리턴 */
        if(stringNumbers[0].equals("0")) {
            return "0";
        }

        for(int i=0; i<stringNumbers.length; i++) {
            answer += stringNumbers[i];
        }

        return answer;
    }
}
