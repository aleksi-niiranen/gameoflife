(ns life.gui
  (:require [life.core :refer (neighbours step)])
  (:import (javax.swing JFrame JPanel Timer)
           (java.awt Dimension)
           (java.awt.event ActionListener)))

(def blinker-board #{[2 1] [2 2] [2 3]})

(def glider-board #{[12 10] [12 11] [12 12] [11 12] [10 11]})

(def spaceship-board #{[12 10] [14 10] [11 11] [11 12] [11 13] [14 13] [11 14] [12 14] [13 14]})

(def board (atom spaceship-board))

(defn next-step
  [b]
  (reset! board (step b)))

(defn cell-to-screen-rect
  [[x y]]
  (map #(* 5 %) [x y 1 1]))

(defn paint-cell
  [g c]
  (let [[x y w h] (cell-to-screen-rect c)]
    (.fillRect g x y w h)))

(defn paint
  [g board]
  (doseq [cell board]
    (paint-cell g cell)))

(defn- panel
  []
  (proxy [JPanel ActionListener] []
    (paintComponent [g]
      (proxy-super paintComponent g)
      (paint g @board))
    (actionPerformed [e]
      (next-step @board)
      (.repaint this))
    (getPreferredSize []
      (Dimension. 1024 660))))

(defn frame
  "Returns a timer"
  []
  (let [fr (JFrame. "life")
        p (panel)
        t (Timer. 550 p)]
    (.add fr p)
    (.pack fr)
    (.setVisible fr true)
    (.start t)
    [t]))

