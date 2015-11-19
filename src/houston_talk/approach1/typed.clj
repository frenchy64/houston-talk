(ns houston-talk.approach1.typed
  "Safe importing of untyped code by porting all untyped code to
  be typed."
  {:lang :core.typed}
  (:require [clojure.core.typed :as t]
            [houston-talk.approach1.untyped :as u]))

(t/ann use-a [:-> t/Int])
(defn use-a []
  (inc u/a))

(t/ann use-b [:-> t/Int])
(defn use-b []
  (u/b 1))

(t/ann use-c [[t/Int :-> t/Int] :-> t/Int])
(defn use-c [f]
  (u/c f)) ;; types don't match at compile time
