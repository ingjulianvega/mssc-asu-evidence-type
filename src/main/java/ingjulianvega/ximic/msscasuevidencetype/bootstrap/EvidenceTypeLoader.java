package ingjulianvega.ximic.msscasuevidencetype.bootstrap;

import ingjulianvega.ximic.msscasuevidencetype.domain.EvidenceTypeEntity;
import ingjulianvega.ximic.msscasuevidencetype.domain.repositories.EvidenceTypeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@RequiredArgsConstructor
@Component
public class EvidenceTypeLoader implements CommandLineRunner {

    private final EvidenceTypeRepository evidenceTypeRepository;

    @Override
    public void run(String... args) throws Exception {
        if (evidenceTypeRepository.count() == 0) {
            loadEvidenceTypeObjects();
        }
    }

    private void loadEvidenceTypeObjects() {
        evidenceTypeRepository.saveAll(Arrays.asList(
                EvidenceTypeEntity.builder().name("Personal").build(),
                EvidenceTypeEntity.builder().name("Familiar").build(),
                EvidenceTypeEntity.builder().name("Quirúrgico").build(),
                EvidenceTypeEntity.builder().name("Tóxico").build(),
                EvidenceTypeEntity.builder().name("Alérgico").build(),
                EvidenceTypeEntity.builder().name("Deportivo").build(),
                EvidenceTypeEntity.builder().name("Ocupacional").build(),
                EvidenceTypeEntity.builder().name("Ginecológico").build(),
                EvidenceTypeEntity.builder().name("Traumático").build(),
                EvidenceTypeEntity.builder().name("Inmuológico").build(),
                EvidenceTypeEntity.builder().name("Otro").build()
        ));
    }
}