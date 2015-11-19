(ns houston-talk.approach2.typed
  "Safe importing of untyped vars via contracts."
  {:lang :core.typed}
  (:require [clojure.core.typed :as t]
            [houston-talk.approach2.untyped :as u]))

(t/untyped-var u/a t/Int)
(t/untyped-var u/b [t/Int :-> t/Int])
(t/untyped-var u/c [[t/Int :-> t/Int] :-> t/Int])

(t/ann use-a [:-> t/Int])
(defn use-a []
  (inc u/a))

(t/ann use-b [:-> t/Int])
(defn use-b []
  (u/b 1))

(t/ann use-c [[t/Int :-> t/Int] :-> t/Int])
(defn use-c [f]
  (u/c f))
