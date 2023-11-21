package lotto.domain;

import java.util.function.Predicate;

public class WinningLotto {

    private final Lotto winningLotto;
    private final LottoNo bonusNumber;

    public WinningLotto(Lotto winningNumbers, LottoNo bonusNumber) {
        if (isDuplicated(winningNumbers, bonusNumber)) {
            throw new IllegalArgumentException("당첨번호와 중복된 번호는 입력할 수 없습니다.");
        }
        this.winningLotto = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    private boolean isDuplicated(Lotto winningNumbers, LottoNo bonusNumber) {
        return winningNumbers.getLottoNumbers().stream().anyMatch(n -> n.equals(bonusNumber));
    }

    public Rank matchRank(Lotto lotto) {
        int count = (int) lotto.getLottoNumbers().stream()
                .filter(n -> winningLotto.getLottoNumbers().stream()
                        .anyMatch(Predicate.isEqual(n))).count();

        boolean bonusMatch = lotto.getLottoNumbers().stream()
                .anyMatch(Predicate.isEqual(bonusNumber));

        return Rank.valueOf(count, bonusMatch);
    }
}
