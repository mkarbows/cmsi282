import java.util.*;
import java.util.ArrayList;

public class BacktrackingEngine <T> {
    ArrayList<T> input;
    SafeChecker<T> verify;
    public BacktrackingEngine (ArrayList<T> input, SafeChecker<T> validator) {
        this.input = input;
        this.verify = validator;
    }

    public ArrayList<T> solve (int length) {
        ArrayStack<T> answer = new ArrayStack<T>();
        while (true) {
            if (verify.isSafe(answer)) {
                if (answer.size() == length) {
                    break;
                }
                answer.push(input.get(0));
                continue;
            }
            while ((answer.size() > 0) && (answer.peek().equals(input.get(input.size() - 1)))) {
                answer.pop();
            }
            if (answer.size() == 0) {
                answer = null;
                break;
            }
            T last = answer.pop();
            T next = input.get(input.lastIndexOf(last) + 1);
            answer.push(next);
            continue;
        }
        return answer;
    }
}
