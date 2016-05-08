(defproject goldberg "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.8.0"]
                 [clj-http "2.1.0"]
                 [org.clojure/core.logic "0.8.10"]
                 [prismatic/schema "1.1.1"]
                 [com.taoensso/timbre "4.3.1"]
                 [org.clojure/data.json "0.2.6"]]
  :main ^:skip-aot goldberg.core
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all}})
