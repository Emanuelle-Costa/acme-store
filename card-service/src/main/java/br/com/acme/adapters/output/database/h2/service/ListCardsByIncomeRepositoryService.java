package br.com.acme.adapters.output.database.h2.service;

import br.com.acme.adapters.output.database.h2.repository.CardRepository;
import br.com.acme.application.domain.entity.CardDomain;
import br.com.acme.application.mapper.ConverterDTO;
import br.com.acme.application.ports.out.IListCardsByIncomeRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
@AllArgsConstructor
public class ListCardsByIncomeRepositoryService implements IListCardsByIncomeRepository {
    private final CardRepository cardRepository;
    private final ConverterDTO converterDTO;

    @Override
    public List<CardDomain> execute(BigDecimal income) {
        return (List<CardDomain>)
                converterDTO.convertListObjects(this.cardRepository.findByIncomeLessThanEqual(income), CardDomain.class);
    }

}
