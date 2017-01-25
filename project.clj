(defproject aniregcsv "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.8.0"]
               [org.clojure/java.jdbc "0.4.2"]
               [mysql/mysql-connector-java "5.1.38"]
               [org.clojure/data.csv "0.1.3"]]
  :main ^:skip-aot aniregcsv.core
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all}})
