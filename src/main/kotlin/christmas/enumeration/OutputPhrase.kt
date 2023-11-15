package christmas.enumeration

enum class OutputPhrase(val text: String) {
    HI("안녕하세요! 우테코 식당 12월 이벤트 플래너입니다."),
    EVENT_PREVIEW("12월 26일에 우테코 식당에서 받을 이벤트 혜택 미리 보기!"),
    ORDERED_MENU("\n<주문 메뉴>"),
    BEFORE_DISCOUNT_TOTAL_PRICE("\n<할인 전 총주문 금액>"),
    PRESENT_MENU("\n<증정 메뉴>"),
    DISCOUNT_LIST("\n<혜택 내역>"),
    TOTAL_DISCOUNT_PRICE("\n<총혜택 금액>"),
    AFTER_DISCOUNT_TOTAL_PRICE("\n<할인 후 예상 결제 금액>"),
    DECEMBER_EVENT_BADGE("\n<12월 이벤트 배지>"),
    MENU_UNIT("개"),
    PRICE_UNIT("원"),
    CHAMPAGNE("샴페인 1개"),
    NOTHING("없음");

    enum class Badge(val text: String) {
        FIVE_THOUSAND("별"),
        TEN_THOUSAND("트리"),
        TWENTY_THOUSAND("산타");
    }
}