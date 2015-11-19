(ns houston-talk.approach1.untyped
  {:lang :core.typed}
  (:require [clojure.core.typed :as t]))

(t/ann a t/Int)
(def a 1)

(t/ann b [t/Int :-> t/Int])
(def b inc)

(t/ann c [[t/Str :-> t/Int] :-> t/Int])
(defn c [f]
  (f "string"))
