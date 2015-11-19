(ns houston-talk.problem.typed
  "How do we safely use vars from `houston-talk.problem.untyped`?"
  {:lang :core.typed}
  (:require [clojure.core.typed :as t]
            [houston-talk.problem.untyped :as u]))

(t/ann use-a [:-> t/Int])
(defn use-a []
  (inc u/a))

(t/ann use-b [:-> t/Int])
(defn use-b []
  (u/b 1))

(t/ann use-c [[t/Int :-> t/Int] :-> t/Int])
(defn use-c [f]
  (u/c f))
