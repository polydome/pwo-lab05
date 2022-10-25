package pwo.seq;

import pwo.utils.SequenceGenerator;

import java.math.BigDecimal;

abstract class Generator implements SequenceGenerator {
    protected int lastIndex = 0;
    protected BigDecimal
            current = null,
            prev = null;

    @Override
    public void reset() {
        lastIndex = 0;
    }

    @Override
    public final BigDecimal getTerm(int i) {
        if (i < 0) throw new IllegalArgumentException();
        while (i < lastIndex) prevTerm();
        while (lastIndex <= i) nextTerm();
        return current;
    }
}
