(ns houston-talk.hmap
  {:lang :core.typed}
  (:require [clojure.core.typed :as t]))

(t/defalias Input
  "Has :a and :b entries which are Int's"
  '{:a t/Int, :b t/Int})

(t/defalias Output
  "Has a :z entry which is another map"
  '{:z '{:c t/Int}
    :d t/Int})

(t/ann f [Input :-> Output])
(defn f [{:keys [a b]}]
  (-> {}
      (assoc :z {:c (+ b a)})
      (merge {:d 1})))

(t/ann g [& :mandatory {:a t/Int, :b t/Int}  :-> Output])
(defn g [& {:keys [a b]}]
  (-> {}
      (assoc :z {:c (+ b a)})
      (merge {:d 1})))

(t/ann maybe-h [(t/U nil t/Int) :-> (t/U nil t/Int)])
(defn maybe-h [n]
  (when n
    (inc n)))

;(f {:a 1 :b 2})
