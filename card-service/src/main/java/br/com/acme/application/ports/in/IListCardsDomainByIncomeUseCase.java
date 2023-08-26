package br.com.acme.application.ports.in;

import br.com.acme.application.domain.entity.CardDomain;

import java.math.BigDecimal;
import java.util.List;

public interface IListCardsDomainByIncomeUseCase {
    List<CardDomain> execute(BigDecimal income);
}
