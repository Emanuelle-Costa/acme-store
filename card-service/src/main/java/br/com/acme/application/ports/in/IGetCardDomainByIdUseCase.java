package br.com.acme.application.ports.in;

import br.com.acme.application.domain.entity.CardDomain;

public interface IGetCardDomainByIdUseCase {
    CardDomain execute(Long id);
}
