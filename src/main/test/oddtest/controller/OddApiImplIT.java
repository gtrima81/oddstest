package oddtest.controller;

import oddtest.apigenerated.model.Odds;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@RunWith(SpringRunner.class)
public class OddApiImplIT {

    @Autowired
    protected TestRestTemplate restTemplate;

    @Test
    public void getOddsGivenABidId() {
        // given
        Long bidId = Long.valueOf(1212);

        // when
        ResponseEntity<ArrayList<Odds>> response = restTemplate.exchange("/odds/" + bidId, HttpMethod.GET, HttpEntity.EMPTY, new ParameterizedTypeReference<>() {});

        // then
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);

        ArrayList<Odds> odds = response.getBody();
        assertThat(odds.size()).isEqualTo(3);
    }

    @Test
    public void getOddsGivenABidIdNotFound() {
        // given
        Long bidId = 0L;// I m forcing a BetNotFoundException in the OddsService

        // when
        ResponseEntity<ArrayList<Odds>> response = restTemplate.exchange("/odds/" + bidId, HttpMethod.GET, HttpEntity.EMPTY, new ParameterizedTypeReference<>() {});

        // then
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.NOT_FOUND);
    }

    @Test
    public void getOddsInvalidBidId() {
        // given
        String bidId = "AAA";

        // when
        ResponseEntity<Object> response = restTemplate.exchange("/odds/" + bidId, HttpMethod.GET, HttpEntity.EMPTY, new ParameterizedTypeReference<>() {});

        // then
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.BAD_REQUEST);
    }

    @Test
    public void postOdds(){
        // given
        Odds odds = getNewOdds();

        // when
        ResponseEntity<Void> response = restTemplate.exchange("/odds", HttpMethod.POST, new HttpEntity<>(odds), Void.class);

        // then
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.CREATED);
    }

    @Test
    public void postOddsBadRequest(){
        // given
        Odds odds = getNewOdds();
        odds.setOdds("0/9");

        // when
        ResponseEntity<Void> response = restTemplate.exchange("/odds", HttpMethod.POST, new HttpEntity<>(odds), Void.class);

        // then
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.BAD_REQUEST);
    }

    private Odds getNewOdds(){
        Odds odds = new Odds();
        odds.setOdds("2/10");
        odds.setBetId(1233L);
        odds.setUserId("1234");

        return odds;
    }
}