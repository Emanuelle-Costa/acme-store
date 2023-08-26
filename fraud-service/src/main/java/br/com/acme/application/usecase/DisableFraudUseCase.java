package br.com.acme.application.usecase;

import br.com.acme.application.domain.FraudDomain;
import br.com.acme.application.ports.out.IDisableFraudRepository;
import br.com.acme.application.ports.in.IDisableFraudUseCase;
import br.com.acme.utils.UseCase;
import lombok.AllArgsConstructor;

import java.time.LocalDateTime;

@UseCase
@AllArgsConstructor
public class DisableFraudUseCase implements IDisableFraudUseCase {

    private final IDisableFraudRepository iDisableFraudRepository;

    @Override
    public FraudDomain execute(String document) {
        var fraud = FraudDomain.builder()
                .document(document)
                .build();
        fraud.setActive(false);
        fraud.setUpdate_at(LocalDateTime.now());
        return fraud.disableFraud(iDisableFraudRepository);
    }
}
