abstract class IntBinaryOperation {

    protected int firstArg;
    protected int secondArg;

    public IntBinaryOperation(int firstArg, int secondArg) {
        this.firstArg = firstArg;
        this.secondArg = secondArg;
    }

    public abstract int perform();
}

class Addition extends IntBinaryOperation {

    public Addition(int _arg1, int _arg2) {
        super(_arg1, _arg2);
    }

    public int perform() {
        return firstArg + secondArg;
    }

}

class Multiplication extends IntBinaryOperation {
    public Multiplication(int _arg1, int _arg2) {
        super(_arg1, _arg2);
    }

    public int perform() {
        return firstArg * secondArg;
    }
}