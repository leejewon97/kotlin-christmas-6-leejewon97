package christmas.enumeration

enum class Order(val index: Int) {
    MENU(0),
    QUANTITY(1);

    enum class Quantity(val value: Int) {
        MIN(1),
        MAX(20);
    }
}