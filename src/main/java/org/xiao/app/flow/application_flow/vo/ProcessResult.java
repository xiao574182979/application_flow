package org.xiao.app.flow.application_flow.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.xiao.app.flow.application_flow._enum.ResultStatus;


/**
 * @author xiaozuoxin
 *
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProcessResult {

    private ResultStatus status;

}
