(ns unit-4.core)
; An American, a Brit and a Frenchman are sitting at a pub. After a couple of hours, each of them starts to brag about the amount of beer he drank:
; The american guy says: "I drank x 20 ounce cans"
; The American says: "I drank x 20 ounce cans"
; The Brit replies: "I drank y pints"
; The Frenchman concludes: "I drank z demis"


; The question is: which one of them drank the most?
; As a reminder, we have:
; A 20 ounce can is: 591 milliliters
; A pint is: 473 milliliters
; A demi is: 500 milliliters
; Your mission to write in the Clojure REPL two functions:
;; 1. a 3-arity function named most-beer that receives three arguments cans, pints and demis and returns a string with the nationality of the person that drank the highest quantity of beer. The string is either "american", "english" or "french". For instance (most-drunk 10 2 3) should return "american".
;; 2. a 3-arity function named most-beer-and-quantity that receives the same arguments as most-drunk and returns a strings that contains in addition to nationality of the person that drank the highest quantity of beer, the amount of beer is milliliter that the person drank. For instance (most-drunk 10 2 3) should return "The american drank the most: he drank 5910 milliliters of beer".

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

(defn -main [cans pints demis]
  (println (most-beer-and-quantity (read-string cans)
                                   (read-string pints)
                                   (read-string demis))))
