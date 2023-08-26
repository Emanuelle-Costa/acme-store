package br.com.acme.application.usecase;

import br.com.acme.application.domain.entity.CardDomain;
import br.com.acme.application.ports.in.IListCardsDomainUseCase;
import br.com.acme.application.ports.out.IListCardsRepository;
import br.com.acme.utils.UseCase;
import lombok.AllArgsConstructor;

import java.util.List;

@UseCase
@AllArgsConstructor
public class ListCardsDomainUseCase implements IListCardsDomainUseCase {

    private final IListCardsRepository iListCardsRepository;

    @Override
    public List<CardDomain> execute() {

        return CardDomain.builder().build().list(iListCardsRepository);
    }
}
