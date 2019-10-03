# Authorization 
## Obtaining tokens
## Making requests with tokens

# `/api/cards/`

# `/api/deck_cards/`
  * Returned body (will be in an array `[]` if more than one)
    ```
      {
        "id": 1,
        "deck": {
          "id": 1,
          "name": "Leslie's Deck",
          "imageUrl": "http://plugga.com/somefakeimage.jp",
          "dateCreated": "2019-09-05T22:55:02.000+0000"
        },
        "card": {
          "id": 1,
          "lastUsed": "2019-09-06T15:10:39.000+0000"
        },
        "pile": {
          "id": 1,
          "rank": 1,
          "freq": 1
        }
      }
    ```
### GET
  * All objects `/api/deck_cards/`
  * All by deckId `/api/deck_cards?deckId={deckId}`
  * All by cardId `/api/deck_cards?cardId={cardId}`
  * By deckCardId `/api/deck_cards/{deckCardId}`
### POST
  * URL `/api/deck_cards/`
  * Request body. Each field below represents the respective id's `(deckId, cardId, pileId)`
  ```
    {
        "deck": 2,
        "card": 7,
        "pile": 1
    }
  ```
### PUT
  * URL `/api/deck_cards/`
  * Request body. Each field below represents the respective id's `(deckCardId, deckId, cardId, pileId)`
  ```
    {
        "id": 24,
        "deck": 4,
        "card": 7,
        "pile": 1
    }
  ```
### DELETE
  * URL `/api/deck_cards/{deckCardId}`
  * Returns `"Deleted deckCard with id: " + deckCardId`

# `/api/decks/`
# `/api/piles/`
# `/api/sides/`
# `/api/user_decks/`
  * Returned body (will be in an array `[]` if more than one)
  ```
    {
      "user": {
          "id": 1,
          "name": "Leslie",
          "email": "leslie@plugga.com",
          "dateCreated": "2019-07-12T00:55:46.000+0000",
          "lastLogin": null
      },
      "deck": {
          "id": 1,
          "name": "Leslie's Deck",
          "imageUrl": "http://plugga.com/somefakeimage.jp",
          "dateCreated": "2019-09-05T22:55:02.000+0000"
      }
    }
  ```
### GET
  * All objects `/api/user_decks/`
  * All by deckId `/api/user_decks?deckId={deckId}`
  * All by userId `/api/user_decks?userId={userId}`
  * By userDeckId `/api/user_decks/{userDeckId}`
  
### POST
  * URL `/api/user_decks/`
  * Request body. Each field below represents the respective id's `(userId, deckId)`
  ```
    {
      "user": 1,
      "deck": 7
    }
  ```
### PUT
### DELETE

# `/api/users/`
