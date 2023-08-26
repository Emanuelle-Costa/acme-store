package br.com.acme.application.usecase;

import br.com.acme.application.domain.entity.CardDomain;
import br.com.acme.application.ports.in.IListCardsAvailableClientUseCase;
import br.com.acme.application.ports.out.IListCardsAvailableClientRepository;
import br.com.acme.utils.UseCase;
import lombok.AllArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@UseCase
@AllArgsConstructor
public class ListCardsAvailableClientUseCase implements IListCardsAvailableClientUseCase {

    private final IListCardsAvailableClientRepository iListCardsAvailableClientRepository;
    @Override
    public List<CardDomain> execute(String income) {
        return CardDomain.builder().income(new BigDecimal(income))
                .build().listAvailableCardsClient(iListCardsAvailableClientRepository);
    }
}
