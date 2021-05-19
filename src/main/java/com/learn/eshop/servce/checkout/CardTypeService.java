package com.learn.eshop.servce.checkout;

import com.learn.eshop.domain.CardType;
import com.learn.eshop.repository.jpa.CardTypeRepository;
import com.learn.eshop.repository.schema.CardTypeEntity;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CardTypeService {
  private final CardTypeRepository cardTypeRepository;

  public CardTypeService(CardTypeRepository cardTypeRepository) {
    this.cardTypeRepository = cardTypeRepository;
  }

  public List<CardType> getAllCardType() {
    var entities = cardTypeRepository.findAllByOrderByCardType();
    return entities.stream().map(this::entityToDomain).collect(Collectors.toList());
  }


  private CardType entityToDomain(CardTypeEntity entity) {
    var domain = new CardType();
    BeanUtils.copyProperties(entity, domain);
    return domain;
  }

}
