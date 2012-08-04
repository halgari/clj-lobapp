(ns clj-lobapp.schema.init-test
  (:use [clj-lobapp.schema.init]
        [clj-lobapp.schema.macros]
        [midje.sweet]))

(defschema :schtest
    :foo [:string :one :fulltext "foo"])


(fact (get-schemas 'clj-lobapp.schema.init-test)
      => schtest)

(init-schemas)
(init-data)
