package oddtest.controller;

import lombok.AllArgsConstructor;
import oddtest.apigenerated.OddsApi;
import oddtest.apigenerated.model.Odds;
import oddtest.service.OddsService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@AllArgsConstructor
@RestController
public class OddApiImpl implements OddsApi {

    private final OddsService oddsService;

    @Override
    public ResponseEntity<List<Odds>> oddsBetIdGet(@PathVariable("betId") Long betId) {
        return ResponseEntity.ok(oddsService.getOdds(betId));
    }

    @Override
    public ResponseEntity<Void> oddsPost(@Valid Odds body) {
        // submit the odd
        oddsService.saveOdd(body.getUserId(), body.getBetId(), body.getOdds());
        return ResponseEntity.noContent().build();
    }
}
