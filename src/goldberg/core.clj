(ns goldberg.core
  (:gen-class)
  (:require [taoensso.timbre :as timbre :refer [info]]
            [goldberg.strategy :refer [pick-position]]
            [goldberg.rps :refer [check-result]]))

(defn p1wins []
  (info "Player 1 won.")
  (println "Hello wor1d!"))

(defn p2wins []
  (info "Player 2 won.")
  (println "Hello w0rld!"))

(defn tie []
  (info "Game ended with a tie.")
  (println "Hello world!"))

(defn -main
  []
  (let [p1 (pick-position)
        p2 (pick-position)]
    (info "Player 1 has chosen" p1)
    (info "Player 2 has chosen" p2)
    (case (-> (check-result p1 p2) first)
      :first (p1wins)
      :second (p2wins)
      (tie))))
