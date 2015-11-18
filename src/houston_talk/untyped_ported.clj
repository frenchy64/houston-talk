(ns houston-talk.untyped-ported
  {:lang :core.typed}
  (:require [clojure.core.typed :as t]))

(def a 1)
(def b inc)

(t/ann c [[t/Str :-> t/Int] :-> t/Int])
(defn c [f]
  (f "string"))
