package br.com.acme.adapters.output.database.h2.service;

import br.com.acme.adapters.output.database.h2.entity.Card;
import br.com.acme.adapters.output.database.h2.repository.CardRepository;
import br.com.acme.application.domain.entity.CardDomain;
import br.com.acme.application.mapper.ConverterDTO;
import br.com.acme.application.ports.out.IUpdateCardDomainRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UpdateCardRepositoryService implements IUpdateCardDomainRepository {

    private final CardRepository cardRepository;

    private final ConverterDTO converterDTO;

    @Override
    public CardDomain execute(CardDomain cardDomain, Long id) {
        var cardConverter = (Card) converterDTO.convertObject(cardDomain, Card.class);
        var card = this.cardRepository.findById(id).get();
        card.setCard_limit(cardConverter.getCard_limit());
        return (CardDomain) converterDTO.convertObject(this.cardRepository.save(card), CardDomain.class);
    }
}
