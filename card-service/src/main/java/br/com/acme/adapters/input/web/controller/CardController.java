package br.com.acme.adapters.input.web.controller;

import br.com.acme.adapters.input.web.api.CardApi;
import br.com.acme.adapters.input.web.request.CardRequest;
import br.com.acme.adapters.input.web.request.UpdateCardRequest;
import br.com.acme.adapters.input.web.response.CardResponse;
import br.com.acme.application.domain.entity.CardDomain;
import br.com.acme.application.domain.exception.CardNotFoundException;
import br.com.acme.application.mapper.ConverterDTO;
import br.com.acme.application.ports.in.*;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.List;

@AllArgsConstructor
@RestController
public class CardController implements CardApi {
    private final ICreateCardDomainUseCase iCreateCardDomainUseCase;
    private final IGetCardDomainByIdUseCase iGetCardDomainByIdUseCase;
    private final IListCardsDomainUseCase iListCardsDomainUseCase;
    private final IListCardsDomainByIncomeUseCase iListCardsDomainByIncomeUseCase;
    private final IDeleteCardDomainUseCase iDeleteCardDomainUseCase;
    private final IUpdateCardDomainUseCase iUpdateCardDomainUseCase;
    private final IListCardsAvailableClientUseCase iListCardsAvailableClientUseCase;

    private final ConverterDTO converterDTO;

    @Override
    public ResponseEntity<CardResponse> create(CardRequest cardRequest) {
        var domain = (CardDomain) converterDTO.convertObject(cardRequest, CardDomain.class);
        var response =  (CardResponse) converterDTO
                .convertObject(iCreateCardDomainUseCase.execute(domain), CardResponse.class);
        return ResponseEntity.ok(response);
    }

    @Override
    public ResponseEntity<CardResponse> get(Long id) {
        try {
            var domain = (CardDomain) iGetCardDomainByIdUseCase.execute(id);
            return ResponseEntity.ok((CardResponse) converterDTO
                    .convertObject(domain, CardResponse.class));
        } catch (CardNotFoundException e){
            throw new CardNotFoundException(id);
        }
    }


    @Override
    public ResponseEntity<List<CardResponse>> listByIncome(BigDecimal income) {
        var response = (List<CardResponse>)
                converterDTO.convertListObjects(this.iListCardsDomainByIncomeUseCase.execute(income), CardResponse.class);
        return ResponseEntity.ok(response);
    }
    @Override
    public ResponseEntity<List<CardResponse>> getCardsAvailableClient(String income) {
        var domain = this.iListCardsAvailableClientUseCase.execute(income);
        var response = (List<CardResponse>)
                converterDTO.convertListObjects(domain, CardResponse.class);
        return ResponseEntity.ok(response);
    }

    @Override
    public ResponseEntity<List<CardResponse>> list() {
        var response_domain = this.iListCardsDomainUseCase.execute();
        var response = (List<CardResponse>) converterDTO.convertListObjects(response_domain, CardResponse.class);
        return ResponseEntity.ok(response);
    }

    @Override
    public ResponseEntity delete(Long id) {
        this.iDeleteCardDomainUseCase.execute(id);
        return ResponseEntity.ok().build();
    }

    @Override
    public ResponseEntity<CardResponse> updateCard(UpdateCardRequest updateCardRequest, Long id) {
        var domain = (CardDomain) converterDTO.convertObject(updateCardRequest, CardDomain.class);
        var response = (CardResponse) converterDTO.convertObject(this.iUpdateCardDomainUseCase.execute(domain, id), CardResponse.class);
        return ResponseEntity.ok(response);

    }
}
