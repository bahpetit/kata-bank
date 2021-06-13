package org.bankaccount.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;

import static org.bankaccount.domain.TypeOperation.Deposit;
import static org.bankaccount.domain.TypeOperation.Withdraw;


@NoArgsConstructor
@Getter
public class Account {

    private Statement statement = new Statement();

    public void deposit(Integer amount) {
        this.statement.deposit(amount);
    }

    public Statement getStatement() {
        return this.statement;
    }

    public void withdraw(Integer amount) {
        this.statement.withdraw(amount);
    }

    public void deposit(Integer amount, String date) {
        this.statement.addOperation(Deposit, amount, date);
    }

    public void withdraw(Integer amount, String date) {
        this.statement.addOperation(Withdraw, amount, date);
    }

    public Statement getStatements() {
        return this.statement;
    }
}
