package java;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class TRSovle1 {
    public int[] solution(int[] waiting) {
        Set<Integer> set = new LinkedHashSet<>();
        List<Integer> list = new ArrayList<>();

        for (Integer num : waiting) {
            if (!set.contains(num)) {
                set.add(num);
                list.add(num);
            }
        }

        int[] answer = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }
        return answer;
    }
}
