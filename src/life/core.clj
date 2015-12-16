(ns life.core)

(defn neighbours
  [[x y]]
  (for [dx [-1 0 1] dy (if (zero? dx) [-1 1] [-1 0 1])] 
    [(+ x dx) (+ y dy)]))

(defn step
  [board]
  (set (for [[coords n] (frequencies (mapcat neighbours board)) 
             :when (or (= n 3) (and (= n 2) (board coords)))] 
         coords)))

(defn print-board
  [board w h]
  (doseq [x (range (inc w)) y (range (inc h))]
    (if (= y 0) (print "\n"))
    (print (if (board [x y]) "#" "."))))

(defn display-grids
  [grids w h]
  (doseq [board grids]
    (print-board board w h)
    (print "\n")))

