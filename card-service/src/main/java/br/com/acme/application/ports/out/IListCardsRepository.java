package br.com.acme.application.ports.out;

import br.com.acme.application.domain.entity.CardDomain;

import java.util.List;

public interface IListCardsRepository {

    List<CardDomain> execute();
}
