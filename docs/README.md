## Model

1. `Appetizers`, `MainDishes`,`Desserts`,`Drink` Enum Class -> `Category`별 음식 정보 저장

2. `Menu` Class - 메뉴 정보를 담고 있는 Enum Class -> `Appetizer`, `MainDishes`, `Dessert`, `Drink`

3. `Order` Class - 주문을 담기 위한 Class -> `HashMap<String,Integer>` -> 음식 이름, 음식 수량

4. `OrderList` Class - 주문의 목록을 담기 위한 Class -> `List<Order>`

5. `Price Class` -> 가격 정보를 담기 위한 Class -> `TotalPrice`, `DiscountPrice`, `TotalPriceAfterDiscount`

6. `OrderInfo` Class -> 주문 관련 정보를 담기 위한 Class -> `OrderList`, `Price`

7. `Event` Class -> 이벤트 별 할인 정보를 담기 위한 Class -> `ChristMasDday`, `WeekDay`, `WeekendDay`, `FreeGift`
8. `Reservation` Class -> 사용자의 예약 날짜를 저장하기 위한 Class -> `Integer` 

## Parser
사용자의 입력을 처리하기 위한 Class

1. `ParserOrderList` -> 사용자가 입력한 주문 리스트들 `OrderList`를 만들기 위한 Parser -> `ValidatorOfOrderList` 필요 -> 메누가 존재하는지, 형식이 잘못되어 있는지 파악 -> `Exception` 필요 -> `Constannt` EnumClass
2. `ParserReservation ` -> 사용자가 입력한 날짜를 `Reservation`의 객체로 생성하기 위한 Parser -> `ValdatorOfDate`필요 -> 숫자인지, 범위 밖에 있는지,

## Controller

1. `PrintHelloMessages` -> 초기 메세지 출력  -> `OutputView`와 연계
2. `PrintRequestReservationDate`-> 예약 방문 날짜를 받기 위한 `OutputView` & `InputView` 연계
3. `PrintRequestOrder` -> 사용자의 메뉴를 입력받기 위한 `OutputView` & `InputView` 얀계
4. `PrintSelectedMessage` -> 사용자가 입력한 음식 출력 -> `View`와 `OrderList` 연계
5. `PrintTotalPriceBeforeDiscount` -> 할인전 총 주문 금액 출력 -> `OrderInfo` & `View`연계
6. `PrintFreeGift` -> 증정 메뉴 출력
7. `PrintDiscountInfo` -> 혜택 내역 출력 <- 증점품 포함 ex) 샴페인
8. `PrintDiscountPrice` -> 총 혜택 내역 출력 
9. `PrintTotalPriceAfterDiscount` -> 할인 후 총 금액 출력
10. `PrintEventBadge` -> 이벤트 뱃지 출력

## View
Controller 흐름에 맞게 설계 예정