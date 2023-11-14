package christmas.service;

import christmas.factory.ComponentFactory;
import christmas.model.OrderList;
import christmas.model.Reservation;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
@DisplayName("객체 생성 테스트")
class ChristmasServiceTest {
    ChristmasService christmasService = ComponentFactory.getInstance().christmasService();
    @Test
    @DisplayName("예약 객체 생성 테스트")
    void makeReservation() {
        //given
        String date = "3";
        //when
        Reservation reservation = christmasService.makeReservation(date);
        //then
        assertThat(reservation.reservationDay()).isEqualTo(3);
    }
    @Test
    @DisplayName("주문 내역 객체 생성 테스트")
    void makeOrderList() {
        //given
        String orderString = "타파스-1,제로콜라-1";
        //when
        OrderList orderList = christmasService.makeOrderList(orderString);
        //then
        assertThat(orderList.orderList().size()).isEqualTo(2);
        assertThat(orderList.orderList().get(0).getMenuName()).isEqualTo("타파스");
        assertThat(orderList.orderList().toString()).isEqualTo("타파스 1개\n제로콜라 1개\n");
    }

    @Test
    @DisplayName("이벤트 객체 생성 테스트")
    void makeEvent() {
    }

    @Test
    @DisplayName("금액 객체 생성 테스트")
    void makePrice() {
    }

    @Test
    @DisplayName("예약 일정 객체 생성 테스트")
    void makeBill() {
    }
}