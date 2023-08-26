package br.com.acme.application.ports.out;

import br.com.acme.application.domain.entity.CardDomain;

import java.math.BigDecimal;
import java.util.List;

public interface IListCardsByIncomeRepository {
    List<CardDomain> execute(BigDecimal income);
}

