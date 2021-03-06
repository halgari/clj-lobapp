(ns clj-lobapp.schema.init
  (:use [datomic.api :only [q db] :as d]
        [clojure.pprint :only [pprint]]))


; TODO: use a config variable here
(def uri "datomic:mem:://localhost:4334//clj-lobapp")

(d/create-database uri)
(def conn (d/connect uri))



(def schema-ns
  #{'clj-lobapp.schema.sch-users})

(defn get-schemas [ns]
  (require ns)
  (let [sch (filter #(:schema (meta %))
                    (vals (ns-publics (the-ns ns))))]
    (mapcat deref sch)))

(defn get-data [ns]
  (require ns)
  (let [sch (filter #(:data (meta %))
                    (vals (ns-publics (the-ns ns))))]
    (mapcat deref sch)))

(defn debug [x]
  (pprint x)
  x)

(defn init-schemas []
  (d/transact conn (mapcat get-schemas schema-ns)))

(defn init-data []
  (d/transact conn (mapcat get-data schema-ns)))

(defn query [qry]
  (q qry (db conn)))

(defn by-attr [attr val]
  [:find '?a '?b :where ['?l attr val]
   ['?l :login/name '?a ]
   ['?l :login/password '?b]])
