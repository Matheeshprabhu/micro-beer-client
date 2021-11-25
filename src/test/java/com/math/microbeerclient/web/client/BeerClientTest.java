package com.math.microbeerclient.web.client;

import com.math.microbeerclient.web.model.BeerDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.net.URI;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BeerClientTest {

    @Autowired
    BeerClient beerClient;

    @Test
    void getBeerByIdTest() {
        BeerDto beerDto = beerClient.getBeerById(UUID.randomUUID());
        assertNotNull(beerDto);
        System.out.println(beerDto.getBeerName() + " " + beerDto.getBeerStyle() + " " + beerDto.getId());
    }

    @Test
    public void saveNewBeerTest(){

        BeerDto beerDto = BeerDto.builder().beerName("test beer").build();
        URI uri = beerClient.saveNewBeer(beerDto);

        assertNotNull(uri);
        System.out.println(uri);
    }

    @Test
    public void updateBeerTest(){

        BeerDto beerDto = BeerDto.builder().beerStyle("can").build();
        beerClient.updateBeer(UUID.randomUUID(),beerDto);
    }

    @Test
    public void deleteBeer(){
        beerClient.deleteBeer(UUID.randomUUID());
    }
}