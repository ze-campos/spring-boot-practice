package aulas_jose.card_twitter.service;

import aulas_jose.card_twitter.controllers.dto.CardDto;
import aulas_jose.card_twitter.repository.CardRepository;
import aulas_jose.card_twitter.repository.entity.Card;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class CardService {
    private final CardRepository cardRepository;

    public CardService(CardRepository cardRepository) {
        this.cardRepository = cardRepository;
    }

    public Card createNewCard(CardDto input) {
        Card newCard = new Card();

        newCard.setId(UUID.randomUUID().toString());
        newCard.setTitle(input.title());
        newCard.setDescription(input.description());

        cardRepository.save(newCard);

        return newCard;
    }

    public List<Card> getAllCards() {
        return cardRepository.getAllCards();
    }

    public Card getCardById(String id) {
        return cardRepository.getCardById(id);
    }
}