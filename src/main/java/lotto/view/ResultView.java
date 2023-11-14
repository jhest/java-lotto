package lotto.view;

import lotto.domain.Lotto;

import java.util.List;

public class ResultView {

    public void issuedTicket(List<Lotto> lotteries) {
        for (Lotto lotto : lotteries) {
            System.out.println(lotto.selectedNumber().getLottoNumbers());
        }
    }

    public void finalResult(List<Long> result, float rate) {
        System.out.println("당첨 통계");
        System.out.println("---------");
        System.out.println("3개 일치 (5000원)- " + result.get(4) + "개");
        System.out.println("4개 일치 (50000원)- " + result.get(3) + "개");
        System.out.println("5개 일치 (1500000원)- " + result.get(2) + "개");
        System.out.println("5개 일치, 보너스 볼 일치(30000000원)- " + result.get(1) + "개");
        System.out.println("6개 일치 (2000000000원)- " + result.get(0) + "개");
        System.out.println("총 수익률은 " + rate + "입니다.");
    }
}