package aulas_jose.card_twitter.controllers;

import aulas_jose.card_twitter.cards.Card;
import aulas_jose.card_twitter.dto.CardDto;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/cards")

public class CardController {
    private List<Card> posts = new ArrayList<>();

    @PostMapping
    public Card creatCard(@RequestBody CardDto body) {
        Card newCard = new Card();

        newCard.setId(UUID.randomUUID().toString());
        newCard.setTitle(body.title());
        newCard.setDescription(body.description());

        posts.add(newCard);

        return newCard;
    }

    @PutMapping("/{id}")
    public Card atualizaCard(@PathVariable String id, @RequestBody CardDto card) {
        Card updatedData = null;
        for (Card data : posts ){
            if (data.getId().equals(id)) {
                data.setTitle(card.title());
                data.setDescription(card.description());
                updatedData = data;
            }
        }

        return  updatedData;
    }

    @DeleteMapping("/{id}")
    public String deleteCard(@PathVariable String id) {
        posts.removeIf(card -> card.getId().equals(id));

        return "Deletado";
    }

    @GetMapping("/all")
    public List<Card> getCard() {
        return posts;
    }

    @GetMapping("/{id}")
    public Card getCardById(@PathVariable String id) {
        Card card = posts.stream().filter(cardExisting -> cardExisting.getId().equals(id)).findFirst().get();

        return card;
    }
}
