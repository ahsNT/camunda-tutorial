package org.camunda.bpm.getstarted.loanapproval.delegate;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Component;

@Component
public class RenewPlayerContractsDelegate implements JavaDelegate {

    @Override
    public void execute(DelegateExecution execution) throws Exception {
        System.out.println("RenewPlayerContractsDelegate: " + execution.getCurrentActivityName());

        Long goalkeeper = (Long) execution.getVariable("goalkeeper_salary");
        Long defense = (Long) execution.getVariable("defense_salary");
        Long midfield = (Long) execution.getVariable("midfield_salary");
        Long forward = (Long) execution.getVariable("forward_salary");

        String club = (String) execution.getVariable("club_name");

        execution.setVariable("contractRenegotationRequired", (goalkeeper + defense + midfield + forward) >= 2000);
    }
}
