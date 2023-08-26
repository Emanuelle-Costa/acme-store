package br.com.acme.adapters.output.database.h2.service;

import br.com.acme.adapters.output.database.h2.repository.CardRepository;
import br.com.acme.application.domain.entity.CardDomain;
import br.com.acme.application.mapper.ConverterDTO;
import br.com.acme.application.ports.out.IListCardsAvailableClientRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
@AllArgsConstructor
public class ListCardsAvailableClientRepositoryService implements IListCardsAvailableClientRepository {

    private final CardRepository cardRepository;
    private final ConverterDTO converterDTO;
    @Override
    public List<CardDomain> execute(String income) {
        var cards = this.cardRepository.findByIncomeLessThanEqual(new BigDecimal(income));
        return (List<CardDomain>)
                converterDTO.convertListObjects(cards, CardDomain.class);
    }
}
