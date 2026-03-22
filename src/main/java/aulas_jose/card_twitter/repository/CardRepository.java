package aulas_jose.card_twitter.repository;

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
