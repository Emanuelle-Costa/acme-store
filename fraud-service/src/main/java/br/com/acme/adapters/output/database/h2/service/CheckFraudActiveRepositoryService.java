package br.com.acme.adapters.output.database.h2.service;

import br.com.acme.adapters.output.database.h2.repository.FraudRepository;
import br.com.acme.application.domain.FraudDomain;
import br.com.acme.application.mapper.ConverterDTO;

import br.com.acme.application.ports.out.ICheckFraudActiveRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CheckFraudActiveRepositoryService implements ICheckFraudActiveRepository {

    private final FraudRepository fraudRepository;
    private final ConverterDTO converterDTO;
    @Override
    public FraudDomain execute(String document) {
        return (FraudDomain) converterDTO.convertObject(this.fraudRepository.findByDocument(document), FraudDomain.class);
    }
}
