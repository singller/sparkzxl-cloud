package com.github.sparkzxl.activiti.infrastructure.convert;

import com.github.sparkzxl.activiti.infrastructure.entity.ProcessTaskRule;
import com.github.sparkzxl.activiti.interfaces.dto.process.TaskRuleSaveDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * description: ProcessTaskRule 对象Convert
 *
 * @author zhouxinlei
 * @date 2020-06-05 21:28:06
 */
@Mapper
public interface ProcessTaskRuleConvert {

    ProcessTaskRuleConvert INSTANCE = Mappers.getMapper(ProcessTaskRuleConvert.class);

    /**
     * TaskRuleSaveDTO转化为ProcessTaskRule
     *
     * @param taskRuleSaveDTO TaskRule保存对象
     * @return ProcessTaskRule
     */
    ProcessTaskRule convertTaskRuleSaveDTO(TaskRuleSaveDTO taskRuleSaveDTO);

}
