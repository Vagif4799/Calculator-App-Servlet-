package calculatorApp;

public class CalculatorImpl {
    static int do_op(int op1, int op2, String ops) {
        int result = 0;
        switch (ops) {
            case "Addition" : result = op1 + op2; break;
            case "Subtraction": result = op1 - op2; break;
            case "multiplication" : result = op1 * op2; break;
            case "division"  : result = op1 / op2; break;
        }
        return result;
    }
}
