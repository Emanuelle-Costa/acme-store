package br.com.acme.adapters.output.database.h2.service;

import br.com.acme.adapters.output.database.h2.repository.FraudRepository;
import br.com.acme.application.domain.FraudDomain;
import br.com.acme.application.mapper.ConverterDTO;
import br.com.acme.application.ports.out.IDisableFraudRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@AllArgsConstructor
public class DisableFraudRepositoryService implements IDisableFraudRepository {
    private final FraudRepository fraudRepository;
    private final ConverterDTO converterDTO;
    @Override
    public FraudDomain execute(String document) {
        var entity = fraudRepository.findByDocument(document);
        entity.setActive(false);
        entity.setUpdate_at(LocalDateTime.now());
        return (FraudDomain) converterDTO.convertObject(this.fraudRepository.save(entity), FraudDomain.class);
    }
}
