package br.com.acme.adapters.input.web.controller;

import br.com.acme.adapters.input.web.api.FraudApi;
import br.com.acme.adapters.input.web.request.FraudRequest;
import br.com.acme.adapters.input.web.response.CheckFraudActiveResponse;
import br.com.acme.adapters.input.web.response.FraudResponse;
import br.com.acme.application.domain.FraudDomain;
import br.com.acme.application.mapper.ConverterDTO;
import br.com.acme.application.ports.in.*;
import br.com.acme.application.ports.in.IDisableFraudUseCase;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class FraudController implements FraudApi {
    private final ICreateFraudDomainUseCase iCreateFraudUseCase;
    private final ICheckFraudActiveUseCase iCheckFraudActiveUseCase;
    private final IDisableFraudUseCase iDisableFraudUseCase;
    private final IListFraudsUseCase iListFraudsUseCase;
    private final IDeleteFraudUseCase iDeleteFraudUseCase;


    private final ConverterDTO converterDTO;

    @Override
    public ResponseEntity<FraudResponse> create(FraudRequest fraudRequest) {
        var domain = (FraudDomain) converterDTO.convertObject(fraudRequest, FraudDomain.class);
        var response = (FraudResponse) converterDTO
                .convertObject(iCreateFraudUseCase.execute(domain), FraudResponse.class);
        return ResponseEntity.ok(response);
    }

    @Override
    public ResponseEntity<CheckFraudActiveResponse> checkFraud(String document) {
        var response = (CheckFraudActiveResponse) converterDTO.convertObject(this.iCheckFraudActiveUseCase.execute(document), CheckFraudActiveResponse.class);
        return ResponseEntity.ok(response);
    }

    @Override
    public ResponseEntity<CheckFraudActiveResponse> disableActiveFraud(String documento) {
        var response = (CheckFraudActiveResponse) converterDTO.convertObject(this.iDisableFraudUseCase.execute(documento)
                , CheckFraudActiveResponse.class);
        return ResponseEntity.ok(response);
    }
    @Override
    public ResponseEntity<List<FraudResponse>> list() {
        var domains = iListFraudsUseCase.execute();
        var response = (List<FraudResponse>) converterDTO.convertLIstObjects(domains, FraudResponse.class);
        return ResponseEntity.ok(response);
    }

    @Override
    public ResponseEntity delete(Long id) {
        this.iDeleteFraudUseCase.execute(id);
        return ResponseEntity.ok().build();
    }

}
