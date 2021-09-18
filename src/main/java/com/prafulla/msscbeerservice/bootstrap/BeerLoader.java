package com.prafulla.msscbeerservice.bootstrap;

import com.prafulla.msscbeerservice.domain.Beer;
import com.prafulla.msscbeerservice.repository.BeerRepository;
import com.prafulla.msscbeerservice.web.model.BeerDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
@Slf4j
public class BeerLoader implements CommandLineRunner {
    
    private final BeerRepository beerRepository;
    
    public BeerLoader(BeerRepository beerRepository) {
        this.beerRepository = beerRepository;
    }
    
    @Override
    public void run(String... args) throws Exception {
        loadBeerObjects();
        
    }
    
    private void loadBeerObjects() {
        if(this.beerRepository.count() == 0) {
            beerRepository.save(Beer.builder()
                    .beerName("Mango Bobs")
                    .beerStyle("IPA")
                    .quantityToBrew(200)
                    .upc(132123123123L)
                    .minOnHand(12)
                    .price(new BigDecimal(12.3))
                    .build());
    
            beerRepository.save(Beer.builder()
                    .beerName("Galaxy Cat")
                    .beerStyle("PALE_ALE")
                    .quantityToBrew(200)
                    .upc(132123123124L)
                    .minOnHand(12)
                    .price(new BigDecimal(12.3))
                    .build());
        }
        
        log.info("Beers in Repo: " + beerRepository.count());
        log.info("Thread : " + Thread.currentThread().getName() + ", Class Loader: " + 
                BeerLoader.class.getClassLoader()+ ", Beer: " +
                BeerDto.class.getClassLoader());
    }
}
