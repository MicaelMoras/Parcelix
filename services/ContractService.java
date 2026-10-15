package Parcelix.services;

import Parcelix.Contract;
import Parcelix.Installment;

import java.util.Calendar;
import java.util.Date;

public class ContractService {
    private PaymentServices paymentServices;

    public ContractService(PaymentServices paymentServices ){
        this.paymentServices = paymentServices;
    }
    public void processContract(Contract contract, int months){
        double basicQuota = contract.getTotalValue() / months;
        for(int i =1; i <= months; i++){
               double updatedQuota = basicQuota + paymentServices.interest(basicQuota,i);
               double fullQuota= updatedQuota + paymentServices.paymentFee(updatedQuota);
               Date dueDate = addMonths(contract.getDate(), i);
               contract.getInstallments().add(new Installment(dueDate, fullQuota));
        }
    }
    private Date addMonths(Date data, int N){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(data);
        calendar.add(Calendar.MONTH, N);
        return calendar.getTime();
    }
}
