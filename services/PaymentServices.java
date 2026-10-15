package Parcelix.services;

public interface PaymentServices {
    double paymentFee(double amount);
    double interest(double amount, int months);
}
