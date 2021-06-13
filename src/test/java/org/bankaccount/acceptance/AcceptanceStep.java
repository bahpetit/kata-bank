package org.bankaccount.acceptance;

import io.cucumber.java.PendingException;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.bankaccount.domain.Account;
import org.bankaccount.domain.Operation;
import org.bankaccount.domain.Statement;
import org.bankaccount.domain.TypeOperation;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class AcceptanceStep {

    private Account account = new Account();
    private Statement statement;
    private List<Operation> operations;


    @Given("I deposit {int} euros")
    public void i_deposit_euros(Integer amount) {
        account.deposit(amount);
    }

    @Given("I deposit {int} euros on {string}")
    public void i_deposit_euros_on(Integer amount, String date) {
        account.deposit(amount, date);
    }

    @Given("I withdraw {int} euros on {string}")
    public void i_withdraw_euros_on(Integer amount, String date) {
        account.withdraw(amount, date);
    }

    @When("I withdraw {int} euros")
    public void i_withdraw_euros(Integer amount) {
        account.withdraw(amount);
    }

    @When("I ask the statement")
    public void i_ask_the_statement() {
        statement = account.getStatement();
    }

    @Then("My balance should be {int}")
    public void my_balance_should_be(Integer balance) {
        assertEquals(balance, statement.getBalance());
    }

    
    @When("I see the history of my operations")
    public void i_see_the_history_of_my_operations() {
        statement = account.getStatement();
       this.operations = statement.getOperations();
    }
    
    @Then("The history should be")
    public void the_history_should_be(io.cucumber.datatable.DataTable dataTable) {
        System.out.println(statement);
        List<Map<String, String>> rows =  dataTable.asMaps(String.class, String.class);
        List<Operation> operationsStore = new ArrayList<>();
        for (Map<String, String> columns : rows) {
            Operation operation = new Operation(TypeOperation.valueOf(columns.get("operation")), Integer.parseInt(columns.get("amount")), columns.get("date"), Integer.parseInt(columns.get("balance")));
            operationsStore.add(operation);
        }
        assertEquals(operationsStore, this.operations);
    }
}
