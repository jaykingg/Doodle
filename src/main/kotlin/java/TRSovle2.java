package java;

public class TRSovle2 {
    public int solution(String s) {
        StringBuilder result = new StringBuilder();

        for (char c : s.toCharArray()) {
            if (result.length() > 0 && result.charAt(result.length() - 1) == '1' && c == '0') {
                result.deleteCharAt(result.length() - 1);
            } else if (result.length() > 0 && result.charAt(result.length() - 1) == '0' && c == '1') {
                result.deleteCharAt(result.length() - 1);
            } else {
                result.append(c);
            }
        }

        return result.length();
    }

//    public static int solution(String s) {
//        Stack<Character> stack0 = new Stack<>();
//        Stack<Character> stack1 = new Stack<>();
//
//        for (char c : s.toCharArray()) {
//            if (c == '0') {
//                if (!stack1.isEmpty() && stack1.peek() == '1') {
//                    stack1.pop();
//                } else {
//                    stack0.push(c);
//                }
//            } else {
//                if (!stack0.isEmpty() && stack0.peek() == '0') {
//                    stack0.pop();
//                } else {
//                    stack1.push(c);
//                }
//            }
//        }
//
//        return stack0.size() + stack1.size();
//    }
}
