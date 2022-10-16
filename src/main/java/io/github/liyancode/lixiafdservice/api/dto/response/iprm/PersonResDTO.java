package io.github.liyancode.lixiafdservice.api.dto.response.iprm;

import io.github.liyancode.lixiafdservice.api.dto.response.BaseResponseDTO;
import io.github.liyancode.lixiafdservice.domain.module.iprm.PersonDO;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.util.List;

/**
 * @author liyancode
 * @date 2022/10/16
 * @description
 */
@Getter
@Setter
@Accessors(chain = true)
public class PersonResDTO extends BaseResponseDTO<List<PersonDO>> {

}
