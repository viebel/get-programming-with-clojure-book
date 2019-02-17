(ns my-beers)

(defn cans->ml [x]
  (* x 591))
  
(defn pints->ml [x]
  (* x 473))
  
(defn demis->ml [x]
  (* x 500))

(defn most-beer [cans pints demis]
  (cond
    (>= (cans->ml cans) (max (pints->ml pints) (demis->ml demis))) 
    "american"
    (>= (pints->ml pints) (max (cans->ml cans) (demis->ml demis))) 
    "english"
    true "french"))

(defn winner-string [nationality milliliters]
   (str "The winner is " nationality ", he drank " milliliters " ml."))
  
(defn most-beer-and-quantity [cans pints demis]
  (case (most-beer cans pints demis)
    "american" (winner-string "american" (cans->ml cans))
    "english" (winner-string "english" (pints->ml pints))
    (winner-string "french" (demis->ml demis))))

(defn display [mode cans pints demis]
  (case mode
    "most-drunk"  (println (most-beer cans pints demis))
    "winner-and-quantity" (println (most-beer-and-quantity cans pints demis))
    (println (str "Error: The mode " mode " is not supported."))))

(defn -main [mode cans-str pints-str demis-str]
  (display mode
           (read-string cans-str)
           (read-string pints-str)
           (read-string demis-str)))


