package org.xiao.app.flow.application_flow.flow;

import lombok.extern.slf4j.Slf4j;

import org.xiao.app.flow.application_flow._enum.ResultStatus;
import org.xiao.app.flow.application_flow.flow.component.IAppFlowService;
import org.xiao.app.flow.application_flow.vo.ProcessParameter;
import org.xiao.app.flow.application_flow.vo.ProcessResult;

import java.util.List;

@Slf4j
public abstract class AbstractTaskService {

    private IAppFlowService appFlowService;

    private ProcessParameter processParameter;

    public AbstractTaskService(IAppFlowService appFlowService, ProcessParameter processParameter) {
        this.appFlowService = appFlowService;
        this.processParameter = processParameter;
    }

    public void execute(){
        String flowName = appFlowService.flowName();
        ResultStatus status = ResultStatus.PAUSE;
        try {
            ProcessResult processResult = appFlowService.process(processParameter);
            if(! processResult.getStatus().equals(ResultStatus.DONE)) {
                status = processResult.getStatus();
            }
        }catch (Exception e){
            log.error("执行失败 {}",flowName,e);
        }
        dataPersistence(flowName,processParameter,status);
    }

    /**
     * 保存未完成的进程
     * @param flowName 流程名称 唯一
     * @param processParameter 参数
     * @param status 状态
     */
    public abstract void dataPersistence(String flowName,ProcessParameter processParameter,ResultStatus status);

    /**
     * 获取未完成的进程
     * @return
     */
    public abstract List getUndoProcess();

    /**
     * 更新已操作的进程的状态 同时执行次数 + 1
     *  @param id id
     *  @param status 状态
     * @return
     */
    public abstract void updateProcessStatus(Integer id,ResultStatus status);

    /**
     * 删除已执行完成的进程
     */
    public abstract  void deleteDoneProcess();
}
