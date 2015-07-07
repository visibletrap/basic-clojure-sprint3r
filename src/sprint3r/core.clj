(ns sprint3r.core
  (:import (java.util ArrayList)))

; REPL
(+ 1 2 3)
*1
*2
(println "Hello, World")
; https://www.4clojure.com/problem/2

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
; https://www.4clojure.com/problem/14
; https://www.4clojure.com/problem/15

; let
(let [a "Apple"
      b "Bird"
      c (str b " eats " a)
      _ "??"]
  (println a)
  (println b)
  (println c))
; https://www.4clojure.com/problem/35
; https://www.4clojure.com/problem/36

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

; Vector
[\a \b \c]
(get [\a \b \c] 0)
([\a \b \c] 1)
(count [1 2 3])
(conj [1 2 3] 4 5 6)
(def a [1 2 3])
(conj a 4)
(def b (conj a 5))
a
b
(assoc [1 2 3] 0 4)
(vector 1 2 3)
; https://www.4clojure.com/problem/6
; https://www.4clojure.com/problem/7

; List
'(1 2 3)
(list 1 2 3)
(conj '(1 2 3) 4)
(nth '(1 2 3) 1)
(peek '(1 2 3))
(pop '(1 2 3))
; https://www.4clojure.com/problem/4
; https://www.4clojure.com/problem/5

; Map
{:a 1 :b 2}
(assoc {:a 1 :b 2} :c 3)
(assoc {:a 1 :b 2} :a 3)
(dissoc {:a 1 :b 2} :a)
(dissoc {:a 1 :b 2 :c 3} :a :b)
(get-in {:a {:b {:c {:d 5}}}} [:a :b :c :d])
(assoc-in {:a {:b {:c {:d 5}}}} [:a :b :c :d] 6)
(def c (merge {:a 1 :b 2} {:c 3}))
c
(keys c)
(vals c)

(get c :a)
(get c :d)
(get c :d 4)
(:a c)
(:d c)
(:d c 4)
(c :a)
(c :d)
(c :d 4)

(if ({:a 1} :a) "has A" "doesn't have A")
(if ({:b 1} :a) "has A" "doesn't have A")
; https://www.4clojure.com/problem/10
; https://www.4clojure.com/problem/11

; Mix
(get-in {:a {:b {:c 1}}} [:a :b :c])
(update-in {:a {:b {:c {:d 5}}}} [:a :b :c :d] inc)
(update-in {:a {:b {:c {:d 5}}}} [:a :b :c :d] * 3)
(update-in {:a {:b [{:z 1} {:y {:x 10}}]}} [:a :b 1 :y :x] #(if (odd? %) (inc %) (dec %)))
(assoc-in [1 {:a [2 {:b 3}]}] [1 :a] 4)

; Set
#{1 2}
(conj #{1 2} 3)
(conj #{1 2} 2)
(disj #{1 2} 2)
(disj #{1 2} 3)
(contains? #{1 2} 2)
(#{1 2} 2)
(#{1 2} 3)
; https://www.4clojure.com/problem/8
; https://www.4clojure.com/problem/9
; https://www.4clojure.com/problem/47

; Collection functions

; Seq
(seq [1 2 3])
(map inc [0 1 2])
(map inc '(0 1 2))
(map inc #{1 2 3})

; Lazy Seq
(range 5)
(take 3 (range 5))
(take 5 (iterate inc 10))

; Some useful functions
(first {:a 1 :b 2})
(rest [0 1 2 3])
(count #{1 2 3})
(empty? {})
(some {:a 1 :b 2} [:a :b])
(every? pos? [1 2 3])
(not-any? pos? [-1 -2 -3])
(filter even? (range 10))
(remove odd? (range 10))
(take 10 (cycle [1 2 3]))
(mapcat reverse [[1 2 3] [4 5 6] [7 8 9]])
(take-while vector? [[1] [2] '(3)])
(group-by :name [{:name "David" :age 36} {:name "Michael" :age 40} {:name "David" :age 25}])
(butlast [1 2 3 4 5])
(partition-by #(= 3 %) [1 2 3 4 5])
(partition 4 (range 18))
(sort-by :age [{:name "David" :age 36} {:name "Michael" :age 40} {:name "David" :age 25}])
(ffirst [[8 9] [7 5]])
(frequencies ['a 'b 'a 'a])
; https://www.4clojure.com/problem/12
; https://www.4clojure.com/problem/13
; https://www.4clojure.com/problem/17
; https://www.4clojure.com/problem/18
; https://www.4clojure.com/problem/20
; https://www.4clojure.com/problem/31


[{:name "David" :age 36}
 {:name "Michael" :age 40}
 {:name "David" :age 25}]
(take 3 (sort-by #(count (vals %)) ()))

; Vector destructuring
(defn v-dest [[a [b _ c] :as z]]
  [a b c z])
(def nv [10 [20 30 40] 50])
(v-dest nv)
(let [[a [b _ c] :as z] nv]
  [z c b a])
; https://www.4clojure.com/problem/52
; https://www.4clojure.com/problem/51

; Map destructuring
(defn m-dest
  [{a :x b :y :keys [c d] :as z}]
  [a b c d z])
(def nm {:x 1 :y "B" :c \C :d 4.0})
(m-dest nm)
(let [{a :x b :y :keys [c d] :as z} nm]
  [z d c b a])

; Mix
(let [[_ {:keys [b]}] [{:a 1 :b 2} {:a 3 :b 4}]]
  b)

; Thread First
(subvec (assoc (conj (conj [1 2 3] 4) 5) 1 1.5) 1 3)
(-> [1 2 3]
    (conj 4)
    (conj 5)
    (assoc 1 1.5)
    (subvec 1 3))
; https://www.4clojure.com/problem/71

; Thread Last
(frequencies (filter odd? (map inc (take 10 (repeatedly #(rand-int 11))))))
(->> (repeatedly #(rand-int 11))
     (take 10)
     (map inc)
     (filter odd?)
     (frequencies))

(macroexpand-1
  '(->> [1 2 3]
        (map #(* 3))
        (remove odd?)))
; https://www.4clojure.com/problem/72

; Java interop
(Math/sqrt 9)
(Integer/parseInt "10")
(java.util.UUID/randomUUID)
(def ja (ArrayList.))
(.add ja 1)
ja
(class ja)

; future
(do
  (future (Thread/sleep 4000)
          (println "Slow"))
  (future (Thread/sleep 2000)
          (println "Fast")))

; delay
(def de (delay (println "Expensive operation")
               "Return value"))
de
(deref de)
@de
(future 1)
@(future 2)

; promise
(def pm (promise))
(future (Thread/sleep 2000)
        (deliver pm "value"))
; ... do something else
@pm

; atom
(def at (atom 10))
(reset! at 11)
at
@at
(swap! at * 5)
(swap! at * 6)
(swap! at * 7)
(swap! at * 8)
@at
(def m (atom {1 {:name "Kyle" :score 2} 2 {:name "Tim" :score 6}}))
(defn plus-five [v]
  (+ v 5))
(swap! m update-in [1 :score] plus-five)

; agent
(def ag (agent [5 9]))
(defn slow-conj [coll x]
  (Thread/sleep 10000)
  (println "expensive")
  (conj coll x))
(send ag slow-conj 15)
@ag

; pmap
(def base "https://en.wikipedia.org/wiki/")
(def players [{:name "Manuel_Neuer" :word "Germany"}
              {:name "Franck_Ribéry" :word "France"}
              {:name "Andrés_Iniesta" :word "Spain"}
              {:name "Xavi" :word "Spain"}])
(defn count-word [{:keys [name word]}]
  (->> name
       (str base)
       (slurp)
       (re-seq (re-pattern word))
       (count)))
(time (->> players
           (map (juxt :name count-word))
           (println)))
(time (->> players
           (pmap (juxt :name count-word))
           (println)))

; Recursion
(defn repeat-inc [c n]
  (if (= c n)
    "Success"
    (repeat-inc (inc c) n)))
(repeat-inc 0 5)
(repeat-inc 0 1000000)
(defn repeat-inc-recur [c n]
  (if (= c n)
    "Success"
    (recur (inc c) n)))
(repeat-inc-recur 0 1000000)
(defn repeat-inc-loop [n]
  (loop [c 0]
    (if (= c n)
      "Success"
      (recur (inc c)))))
(repeat-inc-loop 1000000)
; https://www.4clojure.com/problem/68

; Require
(comment
  (upper-case "a")
  )
(clojure.string/upper-case "a")
(require '[clojure.string :as string])
(string/upper-case "a")
(require '[clojure.string :refer [upper-case]])
(upper-case "a")
(ns sprint3r.core
  (:require [clojure.string :as cs]))
*ns*
(cs/lower-case "A")

; Jar
; src/sprint3r/main

; Web
; src/sprint3r/web

; Desktop App

; Macro
(when (< 2 1) 5 6)
(when (> 2 1) 5 6)
(macroexpand-1 '(when (< 2 1) 5 6))
(macroexpand-1 '(when (> 2 1) 5 6))

; core.test
; test/sprint3r/core_test.clj

; ClojureScript

; Polymorphic & Record
; http://www.braveclojure.com/multimethods-records-protocols/

; core.async
(require '[clojure.core.async :refer [>! <! go chan]])
(def cha (chan))
(go (loop []
      (if-let [data (<! cha)]
        (do (println data)
            (recur))
        "Done")))
(go (>! cha "Ha"))
(go (>! cha false))

(clojure.pprint/pprint (macroexpand-1 '(go (>! cha "Ha"))))
