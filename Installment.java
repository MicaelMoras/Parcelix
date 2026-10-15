package Parcelix;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Installment {

   private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    private Date duedate;
    private double amount;

    public Installment(){

    }

    public Installment(Date duedate, double amount) {
        super();
        this.duedate = duedate;
        this.amount = amount;
    }

    public Date getDuedate() {
        return duedate;
    }

    public void setDuedate(Date duedate) {
        this.duedate = duedate;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return sdf.format(duedate) +
                " - " + String.format("%.2f" , amount);
    }
}


