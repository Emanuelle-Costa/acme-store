package br.com.acme.application.ports.out;

import br.com.acme.application.domain.entity.CardDomain;

public interface IGetCardByIdRepository {
    CardDomain execute(Long id);
}
