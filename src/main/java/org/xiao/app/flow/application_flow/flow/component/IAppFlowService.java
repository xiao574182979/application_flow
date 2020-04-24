package org.xiao.app.flow.application_flow.flow.component;

import org.xiao.app.flow.application_flow.vo.ProcessParameter;
import org.xiao.app.flow.application_flow.vo.ProcessResult;

/**
 * @author xiaozuoxin
 *
 */
public interface IAppFlowService {

    public ProcessResult process(ProcessParameter processParameter);

    public String flowName();

}
