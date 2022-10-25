package pwo.seq;

import java.math.BigDecimal;

public class TribonacciGenerator extends FibonacciGenerator {
    private static final BigDecimal F3 = new BigDecimal(1);
    private BigDecimal prevPrev;

    public TribonacciGenerator() {
        prevPrev = new BigDecimal(0);
    }

    private BigDecimal getThirdItem() {
        return F3;
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
            case 2:
                current = getFirstItem().add(getSecondItem()).add(getThirdItem());
                prev = getSecondItem();
                prevPrev = getFirstItem();
                break;
            default:
                BigDecimal temp = current;
                current = current.add(prev).add(prevPrev);
                prevPrev = prev;
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
            case 2:
                current = getSecondItem();
                prev = getFirstItem();
            default:
                BigDecimal temp = current;
                BigDecimal prevTemp = prev;
                current = prev;
                prev = prevPrev;
                prevPrev = temp.subtract(prevTemp);
                break;
        }

        lastIndex--;

        return current;
    }
}
