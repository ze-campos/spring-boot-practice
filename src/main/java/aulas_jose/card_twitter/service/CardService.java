package aulas_jose.card_twitter.service;

import aulas_jose.card_twitter.controllers.dto.CardDto;
import aulas_jose.card_twitter.repository.CardRepository;
import aulas_jose.card_twitter.repository.entity.Card;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CardService {
    private final CardRepository cardRepository;

    public CardService(CardRepository cardRepository) {
        this.cardRepository = cardRepository;
    }

    public Card createNewCard(CardDto input) {
        Card newCard = new Card();

        newCard.setTitle(input.title());
        newCard.setDescription(input.description());

        cardRepository.save(newCard);

        return newCard;
    }

    public Card updateCardById(Long id, CardDto input) {
        Card data = cardRepository.findById(id).get();

        data.setTitle(input.title());
        data.setDescription(input.description());

        return cardRepository.save(data);
    }

    public void deleteCardById(Long id) {
        cardRepository.deleteById(id);
    }

    public List<Card> getAllCards() {
        return cardRepository.findAll();
    }

    public Card getCardById(Long id) {
        return cardRepository.findById(id).get();
    }
}