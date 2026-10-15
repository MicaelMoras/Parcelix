package Parcelix.application;

import Parcelix.Contract;
import Parcelix.Installment;
import Parcelix.services.ContractService;
import Parcelix.services.PaypalServices;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class Program {
    public static void main(String[] args)  throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner( System.in);

        System.out.println("Enter contract data");
        System.out.println("Number: ");
        Integer number = sc.nextInt();
        System.out.println("Date (dd/mm/yyyy) ");
        Date date = sdf.parse(sc.next());
        System.out.println("Contract value ");
        double totalValue = sc.nextDouble();

        Contract contract = new Contract(number, date, totalValue);
        System.out.println("Enter number of installments");
        int N = sc.nextInt();

        ContractService cs = new ContractService(new PaypalServices());

        cs.processContract(contract, N);

        System.out.println("Installments");

        for(Installment it : contract.getInstallments()){
            System.out.println(it);
        }

        sc.close();
    }
}
