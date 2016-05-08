# goldberg

## Getting started with Clojure

1. Get [Leiningen](http://leiningen.org/).
2. Generate new project with `lein new app <NAME>`
3. Open `project.clj`
4. Add your dependencies to `:dependencies` map
5. Run `lein deps` to fetch them.
6. Edit code in `src/<NAME>/core.clj`
7. Run with `lein run`

## Description

This is very simple Goldberg machine. It runs simulation of Rock-Paper-Scissors and outputs:
* 'Hello Wor1d!' if first player wins,
* 'Hello W0rld!' if 2nd player wins,
* and 'Hello World!' otherwise.

It uses 'duckduckgo' search engine and Wikipedia to find strategies for both players.

* `src/goldberg/rps.clj` contains Rock-Paper-Scissors implementation, using `clojure.core.logic` (for predicates), and `pristmatic/schema` (for adding type descriptions to main function)
* `src/goldberg/strategy.clj` contains function for picking hand
* `src/goldberg/core.clj` glues both modules together, adds some logging, and outputs result.
