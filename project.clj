(defproject clj-lobapp "0.1.0-SNAPSHOT"
  :description "A Line of Business App in Clojure"
  :url "http://github.com/halgari/clj-lobapp"
  :profiles {:dev {:plugins [[lein-midje "2.0.0-SNAPSHOT"]]}}
  :dependencies [[org.clojure/clojure "1.4.0"]
                 [com.datomic/datomic-free "0.8.3343"]
                 [midje "1.4.0"]])
