package christmas.enumeration

enum class InputPhrase(val text: String) {
    DATE("12월 중 식당 예상 방문 날짜는 언제인가요? (숫자만 입력해 주세요!)"),
    ERROR_DATE("[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요.");
}