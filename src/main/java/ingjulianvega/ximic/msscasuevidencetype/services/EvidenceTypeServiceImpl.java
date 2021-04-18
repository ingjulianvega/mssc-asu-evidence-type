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
import org.springframework.stereotype.Service;

import java.util.UUID;

@RequiredArgsConstructor
@Slf4j
@Service
public class EvidenceTypeServiceImpl implements EvidenceTypeService {

    private final EvidenceTypeRepository evidenceTypeRepository;
    private final EvidenceTypeMapper evidenceTypeMapper;

    @Cacheable(cacheNames = "evidenceTypeListCache")
    @Override
    public EvidenceTypeList get() {
        log.debug("get()...");
        return EvidenceTypeList
                .builder()
                .genderList(evidenceTypeMapper.evidenceTypeEntityListToEvidenceTypeDtoList(evidenceTypeRepository.findAll()))
                .build();
    }

    @Cacheable(cacheNames = "evidenceTypeCache")
    @Override
    public EvidenceTypeDto getById(UUID id) {
        log.debug("getById()...");
        return evidenceTypeMapper.evidenceTypeEntityToEvidenceTypeDto(
                evidenceTypeRepository.findById(id)
                        .orElseThrow(() -> new EvidenceTypeException(ErrorCodeMessages.EVIDENCE_TYPE_NOT_FOUND, "")));
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
                .orElseThrow(() -> new EvidenceTypeException(ErrorCodeMessages.EVIDENCE_TYPE_NOT_FOUND, ""));

        evidenceEntity.setName(evidence.getName());

        evidenceTypeRepository.save(evidenceEntity);
    }

    @Override
    public void deleteById(UUID id) {
        log.debug("deleteById...");
        evidenceTypeRepository.deleteById(id);
    }
}
