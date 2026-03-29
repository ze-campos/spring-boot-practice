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

    CardController(CardService cardService) {
        this.cardService = cardService;
    }

    @PostMapping
    public Card createCard(@RequestBody CardDto body) {
        return cardService.createNewCard(body);
    }

    @PutMapping("/{id}")
    public Card atualizaCard(@PathVariable Long id, @RequestBody CardDto card) {
        return cardService.updateCardById(id, card);
    }

    @DeleteMapping("/{id}")
    public String deleteCard(@PathVariable Long id) {
        cardService.deleteCardById(id);

        return "Deletado";
    }

    @GetMapping("/all")
    public List<Card> getCard() {
        return cardService.getAllCards();
    }

    @GetMapping("/{id}")
    public Card getCardById(@PathVariable Long id) {
       return cardService.getCardById(id);
    }
}
