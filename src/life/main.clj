(ns life.main
  (:require [life.core :refer :all]
            [life.gui :refer (frame)]))

(def board (atom #{}))

(defn game
  "Starts a new game of life with seed"
  [seed]
  (let [s (set (map (fn [[x y]] [(+ 10 x) (+ 10 y)]) seed))]
    (reset! board s)
    (frame)))

