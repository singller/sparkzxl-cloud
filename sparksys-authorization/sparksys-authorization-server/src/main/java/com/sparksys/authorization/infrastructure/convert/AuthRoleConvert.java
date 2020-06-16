package com.sparksys.authorization.infrastructure.convert;

import com.sparksys.authorization.infrastructure.po.AuthRoleDO;
import com.sparksys.authorization.interfaces.dto.role.AuthRoleDTO;
import com.sparksys.authorization.interfaces.dto.role.AuthRoleSaveDTO;
import com.sparksys.authorization.interfaces.dto.role.AuthRoleUpdateDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * description: AuthRole对象Convert
 *
 * @Author zhouxinlei
 * @Date 2020-06-05 21:28:06
 */
@Mapper
public interface AuthRoleConvert {

    AuthRoleConvert INSTANCE = Mappers.getMapper(AuthRoleConvert.class);

    AuthRoleDO convertAuthRoleDO(AuthRoleSaveDTO authRoleSaveDTO);

    AuthRoleDO convertAuthRoleDO(AuthRoleUpdateDTO authRoleUpdateDTO);

    AuthRoleDTO convertAuthUserDTO(AuthRoleDO authRoleDO);

}