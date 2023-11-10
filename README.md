# 로또

## 1단계 요구사항
* [X] 공백 문자열로 사용자가 입력 문자열을 구분한다
* [X] 입력 값이 null이거나 빈 공백일 경우 IllegalArgumentException을 발생시킨다
* [X] 입력 값의 숫자와 사칙연산 기호를 구분한다
* [X] 사칙 연산 기호가 아닐 경우 IllegalArgumentException을 발생시킨다
* [X] 덧셈, 뺄셈, 곱셈, 나눗셈의 사칙 연산 기능을 구현한다
  * 나눗셈은 결과 값을 정수로 나타낸다
* [X] 사칙연산은 입력 순서로 계산한다

## 2단계 요구사항
* [X] 구입 금액에 맞는 로또 번호를 생성한다 -> LotteryCenter, Lottery
* [X] 구입 금액을 입력하면 몇 장을 구매했는 지 알려준다 -> InputView
* [X] 생성된 로또 번호를 표시한다 -> ResultView
* [X] 지난 주 당첨 번호를 입력 받는다 -> InputView
* [X] 당첨 통계를 구한다 -> LotteryCenter
* [X] 당첨 통계 및 결과를 표시한다 -> ResultView