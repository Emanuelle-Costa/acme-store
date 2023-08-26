package br.com.acme.application.domain;

import br.com.acme.application.ports.out.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FraudDomain {

    private Long id;
    private String document;
    private boolean active = true;
    private LocalDateTime create_at = LocalDateTime.now();
    private LocalDateTime update_at = null;

    public FraudDomain save(ICreateFraudRepository iCreateFraudRepository){
        return iCreateFraudRepository.execute(this);
    }
    public FraudDomain checkActive(ICheckFraudActiveRepository iCheckFraudActiveRepository){
        return iCheckFraudActiveRepository.execute(this.document);
    }
    public FraudDomain disableFraud(IDisableFraudRepository iDisableFraudRepository){
        return iDisableFraudRepository.execute(this.document);
    }

    public List<FraudDomain> listFrauds(IListFraudsRepository iListFraudsRepository) {
        return iListFraudsRepository.execute();
    }

    public void delete(IDeleteFraudRepository iDeleteFraudRepository) {
        iDeleteFraudRepository.execute(this.id);
    }

}
