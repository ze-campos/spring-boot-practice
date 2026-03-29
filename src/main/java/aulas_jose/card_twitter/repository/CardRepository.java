package aulas_jose.card_twitter.repository;

import aulas_jose.card_twitter.controllers.dto.CardDto;
import aulas_jose.card_twitter.repository.entity.Card;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CardRepository {
    private final List<Card> posts = new ArrayList<>();

    public Card save(Card card) {
        posts.add(card);

        return card;
    }

    public Card updateCardById(String id, CardDto input) {
        Card updatedData = null;
        for (Card data : posts ){
            if (data.getId().equals(id)) {
                data.setTitle(input.title());
                data.setDescription(input.description());
                updatedData = data;
            }
        }

        return updatedData;
    }

    public void deleteCardById(String id) {
        posts.removeIf(card -> card.getId().equals(id));
    }

    public List<Card> getAllCards() {
        return posts;
    }

    public Card getCardById(String id) {
        return posts.stream().filter(cardExisting -> cardExisting.getId().equals(id)).findFirst().get();
    }
}
