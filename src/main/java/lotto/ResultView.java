package lotto;

import java.util.List;

public class ResultView {

    public void issuedTicket(List<Lottery> lotteries) {
        for (Lottery lottery : lotteries) {
            System.out.println(lottery.selectedNumber());
        }
    }

    public void finalResult(List<String> result) {
        System.out.println("당첨 통계");
        System.out.println("---------");
        System.out.println("3개 일치 (5000원)- " + result.get(0) + "개");
        System.out.println("4개 일치 (50000원)- " + result.get(1) + "개");
        System.out.println("5개 일치 (1500000원)- " + result.get(2) + "개");
        System.out.println("6개 일치 (2000000000원)- " + result.get(3) + "개");
        System.out.println("총 수익률은 " + result.get(4) + "입니다.(기준이 1이기 때문에 결과적으로 손해라는 의미임)");
    }
}
