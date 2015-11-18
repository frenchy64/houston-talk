(ns houston-talk.fully-typed
  {:lang :core.typed}
  (:require [clojure.core.typed :as t]
            [houston-talk.untyped-ported :as u]))

(t/ann use-a [:-> t/Int])
(defn use-a []
  (inc u/a))

(t/ann use-b [:-> t/Int])
(defn use-b []
  (u/b 1))

(t/ann use-c [[t/Int :-> t/Int] :-> t/Int])
(defn use-c [f]
  (u/c f))
