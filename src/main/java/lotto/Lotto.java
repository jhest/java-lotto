package lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lotto {

    private final List<Integer> lottoNumber;

    public Lotto() {
        lottoNumber = randomNumbers().subList(0, 6);
        Collections.sort(lottoNumber);
    }

    private static List<Integer> randomNumbers() {
        List<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < 46; i++) {
            numbers.add(i + 1);
        }
        Collections.shuffle(numbers);
        return numbers;
    }

    public List<Integer> selectedNumber() {
        return lottoNumber;
    }
}