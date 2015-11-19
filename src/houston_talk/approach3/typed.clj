(ns houston-talk.approach3.typed
  {:lang :core.typed
   :core.typed {:features #{:runtime-check}}}
  (:require [clojure.core.typed :as t]
            [houston-talk.approach3.untyped :as u]))

(t/ann use-a [:-> t/Int])
(defn use-a []
  (inc u/a))

(t/ann use-b [:-> t/Int])
(defn use-b []
  (u/b 1))

;(t/ann use-c [[t/Int :-> t/Int] :-> t/Int])
;(defn use-c [f]
;  (u/c f))

(t/ann take-int [t/Int :-> t/Int])
(defn take-int [n]
  (inc n))

(take-int 1)
(take-int nil)
