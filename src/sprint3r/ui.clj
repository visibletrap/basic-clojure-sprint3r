(ns sprint3r.ui
  (:require [seesaw.core :refer :all]))

(defn -main [& args]
  (invoke-later
    (-> (frame :title "Hello",
               :content "Hello, Seesaw",
               :on-close :exit)
        pack!
        show!)))

(-main)
; $ lein run -m sprint3r.ui