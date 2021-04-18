package ingjulianvega.ximic.msscasuevidencetype.domain.repositories;

import ingjulianvega.ximic.msscasuevidencetype.domain.EvidenceTypeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.UUID;

public interface EvidenceTypeRepository extends JpaRepository<EvidenceTypeEntity, UUID>, JpaSpecificationExecutor<EvidenceTypeEntity> {
}
