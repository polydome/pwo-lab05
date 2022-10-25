package pwo.utils;

import java.math.BigDecimal;

public interface SequenceGenerator {
    void reset();
    BigDecimal nextTerm();

    BigDecimal prevTerm();
    BigDecimal getTerm(int i);
}
