package br.com.acme.adapters.output.external;

import br.com.acme.adapters.input.web.api.response.CardResponse;
import br.com.acme.adapters.output.external.response.CardsAvailableClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(value = "getcards", url ="${card.getcards.url}")
public interface GetCardsAvailableToClient {
    @GetMapping(value = "/income/{income}", consumes = "application/json")
    List<CardResponse> getCardsAvailable(@PathVariable("income") String income);
}
