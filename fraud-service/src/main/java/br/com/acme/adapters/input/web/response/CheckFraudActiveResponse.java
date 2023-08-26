package br.com.acme.adapters.input.web.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CheckFraudActiveResponse {
    private String document;
    private boolean active;
    private LocalDateTime update_at;
}
