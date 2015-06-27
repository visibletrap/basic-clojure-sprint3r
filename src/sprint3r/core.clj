(ns sprint3r.core)

; REPL
(+ 1 2 3)
*1
*2
(println "Hello, World")

; Function
(defn hello [name]
  (str "Hello, " name))
(hello "Clojure")

; Multi-arity
(defn hello2
  ([] "Hello")
  ([name] (str "Hello, " name))
  ([name1 name2]
   (str "Hello, " name1
        " and " name2)))
(hello2)
(hello2 "Dave")
(hello2 "Michelle" "Michael")

; Variable arguments
(defn print-numbers [num1 & rest]
  (println num1)
  (println rest)
  (println (first rest)))
(print-numbers 1)
(print-numbers 1 2)
(print-numbers 1 2 3)

; Anonymous function
(fn [n] (* n 2))
((fn [n] (* n 2)) 3)

(def x "X-men")
x

(def mul3
  (fn [n] (* n 3)))
(mul3 2)

; Short hand
(#(println % %1 %2 %&) 1 2)
(macroexpand '#())
(macroexpand '#(+ 1 %))
(#(+ 1 %) 2)
(#(+ 1 %1 %2) 2 3)
(#(println %&) 5 6 7 8)

; _ for don't care
(defn print-second [_ a] (println a))
(print-second 1 3)

;; Exercise 1
(declare calls)
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

; let
(let [a "Apple"
      b "Bird"
      c (str b " eats " a)
      _ "??"]
  (println a)
  (println b)
  (println c))

; apply
(defn var-args [& args]
  (println args))
(var-args "A" "B" "C")
(defn plus [& args]
  (apply + args))
(plus 1 2 3 4)

; if
(defn bool [a]
  (if a
    "True"
    "False"))
(bool true)
(bool false)

; Truthiness
(bool nil)
(bool 1)
(bool "String")
(bool "")

; do
(do (+ 1 2)
    (* 2 3))

(defn ifs [x]
  (if x
    (do (println "True")
        100)
    (do (println "False")
        (println ":("))))
(ifs true)
(ifs true)
(ifs false)

