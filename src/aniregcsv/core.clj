(ns aniregcsv.core
  (:require [clojure.java.jdbc :as j]
            [clojure.data.csv :as csv]
           )
  (:gen-class))
(defn csv-test
  []
  (with-open [in-file (clojure.java.io/reader "in-file.csv")]
    (doall
      (csv/read-csv in-file))))
(def db-map {:subprotocol "mysql"
             :subname "//server.domain.ba:3306/ifa5"
             :user "user"
             :password "pass"})
(defn slog
  []
  (zipmap
        [:culture_id :culture_type_id :final_pallet_id
         :end_type_id :warehouse_id :quantity
         :operator :note :status
         :operation_date]
        ["6" "2" "6271"
         "0" "1" "65.000"
         "ClojureTest" "Clojure" "0"
         "2017-01-26"]))
(def partmap
  (partial zipmap
           [:culture_id :culture_type_id :final_pallet_id
            :end_type_id :warehouse_id :quantity
            :operator :note :status
            :operation_date] ))
(defn csv-test-zipping
  []
  (with-open [in-file (clojure.java.io/reader "in-file.csv")]
    (map partmap
         (doall
           (csv/read-csv in-file)))))
(defn ifa5-select
  []
  (j/query db-map ["SELECT id, culture_id, culture_type_id, operator, note
                    FROM pallets_fpallets"]))
(defn ifa5-insert
  []
  (j/insert! db-map :pallets_fpallets (slog)))
(def ifa5-insert-part
  (partial j/insert! db-map :pallets_fpallets ))
(defn -main
  "Clojure CSV import into MySQL"
  [& args]
  (println "ConnAgrIS import test"))
