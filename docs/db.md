# Table explanations
## card
  * A card's due date is its `last_used` field + its pile's `freq` field (stored in minutes in db so must 
    be converted first to nanoseconds).
## deck
## deck_card
  * A card can exist in a deck without being in a pile (these cards are not in rotation)
## pile
  * A pile can exist in a deck without any cards so the deck_id FK is required to map this relationship
    without a card
  * `freq` is the number of minutes used to determine when a card in this pile is due
    * Refer to [card](#card) for how this is done
## side
## user
## user_deck