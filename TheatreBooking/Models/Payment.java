enum payment_status{
	COMPLETED,
	PENDING;
}

public class Payment {
	//TO Implementation of Product, Offers, Voucher, PaymentMode
	int Id;
	int mode;
	payment_status ps;
	
	public Payment(int Id, int mode) {
		this.Id = Id;  //Auto gen
		this.mode = mode;
		this.ps = payment_status.PENDING;
	}
	
}
