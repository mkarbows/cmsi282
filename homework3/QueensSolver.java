import java.util.ArrayList;

public class QueensSolver {
    public static void main (String[] args) {
        SafeChecker<Integer> c = answer -> {
            for (int j = 0; j < answer.size() - 1; j++) {
                for (int k = j + 1; k < answer.size() ; k++) {
                    if (answer.get(j).equals(answer.get(k))) {
                        return false;
                    }
                    int currentDiff = Math.abs(j - answer.get(j));
                    int otherDiff = Math.abs(k - answer.get(k));
                    if (currentDiff == otherDiff) {
                        return false;
                    }
                }
            }
            return true;
        };
        ArrayList<Integer> input = new ArrayList<Integer>();
        int amtOfQueens = 8;
        for (int i = 0; i < amtOfQueens; i++) {
            input.add(i);
        }
        BacktrackingEngine<Integer> engine = new BacktrackingEngine<Integer>(input, c);
        ArrayList<Integer> last = engine.solve(amtOfQueens);
        System.out.println("here: " + last);
    }
}
