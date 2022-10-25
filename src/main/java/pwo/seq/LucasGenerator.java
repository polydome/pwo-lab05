package pwo.seq;

import java.math.BigDecimal;

public class LucasGenerator extends FibonacciGenerator {
    private static final BigDecimal F1 = new BigDecimal(2);
    private static final BigDecimal F2 = new BigDecimal(1);

    @Override
    BigDecimal getFirstItem() {
        return F1;
    }

    @Override
    BigDecimal getSecondItem() {
        return F2;
    }
}
