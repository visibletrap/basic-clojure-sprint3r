(ns sprint3r.sol1)

;; Solution 1
(defn calls
  ([] (println "Nothing"))
  ([a] (a))
  ([a b] (a) (b))
  ([a b c] (a) (b) (c))
  ([_ _ _ & x] ((last x))))

(calls)
(calls #(println 1))
(calls #(println 1)
       #(println 2))
(calls #(println 1)
       #(println 2)
       #(println 3))
(calls #() #() #() #(println 4))
(calls #() #() #() #() #() #()
       #() #() #() #() #() #()
       #() #() #() #() #() #()
       #(println "Last"))