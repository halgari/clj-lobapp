(ns clj-lobapp.schema.macros
  (:use [datomic.api :only [q db] :as d]))

(def keymaps
  {:string :db/valueType
   :ref :db/valueType
   :fulltext :db/fulltext
   :one :db/cardinality
   :many :db/cardinality})

(def valuemaps
  {:string :db.type/string
   :ref :db.type/ref
   :fulltext true
   :one :db.cardinality/one
   :many :db.cardinality/many})

(defn map-key [x]
  (cond (string? x) :db/doc
        (contains? keymaps x) (keymaps x)
        :else (assert false)))

(defn map-value [x]
  (cond (string? x) x
        (contains? valuemaps x) (valuemaps x)
        :else (assert false)))


(defn gen-schema-column [schema nm specs]
  (let [ident (keyword (name schema) (name nm))]
    (-> (zipmap (map map-key specs)
                (map map-value specs))
        (merge {:db/id (d/tempid :db.part/db)
                :db/ident ident
                :db.install/_attribute :db.part/db}))))

(defmacro defschema [nm & attrs]
    (let [cols (map #(apply gen-schema-column nm %)
                    (partition 2 attrs))]
        `(def ~(with-meta (symbol (name nm)) {:schema true})
               [~@cols])))
