package br.com.acme.application.usecase;

import br.com.acme.application.domain.entity.CardDomain;
import br.com.acme.application.ports.in.IGetCardDomainByIdUseCase;
import br.com.acme.application.ports.out.IGetCardByIdRepository;
import br.com.acme.utils.UseCase;
import lombok.AllArgsConstructor;

@UseCase
@AllArgsConstructor
public class GetCardDomainByIdUseCase implements IGetCardDomainByIdUseCase {

    private final IGetCardByIdRepository iGetCardDomainByIdRepository;

    @Override
    public CardDomain execute(Long id) {
        return CardDomain.builder()
                .id(id)
                .build()
                .getById(iGetCardDomainByIdRepository);

    }
}
