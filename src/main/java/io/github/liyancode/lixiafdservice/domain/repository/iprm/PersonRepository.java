package io.github.liyancode.lixiafdservice.domain.repository.iprm;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import io.github.liyancode.lixiafdservice.domain.converter.iprm.PersonConverter;
import io.github.liyancode.lixiafdservice.domain.module.iprm.PersonDO;
import io.github.liyancode.lixiafdservice.infra.persistant.mapper.iprm.PersonMapper;
import io.github.liyancode.lixiafdservice.infra.persistant.object.iprm.PersonPO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

/**
 * @author liyancode
 * @date 2022/10/16
 * @description
 */
@Repository
public class PersonRepository {

    @Autowired
    PersonMapper personMapper;

    @Autowired
    PersonConverter personConverter;

    public boolean insertPerson(PersonDO personDO) {
        PersonPO personPO = personConverter.convert(personDO);
        personPO.setVersion(0);
        personPO.setCreateTime(new Date());
        personPO.setLastUpdateTime(new Date());
        return personMapper.insert(personPO) > 0;
    }

    public boolean deletePerson(PersonDO personDO) {
        PersonPO personPO = personConverter.convert(selectByPersonId(personDO.getPersonId()));
        personPO.setOperator(personDO.getOperator());
        personPO.setDeleteFlag(1);
        personPO.setLastUpdateTime(new Date());
        personPO.setVersion(personPO.getVersion() + 1);
        return personMapper.updateById(personPO) > 0;
    }

    public boolean updatePerson(PersonDO personDO) {
        PersonPO personPO = personConverter.convert(personDO);
        personPO.setLastUpdateTime(new Date());
        personPO.setVersion(personMapper.selectById(personDO.getFdPersonId()).getVersion() + 1);
        return personMapper.updateById(personPO) > 0;
    }

    public PersonDO selectById(Long fsPersonId) {
        return personConverter.convert(personMapper.selectById(fsPersonId));
    }

    public List<PersonDO> selectListByFullName(String fullName) {
        return personConverter.convert(personMapper.selectList(
                new QueryWrapper<PersonPO>()
                        .like("full_name", fullName)
                        .eq("delete_flag", 0)));
    }

    public long selectCountOfGender(int gender) {
        return personMapper.selectCount(
                new QueryWrapper<PersonPO>()
                        .eq("gender", gender)
                        .eq("delete_flag", 0));
    }

    public PersonDO selectByPersonId(String personId) {
        return personConverter.convert(personMapper.selectOne(
                new QueryWrapper<PersonPO>()
                        .eq("person_id", personId)
                        .eq("delete_flag", 0)));
    }

    public boolean isExist(String column, String value) {
        return personMapper.selectOne(new QueryWrapper<PersonPO>().eq(column, value)) != null;
    }
}
