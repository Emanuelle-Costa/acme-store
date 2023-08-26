package br.com.acme.application.domain.entity;

import br.com.acme.application.ports.out.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class CardDomain {

    private Long id;
    private String card_name;
    private String card_flag;
    private BigDecimal income;
    private BigDecimal card_limit;

    public CardDomain save(ICreateCardRepository iCreateCardRepository){
        return iCreateCardRepository.execute(this);
    }

    public List<CardDomain> list(IListCardsRepository iListCardsRepository) {
        return iListCardsRepository.execute();
    }

    public void delete(IDeleteCardRepository iDeleteCardRepository) {
        iDeleteCardRepository.execute(this.id);
    }


    public CardDomain updateCard(IUpdateCardDomainRepository iUpdateCardDomainRepository){
        return iUpdateCardDomainRepository.execute(this, this.id);
    }

    public CardDomain getById(IGetCardByIdRepository iGetCardDomainByIdRepository){
        return iGetCardDomainByIdRepository.execute(this.id);
    }

    public List<CardDomain> listByIncome(IListCardsByIncomeRepository iListCardDomainByIncomeRepository){
        return iListCardDomainByIncomeRepository.execute(this.income);
    }
    public List<CardDomain> listAvailableCardsClient(IListCardsAvailableClientRepository iListCardsAvailableClientRepository) {
        return iListCardsAvailableClientRepository.execute(this.income.toString());
    }
}
