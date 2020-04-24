package org.xiao.app.flow.application_flow.conf;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;
import org.xiao.app.flow.application_flow.flow.component.IAppFlowService;
import org.xiao.app.flow.application_flow.storge.LocalServiceStorage;

import java.util.Map;

@Component
public class InitApplicationContext implements ApplicationContextAware {

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        Map<String, IAppFlowService> appFlowServices = applicationContext.getBeansOfType(IAppFlowService.class);
        LocalServiceStorage.setServiceLocal(appFlowServices);
    }

}
