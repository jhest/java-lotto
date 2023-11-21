package lotto.domain;

import java.util.List;
import java.util.function.Predicate;

public class Lotto {

    private final LottoNumber lottoNumber;
    private Rank rank;

    public Lotto(List<LottoNo> numbers) {
        lottoNumber = new LottoNumber(numbers);
    }

    public Lotto() {
        lottoNumber = new LottoNumber();
    }

    public LottoNumber getLottoNumbers() {
        return lottoNumber;
    }

    public void matchCount(Lotto winningNumbers, LottoNo bonusNumber) {
        int count = (int) lottoNumber.getLottoNos().stream()
                .filter(n -> winningNumbers.getLottoNumbers().getLottoNos().stream()
                        .anyMatch(Predicate.isEqual(n))).count();
        boolean bonusMatch = lottoNumber.getLottoNos().stream()
                .anyMatch(Predicate.isEqual(bonusNumber));
        this.rank = Rank.valueOf(count, bonusMatch);
    }

    public Rank getRank() {
        return rank;
    }
}
