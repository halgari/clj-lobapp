(ns clj-lobapp.schema.sch-users
    (:use [datomic.api :only [q db] :as d]))

#_(defschema :login
    :login-name [:string :one :fulltext "A user's login name"]
    :password [:string :one "The password"]
    :user [:ref :one "User Account for this login"])

#_(defschema :user
    :first-name [:string :one :fulltext "First Name"]
    :last-name [:string :one :fulltext "Last Name"])
