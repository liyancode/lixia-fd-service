package io.github.liyancode.lixiafdservice.app.service.iprm;

import io.github.liyancode.lixiafdservice.api.dto.response.BaseResponseDTO;
import io.github.liyancode.lixiafdservice.api.dto.response.RespBaseResultsEnum;
import io.github.liyancode.lixiafdservice.app.service.BaseHandler;
import io.github.liyancode.lixiafdservice.domain.module.iprm.PersonDO;
import io.github.liyancode.lixiafdservice.domain.repository.iprm.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author liyancode
 * @date 2022/10/17
 * @description
 */
@Service
public class PersonHandler extends BaseHandler {

    @Autowired
    PersonRepository personRepository;

    public BaseResponseDTO<String> handlePersonCreate(PersonDO personDO) {
        BaseResponseDTO<String> resDTO = new BaseResponseDTO<>();
        try {
            if (personRepository.isExist("person_id", personDO.getPersonId())) {
                resDTO = respBizDataError("personId (" + personDO.getPersonId() + ") already existed.");
            } else {
                personDO.setFdPersonId(snowflakeIdUtils.nextId());
                if (personRepository.insertPerson(personDO)) {
                    resDTO.setResults(RespBaseResultsEnum.CREATED.toString());
                } else {
                    resDTO = respDBOprError("insert not finished.");
                }
            }
        } catch (Exception e) {
            resDTO = respExceptionCatch(e.toString());
        }
        return resDTO;
    }

    public BaseResponseDTO<String> handlePersonDelete(PersonDO personDO) {
        BaseResponseDTO<String> resDTO = new BaseResponseDTO<>();
        try {
            if (personRepository.selectByPersonId(personDO.getPersonId()) == null) {
                resDTO = respBizDataError("personId (" + personDO.getPersonId() + ") not existed.");
            } else {
                if (personRepository.deletePerson(personDO)) {
                    resDTO.setResults(RespBaseResultsEnum.DELETED.toString());
                } else {
                    resDTO = respDBOprError("delete not finished.");
                }
            }
        } catch (Exception e) {
            resDTO = respExceptionCatch(e.toString());
        }
        return resDTO;
    }

    public BaseResponseDTO<String> handlePersonUpdate(PersonDO personDO) {
        BaseResponseDTO<String> resDTO = new BaseResponseDTO<>();
        try {
            if (personRepository.selectByPersonId(personDO.getPersonId()) == null) {
                resDTO = respBizDataError("personId (" + personDO.getPersonId() + ") not existed.");
            } else {
                if (personRepository.updatePerson(personDO)) {
                    resDTO.setResults(RespBaseResultsEnum.UPDATED.toString());
                } else {
                    resDTO = respDBOprError("update not finished.");
                }
            }
        } catch (Exception e) {
            resDTO = respExceptionCatch(e.toString());
        }
        return resDTO;
    }

    public BaseResponseDTO<List<PersonDO>> handlePersonGetById(String personId) {
        BaseResponseDTO<List<PersonDO>> resDTO = new BaseResponseDTO();
        try {
            if (personId == null || personId.equals("")) {
                resDTO = respBizDataError("personId must not be null.");
            } else {
                PersonDO personDO = personRepository.selectByPersonId(personId);
                List results = new ArrayList<PersonDO>();
                results.add(personDO);
                resDTO.setResults(results);
            }
        } catch (Exception e) {
            resDTO = respExceptionCatch(e.toString());
        }
        return resDTO;
    }

    public BaseResponseDTO<List<PersonDO>> handlePersonGetAll() {
        BaseResponseDTO<List<PersonDO>> resDTO = new BaseResponseDTO();
        try {
            resDTO.setResults(personRepository.selectAll());
        } catch (Exception e) {
            resDTO = respExceptionCatch(e.toString());
        }
        return resDTO;
    }
}
