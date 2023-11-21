package lotto.view;

import lotto.domain.Cash;
import lotto.domain.Lotto;
import lotto.domain.LottoCenter;
import lotto.domain.LottoNo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {

    public List<Lotto> buyTicket() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("구입금액을 입력해 주세요.");
        Cash cash = new Cash(scanner.nextInt());

        LottoCenter lottoCenter = new LottoCenter();
        System.out.println("수동으로 구매할 로또 수를 입력해 주세요.");
        int manualCount = scanner.nextInt();
        lottoCenter.manualBuyValidCheck(cash, manualCount);

        List<Lotto> manualNumbers = getManualNumbers(manualCount);
        List<Lotto> lottos = lottoCenter.manualBuyLotto(cash, manualNumbers);
        System.out.println("수동으로 " + manualCount + "장, 자동으로 " + (lottos.size() - manualCount) + "개를 구매했습니다.");

        return lottos;
    }

    private static List<Lotto> getManualNumbers(int manualCount) {
        List<Lotto> manualNumbers = new ArrayList<>();
        Scanner numbers = new Scanner(System.in);

        System.out.println("수동으로 구매할 번호를 입력해 주세요.");
        for (int i = 0; i < manualCount; i++) {
            List<LottoNo> lottoNos = getLottoNos(numbers);
            Lotto lotto = new Lotto(lottoNos);
            manualNumbers.add(lotto);
        }
        return manualNumbers;
    }

    private static List<LottoNo> getLottoNos(Scanner scanner) {
        String input = scanner.nextLine();
        numberInputValidCheck(input);
        String[] split = input.replaceAll("\\s", "").split(",");

        return Arrays.stream(split)
                .map(Integer::parseInt)
                .map(LottoNo::new)
                .collect(Collectors.toList());
    }

    public Lotto winningNumberInput() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");

        List<LottoNo> winningNumbers = getLottoNos(scanner);
        return new Lotto(winningNumbers);
    }

    private static void numberInputValidCheck(String input) {
        if (input.isBlank() || input.isEmpty()) {
            throw new IllegalArgumentException("6개 숫자를 입력해주세요.");
        }
    }

    public int bonusNumberInput() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("보너스 볼을 입력해 주세요.");

        return scanner.nextInt();
    }
}
