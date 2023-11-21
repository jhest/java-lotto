package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Lotto {

    private final List<LottoNo> lottoNumber;

    public Lotto(List<LottoNo> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("로또 번호는 6개입니다.");
        }
        if (numbers.stream().distinct().count() < 6) {
            throw new IllegalArgumentException("중복된 번호는 입력할 수 없습니다.");
        }

        this.lottoNumber = numbers;
    }

    public Lotto() {
        lottoNumber = randomNumbers();
    }

    private List<LottoNo> randomNumbers() {
        List<LottoNo> numbers = new ArrayList<>();
        for (int i = 0; i < 45; i++) {
            LottoNo lottoNo = new LottoNo(i + 1);
            numbers.add(lottoNo);
        }

        Collections.shuffle(numbers);
        List<LottoNo> selectedNumbers = numbers.subList(0, 6);
        Collections.sort(selectedNumbers);

        return selectedNumbers;
    }

    public List<LottoNo> getLottoNumbers() {
        return lottoNumber;
    }

    public List<Integer> getLottoNos() {
        return lottoNumber.stream().map(LottoNo::getLottoNo).collect(Collectors.toList());
    }
}
