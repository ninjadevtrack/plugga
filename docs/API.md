# Authorization 
## Obtaining tokens
## Making requests with tokens

# `/api/cards/`
  * Returned body (will be in an array `[]` if more than one). 
    See section on `/api/sides/` for info on what is in 'sides' field.
    See section on `/api/deck_cards/` for info on what is in 'decks' field.
    
    ```
    {
      "id": 1,
      "lastUsed": "2019-09-06T15:10:39.000+0000",
      "sides": [],
      "decks": []
    }
    ```

### GET
  * All objects `/api/cards/`
  * All by deckId `/api/cards?deckId={deckId}`
  * By cardId `/api/cards/{cardId}`
  
### POST
 * URL `/api/cards/`
 * Request body. All fields are optional.
   * `lastUsed` can be omitted, null, or a timestamp.
   * `sides` can be omitted, an empty array `[]`, or populated with sideIds.
   * `decks` can be omitted, an empty array `[]`, or populated with deckIds.
   * If all three fields are omitted, simply send an empty object `{}`
 ```
{
	"lastUsed": "2019-09-05T22:55:02.000+0000",
	"sides": [1, 3],
	"decks": [2, 7]
}
 ```
 
### PUT
 * URL `/api/cards/`
 * Request body. See POST section above
 
### DELETE
  * URL `/api/cards/{cardId}`
  * Returns `"Deleted card with id: {cardId}"`
  
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
  * Returns `"Deleted deckCard with id: {deckCardId}"`

# `/api/decks/`
  * Returned body (will be in an array `[]` if more than one). 
    
    ```
    { 
      "id": 1,
      "name": "Leslie's Deck",
      "imageUrl": "http://plugga.com/somefakeimage.jp",
      "dateCreated": "2019-09-05T22:55:02.000+0000",
    }
    ```

### GET
  * All objects `/api/decks/`
  * All by userId `/api/decks?userId={userId}`
  * By deckId `/api/decks/{deckId}`
  
### POST
  * URL `/api/decks/`
  * Request body. All fields are optional.
    * If all fields are omitted, simply send an empty object `{}`
  ```
  {
    "name": "Deck Name",
    "imageUrl": null
  }
  ```
 
### PUT
 * URL `/api/decks/`
 * Request body. Note that 'dateCreated' cannot be updated
  ```
  {
  	"id": 16,
  	"name": "New name",
  	"imageUrl": "updated-url"
  }
  ```
 
### DELETE
  * URL `/api/cards/{cardId}`
  * Returns `"Deleted card with id: {cardId}"`
  
# `/api/piles/`
# `/api/sides/`
  * Returned body (will be in an array `[]` if more than one)
  ```
  {
    "id": 33,
    "card": 17,
    "imageUrl": "http://plugga.com/static/some_card_image.gif",
    "text": "Who was the second man to walk on the moon?"
  }
  ```

### GET
  * All objects `/api/sides/`
  * All by cardId `/api/sides?cardId={cardId}`
  * By sideId `/api/sides/{sideId}`

### POST
  * URL `/api/sides/`
  * Request body. Each field below represents the respective id's `(cardId)`
  ```
  {
    "card": 7,
  	"imageUrl": "http://plugga.com/static/some_card_image.gif",
  	"text": "side-text-here"
  }
  ```
### PUT
  * URL `/api/sides/`
  * Request body. Each field below represents the respective id's `(sideId, cardId)`
  ```
  {
	"id": 33,
    "card": 7,
    "imageUrl": "updated-url",
    "text": "updated-text"
  }
  ```
  
### DELETE
  * URL `/api/sides{sideId}`
  * Returns `"Deleted side with id: {sidesId}"`
  
# `/api/user_decks/`
  * Returned body (will be in an array `[]` if more than one)
  ```
    {
      "id": 1,
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
  * URL `/api/user_decks/`
  * Request body. Each field below represents the respective id's `(userDeckId, userId, deckId)`
  ```
    {
	  "id": 1,
	  "user": 1,
	  "deck": 7
    }
  ```
### DELETE
  * URL `/api/user_decks/{userDeckId}`
  * Returns `"Deleted userDeck with id: {userDeckId}"`

# `/api/users/`
