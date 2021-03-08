package edu.yuwen.dp.behavior.strategy.discount;

/**
 * 3.策略模式（行为型）
 * 
 * 1.使用折扣策略工程的查表法去掉代码中的if-else判断
 *
 * Demo:商品对于不同的订单类型有不同的优惠策略
 */
public class OrderServiceDemo {
    // 策略的使用
    public double discount(Order order) {
        OrderType type = order.getType();
        DiscountStrategy discountStrategy = DiscountStrategyFactory.getDiscountStrategy(type);
        return discountStrategy.calDiscount(order);
    }
}
