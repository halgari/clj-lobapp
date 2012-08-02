(ns clj-lobapp.schema.macros-test
  (:use [clj-lobapp.schema.macros]
        [midje.sweet]))


(fact
 (dissoc (gen-schema-column :news :title [:string :one :fulltext "A docstring"])
         :db/id)
  =>
  {:db/ident :news/title
   :db/valueType :db.type/string
   :db/cardinality :db.cardinality/one
   :db/fulltext true
   :db/doc "A docstring"
   :db.install/_attribute :db.part/db})
