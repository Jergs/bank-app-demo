package com.havryliuk.yehor.bank.app.demo.service.impl;

import com.havryliuk.yehor.bank.app.demo.mapper.CardMapper;
import com.havryliuk.yehor.bank.app.demo.model.entity.Card;
import com.havryliuk.yehor.bank.app.demo.model.response.CardDetailsResponse;
import com.havryliuk.yehor.bank.app.demo.repository.CardRepository;
import com.havryliuk.yehor.bank.app.demo.service.CardService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class CardServiceImpl implements CardService {

    private final CardRepository repository;

    public List<CardDetailsResponse> getCardsByCustomerId(Integer id) {
        var cards = repository.findByCustomerId(id);
        log.debug("Found cards with ids {}", cards.stream().map(Card::getCardId).toList());

        return CardMapper.INSTANCE.map(cards);
    }
}
