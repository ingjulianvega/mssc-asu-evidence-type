package ingjulianvega.ximic.msscasuevidencetype.services;



import ingjulianvega.ximic.msscasuevidencetype.configuration.ErrorCodeMessages;
import ingjulianvega.ximic.msscasuevidencetype.domain.EvidenceTypeEntity;
import ingjulianvega.ximic.msscasuevidencetype.domain.repositories.EvidenceTypeRepository;
import ingjulianvega.ximic.msscasuevidencetype.exception.EvidenceTypeException;
import ingjulianvega.ximic.msscasuevidencetype.web.Mappers.EvidenceTypeMapper;
import ingjulianvega.ximic.msscasuevidencetype.web.model.EvidenceType;
import ingjulianvega.ximic.msscasuevidencetype.web.model.EvidenceTypeDto;
import ingjulianvega.ximic.msscasuevidencetype.web.model.EvidenceTypeList;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.UUID;

@RequiredArgsConstructor
@Slf4j
@Service
public class EvidenceTypeServiceImpl implements EvidenceTypeService {

    private final EvidenceTypeRepository evidenceTypeRepository;
    private final EvidenceTypeMapper evidenceTypeMapper;

    @Cacheable(cacheNames = "evidenceTypeListCache", condition = "#usingCache == false")
    @Override
    public EvidenceTypeList get(Boolean usingCache) {
        log.debug("get()...");
        return EvidenceTypeList
                .builder()
                .genderList(evidenceTypeMapper.evidenceTypeEntityListToEvidenceTypeDtoList(evidenceTypeRepository.findAllByOrderByName()))
                .build();
    }

    @Cacheable(cacheNames = "evidenceTypeCache")
    @Override
    public EvidenceTypeDto getById(UUID id) {
        log.debug("getById()...");
        return evidenceTypeMapper.evidenceTypeEntityToEvidenceTypeDto(
                evidenceTypeRepository.findById(id)
                        .orElseThrow(() -> EvidenceTypeException
                                .builder()
                                .httpStatus(HttpStatus.BAD_REQUEST)
                                .apiCode(ErrorCodeMessages.EVIDENCE_TYPE_NOT_FOUND_API_CODE)
                                .error(ErrorCodeMessages.EVIDENCE_TYPE_NOT_FOUND_ERROR)
                                .message(ErrorCodeMessages.EVIDENCE_TYPE_NOT_FOUND_MESSAGE)
                                .solution(ErrorCodeMessages.EVIDENCE_TYPE_NOT_FOUND_SOLUTION)
                                .build()));
    }

    @Override
    public void create(EvidenceType evidence) {
        log.debug("create()...");
        evidenceTypeMapper.evidenceTypeEntityToEvidenceTypeDto(
                evidenceTypeRepository.save(
                        evidenceTypeMapper.evidenceTypeDtoToEvidenceTypeEntity(
                                EvidenceTypeDto
                                        .builder()
                                        .name(evidence.getName())
                                        .build())));
    }

    @Override
    public void updateById(UUID id, EvidenceType evidence) {
        log.debug("updateById...");
        EvidenceTypeEntity evidenceEntity = evidenceTypeRepository.findById(id)
                .orElseThrow(() -> EvidenceTypeException
                        .builder()
                        .httpStatus(HttpStatus.BAD_REQUEST)
                        .apiCode(ErrorCodeMessages.EVIDENCE_TYPE_NOT_FOUND_API_CODE)
                        .error(ErrorCodeMessages.EVIDENCE_TYPE_NOT_FOUND_ERROR)
                        .message(ErrorCodeMessages.EVIDENCE_TYPE_NOT_FOUND_MESSAGE)
                        .solution(ErrorCodeMessages.EVIDENCE_TYPE_NOT_FOUND_SOLUTION)
                        .build());

        evidenceEntity.setName(evidence.getName());

        evidenceTypeRepository.save(evidenceEntity);
    }

    @Override
    public void deleteById(UUID id) {
        log.debug("deleteById...");
        evidenceTypeRepository.deleteById(id);
    }
}
