package model.services;

public interface OnlinePaymentService {
	
	double paymentFee(Double amount);
	double interet(Double amount, Integer months);
}
