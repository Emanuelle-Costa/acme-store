package br.com.acme.application.usecase;

import br.com.acme.application.domain.entity.CardDomain;
import br.com.acme.application.ports.in.IUpdateCardDomainUseCase;
import br.com.acme.application.ports.out.IUpdateCardDomainRepository;
import br.com.acme.utils.UseCase;
import lombok.AllArgsConstructor;

@UseCase
@AllArgsConstructor
public class UpdateCardDomainUseCase implements IUpdateCardDomainUseCase {

    private final IUpdateCardDomainRepository iUpdateCardDomainRepository;

    @Override
    public CardDomain execute(CardDomain cardDomain, Long id) {
        var card = CardDomain.builder().id(id).build();
        card.setCard_limit(cardDomain.getCard_limit());
        return card.updateCard(iUpdateCardDomainRepository);
    }
}
