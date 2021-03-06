package com.github.sparkzxl.activiti.domain.service.act;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.github.sparkzxl.activiti.domain.repository.IActReModelRepository;
import com.github.sparkzxl.activiti.infrastructure.entity.ActReModel;
import com.github.sparkzxl.activiti.infrastructure.entity.MetaInfo;
import com.github.sparkzxl.activiti.infrastructure.mapper.ActReModelMapper;
import com.github.sparkzxl.activiti.application.service.act.IActReModelService;
import com.github.sparkzxl.activiti.interfaces.dto.act.ModelPageDTO;
import com.github.sparkzxl.database.base.service.impl.AbstractSuperCacheServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * description: 模型 服务实现类
 *
 * @author: zhouxinlei
 * @date: 2020-07-25 11:14:57
 */
@Service
public class ActReModelServiceImpl extends AbstractSuperCacheServiceImpl<ActReModelMapper, ActReModel> implements IActReModelService {

    @Autowired
    private IActReModelRepository actReModelRepository;

    @Override
    public PageInfo<ActReModel> actReModelList(ModelPageDTO modelPageDTO) {
        PageHelper.startPage(modelPageDTO.getPageNum(), modelPageDTO.getPageNum());
        PageInfo<ActReModel> actReModelPageInfo = actReModelRepository.actReModelList(modelPageDTO.getKey(), modelPageDTO.getName());
        List<ActReModel> actReModels = actReModelPageInfo.getList();
        actReModels.forEach(item -> {
            item.setStatus(item.getDeploymentId() != null);
            MetaInfo metaInfo = JSONObject.parseObject(item.getMetaInfo(), MetaInfo.class);
            item.setDescription(metaInfo.getDescription());
        });
        actReModelPageInfo.setList(actReModels);
        return actReModelPageInfo;
    }

    @Override
    protected String getRegion() {
        return null;
    }
}
