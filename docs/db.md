# Table explanations
## card
## deck
## deck_card
  * A card can exist in a deck without being in a pile (these cards are not in rotation)
## pile
  * A pile can exist in a deck without any cards so the deck_id FK is required to map this relationship
    without a card
## side
## user
## user_deck