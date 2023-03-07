# java-blackjack

블랙잭 미션 저장소

## 우아한테크코스 코드리뷰

- [온라인 코드 리뷰 과정](https://github.com/woowacourse/woowacourse-docs/blob/master/maincourse/README.md)

---
## 1단계 미션 기능 요구사항
### 도메인 로직
- [x] 블랙잭 게임은 딜러와 플레이어 중 카드의 합이 21 또는 21에 가장 가까운 숫자를 가지는 쪽이 이기는 게임이다.
  - [x] 카드의 합은 카드 숫자를 기준으로 더한다.
    - [x] Ace는 1또는 11로 계산할 수 있다.
    - [x] King,Queen,Jack은 각각 10으로 계산한다.
    - [x] 나머지 카드는 카드 숫자를 기준으로 계산한다.
  - [x] 딜러와 플레이어는 카드를 지급 받을 수 있다.
    - [x] 게임을 시작하면 딜러와 플레이어는 두 장의 카드를 지급 받는다.
    - [x] 플레이어는 카드의 합이 21을 초과한다면 카드를 지급 받을 수 없다.
    - [x] 플레이어와 딜러가 A를 가지고 있을 때 플레이어의 점수 합이 11을 초과하면 A는 1점으로 간주한다.
    - [x] 플레이어와 딜러가 A를 가지고 있을 때 플레이어의 점수 합이 11 이하면 A는 11점으로 간주한다.
    - [x] 플레이어의 수는 1~6 사이여야 한다.
    - [x] 플레이어의 이름은 양 끝 공백을 포함하지 않는다.
    - [x] 동일한 플레이어 이름이 입력된 경우 에러를 발생시킨다.
    - [x] 딜러는 카드의 합이 16을 초과한다면 카드를 지급 받을 수 없다.
    - [x] 딜러는 처음에 받은 2장의 합계가 16이하이면 반드시 1장의 카드를 추가로 받아야 한다.
  - [x] 게임이 끝나고 딜러와 각 플레이어의 승패를 구할 수 있다.

### 입력
- [x] 플레이어의 이름을 입력받는다.
  - [x] 플레이어의 이름은 쉼표를 기준으로 구분된다.
- [x] 플레이어는 카드를 더 받을 지 선택할 수 있다.
  - [x] 더 지급받으려면 y, 멈추고 싶다면 n을 입력한다.
  - [x] 그 외의 입력을 받으면 예외 메세지를 던지고 재입력을 받는다.

### 출력
- [x] 딜러와 플레이어가 각자 보유한 카드를 출력할 수 있다.
- [x] 딜러는 추가로 카드를 받았는 지에 대한 메세지를 출력할 수 있다.
- [x] 게임이 끝난 뒤 딜러와 각 플레이어가 보유한 카드와 카드의 합을 출력할 수 있다.
- [x] 게임의 최종 승패를 출력할 수 있다.
