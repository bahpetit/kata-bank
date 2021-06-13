package org.bankaccount.domain;

import lombok.*;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Getter
public class Statement {

    private Integer balance = 0;
    private List<Operation> operations = new ArrayList<>();

    public Statement(Integer balance, Operation operation) {
        this.balance = balance;
        this.operations.add(operation);
    }

    public void deposit(Integer amount) {
        this.balance += amount;
    }

    public void withdraw(Integer withdraw) {
        this.balance -= withdraw;
    }

    public void addOperation(TypeOperation typeOperation, Integer amount, String date) {
        if(typeOperation.toString().equals("Deposit")){
            this.balance += amount;
        }else {
            this.balance -= amount;
        }
        this.operations.add(new Operation(typeOperation, amount, date, this.balance));
    }
}
