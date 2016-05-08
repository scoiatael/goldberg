(ns goldberg.strategy
  (:require [clj-http.client :as client]
            [clojure.data.json :as json]))

(defn- get-information [query]
  (-> (str "https://api.duckduckgo.com/?q=" query "&format=json")
      client/get
      :body
      json/read-str
      (get "AbstractURL")
      client/get
      :body))

(defn- strategies-matcher [info]
  (re-matcher #"(rock|paper|scissors)" info))

(defn- find-all [matcher]
  (loop [matcher matcher
         vec []]
    (let [match (re-find matcher)]
      (if (nil? match)
        vec
        (recur
         matcher
         (->> match first (conj vec)))))))

(defn pick-position []
  (-> "rock+paper+scissors" get-information strategies-matcher find-all rand-nth keyword))
