package com.prafulla.msscbeerservice.web.mapper;

import com.prafulla.msscbeerservice.domain.Beer;
import com.prafulla.msscbeerservice.web.model.BeerDto;
import org.mapstruct.Mapper;

@Mapper(uses = DateMapper.class)
public interface BeerMapper {
    BeerDto beerToBeerDto(Beer beer);
    Beer beerDtoToBeer(BeerDto beerDto);
}
