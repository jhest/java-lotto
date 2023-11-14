package lotto;

import lotto.domain.*;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;


class LotteryCenterTest {

    @Test
    void 로또_구매_숫자_계산() {
        int cash = 14000;
        int number = new LotteryCenter().issuedNumber(cash);
        assertThat(number).isEqualTo(14);
    }

    @Test
    void 자동_로또_번호_생성() {
        int issuedNumber = 1;
        List<Lottery> issuedTicket = new LotteryCenter().generateTicket(issuedNumber);
        Lottery lottery = issuedTicket.get(0);
        LottoNumber number = lottery.selectedNumber();
        assertThat(number.getLottoNumbers().size()).isEqualTo(6);
    }
    @Test
    void 당첨_여부_확인_보너스() {
        Lottery lottery = new Lottery(new LottoNumber(Arrays.asList(1, 2, 3, 4, 5, 7)));
        List<Lottery> lotteries = List.of(lottery);
        List<Integer> winning = Arrays.asList(1, 2, 3, 4, 5, 6);
        int bonus = 7;

        List<Lottery> checkedLotteries = new LotteryCenter().checkWinningNumber(lotteries, winning, bonus);
        assertThat(checkedLotteries.get(0).getRank()).isEqualTo(Rank.SECOND);
    }

    @Test
    void 통계_추출() {
        Lottery lottery_second = new Lottery(new LottoNumber(Arrays.asList(1, 2, 3, 4, 5, 7)));
        Lottery lottery_fourth = new Lottery(new LottoNumber(Arrays.asList(1, 2, 3, 4, 7, 8)));
        Lottery lottery_fifth = new Lottery(new LottoNumber(Arrays.asList(1, 2, 3, 7, 8, 9)));
        List<Lottery> lotteries = Arrays.asList(lottery_fifth, lottery_fourth, lottery_second);

        List<Integer> winning = Arrays.asList(1, 2, 3, 4, 5, 6);
        int bonus = 7;
        new LotteryCenter().checkWinningNumber(lotteries, winning, bonus);

        WinningResult winningResult = new LotteryCenter().calcStat(lotteries);
        long[] result = winningResult.getResult();
        assertThat(result[1]).isEqualTo(1); //2nd
        assertThat(result[3]).isEqualTo(1); //4th
        assertThat(result[4]).isEqualTo(1); //5th
    }
}