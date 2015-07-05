(defproject sprint3r "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.6.0"]
                 [ring/ring-core "1.4.0-RC2"]
                 [ring/ring-jetty-adapter "1.4.0-RC2"]]
  :plugins [[lein-ring "0.9.6"]]
  :ring {:handler sprint3r.web/handler}
  :aot [sprint3r.main]
  :main sprint3r.main)
