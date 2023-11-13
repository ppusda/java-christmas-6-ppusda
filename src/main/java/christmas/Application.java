package christmas;

public class Application {
    public static void main(String[] args) {
        PromotionProcessor promotionProcessor = new PromotionProcessor();
        promotionProcessor.getReservationController().setReservation();
        promotionProcessor.getOrderController().setOrder();
    }
}
