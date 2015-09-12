(ns sprint3r.core-test
  (:require [clojure.test :refer :all]
            [sprint3r.main :as m]))

(deftest plus-test
  (is (= 3 (m/plus 1 2))))
