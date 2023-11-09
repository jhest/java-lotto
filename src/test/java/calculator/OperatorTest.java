package calculator;


import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class OperatorTest {

    @Test
    void 사칙연산_덧셈() {
        Operator operator = new Operator();
        int result = operator.add("1", "2");
        assertThat(result).isEqualTo(3);
    }

    @Test
    void 사칙연산_뺄셈() {
        Operator operator = new Operator();
        int result = operator.sub("3", "1");
        assertThat(result).isEqualTo(2);
    }

    @Test
    void 사칙연산_곱셈() {
        Operator operator = new Operator();
        int result = operator.mul("1", "2");
        assertThat(result).isEqualTo(2);
    }

    @Test
    void 사칙연산_나눗셈() {
        Operator operator = new Operator();
        int result = operator.div("4", "2");
        assertThat(result).isEqualTo(2);
    }

    @Test
    void 사칙연산() {
        String[] number = {"2", "3", "4", "2"};
        Integer result = Integer.parseInt(number[0]);
        String[] basicOperator = {"+", "*", "/"};
        Operator operator = new Operator();

        for (int i = 0; i < basicOperator.length; i++) {
            result = operator.operation(basicOperator[i], String.valueOf(result), number[i + 1]);
        }

        assertThat(result).isEqualTo(10);
    }
}