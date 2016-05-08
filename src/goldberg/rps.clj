(ns goldberg.rps
  (:refer-clojure :exclude [==])
  (:require [clojure.core.logic.pldb :as pldb]
            [clojure.core.logic :refer :all]
            [schema.core :as s]))

(pldb/db-rel rps winner verb loser)

(def ^:private facts
  (pldb/db
   [rps :scissors :cut :paper]
   [rps :rock :smaches :scissors]
   [rps :paper :covers :rock]))

(def ^:private hand (s/enum :rock :paper :scissors))
(def ^:private result (s/enum :first :second :tie))

(s/defn ^:always-validate
  check-result :- [(s/one result "result") (s/one s/Keyword "verb")]
  [p1 :- hand
   p2 :- hand]
  (first
   (pldb/with-db facts
     (run* [result verb]
       (conde
        [(rps p1 verb p2)
         (== result :first)]

        [(rps p2 verb p1)
         (== result :second)]

        [(== verb :matches)
         (== result :tie)])))))


(check-result :paper :scissors)
