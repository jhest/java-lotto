package lotto.view;

import lotto.domain.Lottery;

import java.util.List;

public class ResultView {

    public void issuedTicket(List<Lottery> lotteries) {
        for (Lottery lottery : lotteries) {
            System.out.println(lottery.selectedNumber().getLottoNumbers());
        }
    }

    public void finalResult(long[] result, float rate) {
        System.out.println("당첨 통계");
        System.out.println("---------");
        System.out.println("3개 일치 (5000원)- " + result[4] + "개");
        System.out.println("4개 일치 (50000원)- " + result[3] + "개");
        System.out.println("5개 일치 (1500000원)- " + result[2] + "개");
        System.out.println("5개 일치, 보너스 볼 일치(30000000원)- " + result[1] + "개");
        System.out.println("6개 일치 (2000000000원)- " + result[0] + "개");
        System.out.println("총 수익률은 " + rate + "입니다.");
    }
}
