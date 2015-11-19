(ns houston-talk.approach3.typed
  "Convert static type checking to runtime checking in
  this namespace."
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

(t/ann use-c [[t/Int :-> t/Int] :-> t/Int])
(defn use-c [f]
  (u/c f))

(comment
  (use-c identity)
  (use-c inc)
  (use-c str))
