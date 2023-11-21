package lotto.domain;

import java.util.Objects;

public class LottoNo implements Comparable<LottoNo> {

    private final int LottoNo;

    public LottoNo(int lottoNo) {
        if (lottoNo < 1 || lottoNo > 45) {
            throw new IllegalArgumentException("1 ~ 45 사이 정수만 가능합니다.");
        }
        LottoNo = lottoNo;
    }

    public int getLottoNo() {
        return LottoNo;
    }

    @Override
    public int compareTo(lotto.domain.LottoNo o) {
        return Integer.compare(LottoNo, o.getLottoNo());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoNo lottoNo = (LottoNo) o;
        return LottoNo == lottoNo.LottoNo;
    }

    @Override
    public int hashCode() {
        return Objects.hash(LottoNo);
    }
}
