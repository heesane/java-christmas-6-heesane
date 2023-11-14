package christmas.service;

import christmas.factory.ComponentFactory;
import christmas.model.*;
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
        assertThat(orderList.orderList().toString()).isEqualTo("[타파스 1개, 제로콜라 1개]");
    }

    @Test
    @DisplayName("이벤트 객체 생성 테스트")
    void makeEvent() {
        //given
        Reservation reservation = new Reservation(3);
        //when
        Event event = christmasService.makeEvent(reservation);
        //then
        assertThat(event.isChristmasDday()).isTrue();
    }

    @Test
    @DisplayName("금액 객체 생성 테스트")
    void makePrice() {
        //given
        String orderString = "타파스-1,제로콜라-1";
        String date = "3";
        Reservation reservation = christmasService.makeReservation(date);
        OrderList orderList = christmasService.makeOrderList(orderString);
        Event event = christmasService.makeEvent(reservation);
        //when
        Price price = christmasService.makePrice(orderList, event);
        //then
        assertThat(price.totalPrice()).isEqualTo(8500);
        assertThat(8500).
                isEqualTo(price.totalPrice() - price.benefits().getTotalBenefits()+price.benefits().getFreeGiftBenefits());
        assertThat(price.benefits().getChristmasBenefits()).isEqualTo(0);
        assertThat(price.benefits().getWeekBenefits()).isEqualTo(0);
        assertThat(price.benefits().getWeekendBenefits()).isEqualTo(0);
        assertThat(price.benefits().getSpecialBenefits()).isEqualTo(0);
        assertThat(price.benefits().getFreeGiftBenefits()).isEqualTo(0);
    }

    @Test
    @DisplayName("영수증 객체 테스트")
    void makeBill() {
        //given
        String orderString = "타파스-1,제로콜라-1";
        String date = "3";
        Reservation reservation = christmasService.makeReservation(date);
        OrderList orderList = christmasService.makeOrderList(orderString);
        Event event = christmasService.makeEvent(reservation);
        Price price = christmasService.makePrice(orderList, event);
        //when
        Bill bill = christmasService.makeBill(orderList, price);
        //then
        assertThat(bill.orderList().toString()).isEqualTo("타파스 1개\n제로콜라 1개\n");
        assertThat(bill.price().totalPrice()).isEqualTo(8500);
    }
}