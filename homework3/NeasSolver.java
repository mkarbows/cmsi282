import java.util.ArrayList;

public class NeasSolver {
    public static void main (String[] args) {
        SafeChecker<Integer> c = answer -> {
            String answerStr = "";
            for (int m = 0; m < answer.size(); m++) {
                answerStr += answer.get(m);
            }
            for (int j = answer.size() - 2; j >= Math.ceil((double)answer.size()/2.0); j--) {
                if (answerStr.substring(j).equals(answerStr.substring(j - (answer.size() - j), j))) {
                    return false;
                }
            }
            return true;
        };
        ArrayList<Integer> input = new ArrayList<Integer>();
        int strLength = 5;
        for (int i = 0; i <= 2; i++) {
            input.add(i);
        }
        BacktrackingEngine<Integer> engine = new BacktrackingEngine<Integer>(input, c);
        ArrayList<Integer> last = engine.solve(strLength);
        System.out.println("here: " + last);
    }
}
