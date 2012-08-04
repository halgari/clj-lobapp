(ns clj-lobapp.schema.sch-users
  (:use [datomic.api :only [q db] :as d]
        [clj-lobapp.schema.macros]))

(defschema :login
    :name [:string :one :fulltext "A user's login name"]
    :password [:string :one "The password"]
    :user [:ref :one "User Account for this login"])

(defschema :user
    :first [:string :one :fulltext "First Name"]
    :last [:string :one :fulltext "Last Name"])

(def ^:data logins
  [{:db/id #db/id[:db.part/user]
     :login/name "admin"
    :login/password "changeme"}
   {:db/id #db/id[:db.part/user]
     :login/name "guest"
    :login/password "password"}])
