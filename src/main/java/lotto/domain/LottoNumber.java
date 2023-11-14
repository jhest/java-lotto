package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoNumber {

    private final List<Integer> lottoNumbers = new ArrayList<>();

    public LottoNumber(List<Integer> numbers) {
        for (int i = 0; i < 6; i++) {
            this.lottoNumbers.add(numbers.get(i));
        }
        Collections.sort(this.lottoNumbers);
    }

    public List<Integer> getLottoNumbers() {
        return lottoNumbers;
    }
}
