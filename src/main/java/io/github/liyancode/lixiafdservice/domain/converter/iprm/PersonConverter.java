package io.github.liyancode.lixiafdservice.domain.converter.iprm;

import io.github.liyancode.lixiafdservice.domain.converter.IConvertor;
import io.github.liyancode.lixiafdservice.domain.module.iprm.PersonDO;
import io.github.liyancode.lixiafdservice.infra.persistant.object.iprm.PersonPO;
import org.mapstruct.Mapper;

/**
 * @author liyancode
 * @date 2022/10/16
 * @description
 */
@Mapper(componentModel = "spring")
public interface PersonConverter extends IConvertor<PersonDO, PersonPO> {
}
