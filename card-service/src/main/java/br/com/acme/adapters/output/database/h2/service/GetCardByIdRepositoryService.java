package br.com.acme.adapters.output.database.h2.service;

import br.com.acme.adapters.output.database.h2.repository.CardRepository;
import br.com.acme.application.domain.entity.CardDomain;
import br.com.acme.application.domain.exception.CardNotFoundException;
import br.com.acme.application.mapper.ConverterDTO;
import br.com.acme.application.ports.out.IGetCardByIdRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class GetCardByIdRepositoryService implements IGetCardByIdRepository {

    private final ConverterDTO converterDTO;
    private final CardRepository cardRepository;

    @Override
    public CardDomain execute(Long id) {
        var entity = this.cardRepository.findById(id);
        if(entity.isEmpty()){
            throw new CardNotFoundException(id);
        }
        return (CardDomain) converterDTO
                .convertObject(entity, CardDomain.class);
    }
}
