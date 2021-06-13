package org.bankaccount.domain;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@AllArgsConstructor
@ToString(of = {"typeOperation", "amount", "date", "balance"})
@EqualsAndHashCode(of = {"typeOperation", "amount", "date", "balance"})
public class Operation {
    private TypeOperation typeOperation;
    private Integer amount;
    private String date;
    private Integer balance;
}
