package pwo.seq;

import java.math.BigDecimal;

public class FibonacciGenerator extends Generator {
    private static final BigDecimal F1 = new BigDecimal(0);
    private static final BigDecimal F2 = new BigDecimal(1);

    BigDecimal getFirstItem() {
        return F1;
    }

    BigDecimal getSecondItem() {
        return F2;
    }

    public FibonacciGenerator() {
        reset();
    }

    @Override
    public void reset() {
        super.reset();
    }

    @Override
    public BigDecimal nextTerm() {
        switch (lastIndex) {
            case 0:
                current = getSecondItem();
                prev = getFirstItem();
                break;
            case 1:
                current = getFirstItem().add(getSecondItem());
                prev = getSecondItem();
                break;
            default:
                BigDecimal temp = current;
                current = current.add(prev);
                prev = temp;
                break;
        }

        lastIndex++;

        return current;
    }

    @Override
    public BigDecimal prevTerm() {
        switch (lastIndex) {
            case 0:
                throw new IllegalStateException();
            case 1:
                current = getFirstItem();
                prev = null;
                break;
            default:
                BigDecimal temp = current;
                current = prev;
                prev = temp.subtract(prev);
                break;
        }

        lastIndex--;

        return current;
    }

    public static void main(String[] args) {
        FibonacciGenerator gen = new FibonacciGenerator();
        for (int i = 0; i < 10; i++) {
            System.out.println(gen.nextTerm().toString());
        }
        for (int i = 10; i >= 1; i--) {
            System.out.println(gen.prevTerm().toString());
        }
    }
}
