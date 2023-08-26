package br.com.acme.adapters.output.database.h2.service;

import br.com.acme.adapters.output.database.h2.repository.CardRepository;
import br.com.acme.application.domain.entity.CardDomain;
import br.com.acme.application.mapper.ConverterDTO;
import br.com.acme.application.ports.out.IListCardsRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ListCardsRepositoryService implements IListCardsRepository {

    private final ConverterDTO converterDTO;
    private final CardRepository cardRepository;

    @Override
    public List<CardDomain> execute() {
        return (List<CardDomain>) converterDTO
                .convertListObjects(cardRepository.findAll(), CardDomain.class);
    }
}
