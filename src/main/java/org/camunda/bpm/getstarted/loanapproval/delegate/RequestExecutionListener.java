package org.camunda.bpm.getstarted.loanapproval.delegate;

import org.camunda.bpm.engine.delegate.DelegateTask;
import org.camunda.bpm.engine.delegate.TaskListener;
import org.springframework.stereotype.Component;

@Component
public class RequestExecutionListener implements TaskListener {

    @Override
    public void notify(DelegateTask delegateTask) {
        System.out.println("===================== RequestExecutionListener ======================");
        System.out.println("Name: " + delegateTask.getName());
        System.out.println("Budget: " + delegateTask.getVariable("budget"));
    }
}
