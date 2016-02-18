import java.util.HashMap;
import java.util.Map;

public class Polynomial {

    private Map<Integer, Integer> coefficients;

    public Polynomial(Map<Integer, Integer> coefficients) {
        this.coefficients = coefficients;
    }

    public int eval(int x) {
        int highestPower = 0;
        for (Integer power: coefficients.keySet()) {
            highestPower = Math.max(highestPower, power);
        }

        int val = 0;
        for (int i = highestPower; i > 0; i--) {
            val += coefficients.containsKey(i) ? coefficients.get(i) : 0;
            //have a coefficient attached to this power = add it on, if not = default to zero
            val *= x;
        }
        val += coefficients.containsKey(0) ? coefficients.get(0) : 0;
        return val;
    }

    public static void main(String[] args) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>() {{
            put(5, 7);
            put(2, 4);
            put(8, 11);
            put(34, 5);

            // put(3, 6);
            // put(2, 4);
            // put(1, 5);
            // put(0, 3);
        }};
        Polynomial p = new Polynomial(map);
        System.out.println(p.eval(9));
    }
}
