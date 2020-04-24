package org.xiao.app.flow.application_flow.storge;

import org.xiao.app.flow.application_flow.flow.component.IAppFlowService;

import java.util.HashMap;
import java.util.Map;

/**
 * @author xiaozuoxin
 * 在项目初始化时 缓存Task 服务类
 */
public final class LocalServiceStorage {

    private static Map<String, IAppFlowService> serviceLocal = new HashMap<>();

    public static void setServiceLocal(Map<String, IAppFlowService> appFlowServiceMap){
        for(Map.Entry <String, IAppFlowService> entry : appFlowServiceMap.entrySet()) {
            IAppFlowService appFlowService = entry.getValue();
            serviceLocal.put(appFlowService.flowName(),appFlowService);
        }

    }

    public static IAppFlowService getService(String flowName){
        return serviceLocal.get(flowName);
    }
}
