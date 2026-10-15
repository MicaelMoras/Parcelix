# Parcelix
 
Java app that splits a contract into monthly installments with interest and fees, using an interface to swap payment providers.
 
Built as a study project on **interfaces** and **decoupling** in Java (OOP).
 
## How it works
 
You enter a contract number, its date, its total value and the number of installments. The program generates one installment per month, each with its due date and final amount.
 
For each installment `i` (from 1 to N):
 
```
base quota    = total value / N
with interest = base quota + (base quota * 1% * i)
final amount  = with interest + (with interest * 2%)
due date      = contract date + i months
```
 
The 1% monthly interest and the 2% fee are the PayPal rules. They live in `PaypalServices`, not in the contract logic.
 
## Example
 
```
Enter contract data
Number: 8028
Date (dd/mm/yyyy): 25/06/2018
Contract value: 600.00
Enter number of installments: 3
Installments
25/07/2018 - 206.04
25/08/2018 - 208.08
25/09/2018 - 210.12
```
 
## Project structure
 
```
Parcelix
├── application
│   └── Program.java          # console entry point
├── services
│   ├── ContractService.java  # generates the installments
│   ├── PaymentServices.java  # interface: paymentFee() and interest()
│   └── PaypalServices.java   # PayPal implementation
├── Contract.java
└── Installment.java
```
 
## The design idea
 
`ContractService` never knows which payment provider is being used. It only depends on the `PaymentServices` interface:
 
```java
public interface PaymentServices {
    double paymentFee(double amount);
    double interest(double amount, int months);
}
```
 
To support another provider, create a new class that implements the interface and pass it to the service. `ContractService` stays untouched:
 
```java
ContractService cs = new ContractService(new PaypalServices());
```
 
## Running
 
1. Clone the repository.
2. Open it in IntelliJ IDEA.
3. Run `Program.java` and follow the prompts in the console.
Requires a JDK (Java 8 or higher).
 
## Author
 
**Micael Moras**
 
- GitHub: [github.com/MicaelMoras](https://github.com/MicaelMoras)
- LinkedIn: [linkedin.com/in/micael-moras-ab70b036b](https://www.linkedin.com/in/micael-moras-ab70b036b/)
