package com.cloud.workflow.listener;

import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.ExecutionListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

/**
 * @creator ice
 * @createTime 2019/4/30
 * @description
 */
public class StartListener implements ExecutionListener {

    private static final Logger LOGGER = LoggerFactory.getLogger(StartListener.class);
    @Override
    public void notify(DelegateExecution delegateExecution) {
    	LOGGER.error("流程启动监听开始");
        String event = delegateExecution.getEventName();
        String processDefinitionId = delegateExecution.getProcessDefinitionId();
        String processInstanceId = delegateExecution.getProcessInstanceId();
        String processInstanceBusinessKey = delegateExecution.getProcessInstanceBusinessKey();
        LOGGER.error("processDefinitionId-:" + processDefinitionId);
        LOGGER.error("processInstanceId-:" + processInstanceId);
        LOGGER.error("processInstanceBusinessKey-:" + processInstanceBusinessKey);
        Map<String,Object> params = delegateExecution.getVariables();
        for (Map.Entry entry: params.entrySet()) {
            LOGGER.error(event + "-" + "key:" + entry.getKey() + "-value：" + entry.getValue());
        }
        LOGGER.error("流程启动监听结束");
    }
}
