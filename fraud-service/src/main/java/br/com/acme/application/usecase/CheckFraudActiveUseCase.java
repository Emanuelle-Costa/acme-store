package br.com.acme.application.usecase;

import br.com.acme.application.domain.FraudDomain;
import br.com.acme.application.ports.in.ICheckFraudActiveUseCase;
import br.com.acme.application.ports.out.ICheckFraudActiveRepository;
import br.com.acme.utils.UseCase;
import lombok.AllArgsConstructor;

@UseCase
@AllArgsConstructor
public class CheckFraudActiveUseCase implements ICheckFraudActiveUseCase {

    private final ICheckFraudActiveRepository iCheckFraudActiveRepository;
    @Override
    public FraudDomain execute(String document) {
        return FraudDomain.builder()
                .document(document)
                .build()
                .checkActive(iCheckFraudActiveRepository);
    }
}
