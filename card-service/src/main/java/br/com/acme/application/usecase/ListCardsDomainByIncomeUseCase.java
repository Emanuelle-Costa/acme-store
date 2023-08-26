package br.com.acme.application.usecase;

import br.com.acme.application.domain.entity.CardDomain;
import br.com.acme.application.ports.in.IListCardsDomainByIncomeUseCase;
import br.com.acme.application.ports.out.IListCardsByIncomeRepository;
import br.com.acme.utils.UseCase;
import lombok.AllArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@UseCase
@AllArgsConstructor
public class ListCardsDomainByIncomeUseCase implements IListCardsDomainByIncomeUseCase {

    private final IListCardsByIncomeRepository iListCardDomainByIncomeRepository;

    @Override
    public List<CardDomain> execute(BigDecimal income) {
        return CardDomain.builder()
                .income(income)
                .build()
                .listByIncome(iListCardDomainByIncomeRepository);
    }
}
