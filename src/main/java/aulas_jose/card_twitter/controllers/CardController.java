package aulas_jose.card_twitter.controllers;

import aulas_jose.card_twitter.repository.entity.Card;
import aulas_jose.card_twitter.controllers.dto.CardDto;
import aulas_jose.card_twitter.service.CardService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cards")
public class CardController {
    private final CardService cardService;
    private static final String JOSE = "Te amo";

    CardController(CardService cardService) {
        this.cardService = cardService;
    }

    @PostMapping
    public Card createCard(@RequestBody CardDto body) {
        return cardService.createNewCard(body);
    }

//    @PutMapping("/{id}")
//    public Card atualizaCard(@PathVariable String id, @RequestBody CardDto card) {
//        Card updatedData = null;
//        for (Card data : posts ){
//            if (data.getId().equals(id)) {
//                data.setTitle(card.title());
//                data.setDescription(card.description());
//                updatedData = data;
//            }
//        }
//
//        return  updatedData;
//    }
//
//    @DeleteMapping("/{id}")
//    public String deleteCard(@PathVariable String id) {
//        posts.removeIf(card -> card.getId().equals(id));
//
//        return "Deletado";
//    }

    @GetMapping("/all")
    public List<Card> getCard() {
        return cardService.getAllCards();
    }

    @GetMapping("/{id}")
    public Card getCardById(@PathVariable String id) {
       return cardService.getCardById(id);
    }
}
