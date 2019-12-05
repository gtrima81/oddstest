package oddtest.service;

import oddtest.apigenerated.model.Odds;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OddsService {

    public List<Odds> getOdds(Long betId){
        return List.of(getRandomOdd(betId), getRandomOdd(betId), getRandomOdd(betId));
    }

    public void saveOdd(String userId, Long oddId, String odd){
        // here we could have the repository interface that will do the dirty job to store the odd
        // oddRepository.save(new Odds()) <-- something to say about the Odds model class
    }

    // this is just for the test purpose
    private Odds getRandomOdd(Long betId){
        Odds odds = new Odds();
        odds.setBetId(betId);
        odds.setOdds("1/10");
        odds.setUserId("12435");

        return odds;
    }
}
