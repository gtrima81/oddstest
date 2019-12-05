package oddtest.controller;

import oddtest.apigenerated.OddsApi;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import oddtest.apigenerated.model.*;

import javax.validation.Valid;

@RestController
public class OddApiImpl implements OddsApi {

    @Override
    public ResponseEntity<List<Odds>> oddsBetIdGet(@PathVariable("betId") Long betId) {
        return null;
    }

    @Override
    public ResponseEntity<Void> oddsPost(@Valid Odds body) {
        return null;
    }
}
