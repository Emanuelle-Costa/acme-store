package br.com.acme.application.ports.in;

import br.com.acme.application.domain.FraudDomain;

public interface ICheckFraudActiveUseCase {
    FraudDomain execute(String document);
}
