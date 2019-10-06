# Styling

## General
* Indent 4 spaces except for HTML/CSS/Javascript
* Keep horizontal code length relatively short
* Choose self-descriptive variable & function names
* Avoid writing comments within code unless it's absolutely necessary

  Note that this does not refer to docstrings and the like
  
* Most importantly, refer to the [Google Style Guides](https://github.com/google/styleguide)

## Language Specific
### HTML
* Indentation: 2 spaces
### CSS
* Indentation: 2 spaces
### Javascript / Typescript
* Indentation: 2 spaces
* Run [Prettier](https://prettier.io/) on all .js files that have been edited
* Prettier can be run over all files in a specific directory by using 
  ``` prettier --write "**/*.js" ``` or ``` prettier --write "**/*.tsx" ```
* ATM there are issues with running prettier from within a Docker container so this should be installed locally
### Kotlin
* Run [Ktlint](https://github.com/pinterest/ktlint) on all .kt files that have been edited
* Follow the installation steps in the GitHub repo if on a Unix OS.
* If on windows, the ktlint file is already in `./backend/` and can simply be run using 
  `java -jar ./backend/ktlint ./backend/**/*.kt`
