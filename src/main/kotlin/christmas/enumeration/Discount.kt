package christmas.enumeration

enum class Discount(val price: Int) {
    START_DISCOUNT(1000),
    PER_DAY_DISCOUNT(100),
    NO_DISCOUNT(0),
    SPECIAL_DISCOUNT(1000),
    ENABLE_DISCOUNT_STANDARD(10_000),
    PRESENT_STANDARD(120_000),
    PRESENT_DISCOUNT(25_000);
}