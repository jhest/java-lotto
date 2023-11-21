package lotto.domain;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class LottoNumber {

    private final List<LottoNo> numbers;

    public LottoNumber(List<LottoNo> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("로또 번호는 6개입니다.");
        }
        if (numbers.size() != numbers.stream().distinct().count()) {
            throw new IllegalArgumentException("같은 번호는 입력할 수 없습니다.");
        }

        this.numbers = numbers;
    }

    public LottoNumber() {
        this.numbers = randomNumbers();
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

    public List<LottoNo> getLottoNos() {
        return numbers;
    }

    public List<Integer> getNumbers() {
        return numbers.stream()
                .map(LottoNo::getLottoNo)
                .collect(Collectors.toList());
    }
}
