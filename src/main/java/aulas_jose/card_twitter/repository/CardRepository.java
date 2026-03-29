package aulas_jose.card_twitter.repository;

import aulas_jose.card_twitter.repository.entity.Card;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CardRepository extends JpaRepository<Card, Long> {
}
