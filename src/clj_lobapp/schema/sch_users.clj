(ns clj-lobapp.schema.sch-users
    (:use [datomic.api :only [q db] :as d]))

(defschema :login
    :login-name [:string :one :fulltext "A user's login name"]
    :password [:string :one "The password"]
    :user [:ref :one "User Account for this login"])

(defschema :user
    :first-name [:string :one :fulltext "First Name"]
    :last-name [:string :one :fulltext "Last Name"])
    
    
