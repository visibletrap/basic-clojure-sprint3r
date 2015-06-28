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
(comment
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
  )

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

; List
'(1 2 3)
(list 1 2 3)
(conj '(1 2 3) 4)
(nth '(1 2 3) 1)
(peek '(1 2 3))
(pop '(1 2 3))

; Map
{:a 1 :b 2}
(assoc {:a 1 :b 2} :c 3)
(assoc {:a 1 :b 2} :a 3)
(dissoc {:a 1 :b 2} :a)
(dissoc {:a 1 :b 2 :c 3} :a :b)
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

[{:name "David" :age 36}
 {:name "Michael" :age 40}
 {:name "David" :age 25}]
(take 3 (sort-by #(count (vals %)) ()))

; Threading macro


; State
