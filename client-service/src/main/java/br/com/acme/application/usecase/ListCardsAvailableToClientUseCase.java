package br.com.acme.application.usecase;

import br.com.acme.adapters.output.external.GetCardsAvailableToClient;
import br.com.acme.application.domain.entity.CardDomain;
import br.com.acme.application.mapper.ConverterDTO;
import br.com.acme.application.ports.in.IListCardsAvailableToClientUseCase;
import br.com.acme.utils.UseCase;
import lombok.AllArgsConstructor;

import java.util.List;


@UseCase
@AllArgsConstructor
public class
ListCardsAvailableToClientUseCase implements IListCardsAvailableToClientUseCase {

    private final GetCardsAvailableToClient getCardsAvailableToClient;

    private final ConverterDTO converterDTO;

    @Override
    public List<CardDomain> execute(String income) {
        return (List<CardDomain>) converterDTO
                .convertListObjects(this.getCardsAvailableToClient.getCardsAvailable(income), CardDomain.class);
    }

}
