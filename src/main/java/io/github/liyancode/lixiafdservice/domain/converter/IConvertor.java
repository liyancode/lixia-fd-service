package io.github.liyancode.lixiafdservice.domain.converter;

import io.github.liyancode.lixiafdservice.domain.module.BaseDO;
import io.github.liyancode.lixiafdservice.infra.persistant.object.BasePO;
import org.springframework.core.convert.converter.Converter;

import java.util.List;

/**
 * @author liyancode
 * @date 2022/10/16
 * @description
 */
public interface IConvertor<D extends BaseDO, P extends BasePO> {

    P convert(D domain);

    List<D> convert(List<P> pos);

    D convert(P po);

    List<P> convertReverse(List<D> pos);
}

