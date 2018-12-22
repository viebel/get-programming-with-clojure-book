; An american, a british and a french are sitting at a pub. After a couple of hours, each of them brags about the amount of beer he has drunk:
; The american guy says: "I have drunk x 20 ounce cans"
; The british guy replies: "I have drunk y pints"
; The french guy concludes: "I have drunk demis"

; Which one of them has drunk the most?

; Your mission is to write a function calc-most-drunk that receive three arguments x, y and z and returns a number corresponding to the guy that drank the most: 1 for the american, 2 for the british, 3 for the french.
; Bonus: return a string with the name of the winner and the qunatity of beers he drunk

(def a-can-in-ml 591)
(def a-pint-in-ml 473)
(def a-demi-in-ml 500)

(defn ->ml [nationality quantity]
  (* quantity 
     (case nationality
        "american" a-can-in-ml
        "english" a-pint-in-ml
        "french"  a-demi-in-ml)))
 
(defn cans->ml [x]
  (* x 591))
  
(defn pints->ml [x]
  (* x 473))
  
(defn demis->ml [x]
  (* x 500))


(defn most-beer [cans pints demis]
  (cond
    (>= (cans->ml cans) (max (pints->ml pints) (demis->cl demis))) 
    "american"
    (>= (pints->ml pints) (max (cans->ml cans) (demis->cl demis))) 
    "english"
    :else "french"))

(defn claim-as-str [nationality milliliters]
   (str "I am " nationality " and I drank " milliliters " milliliters of beers"))
  
(defn most-beer-with-quantity [cans pints demis]
  (case (most-beer cans pints demis)
    "american" (claim-as-str "american" (cans->ml cans))
    "english" (claim-as-str "english" (pints->ml pints))
    (claim-as-str "french" (demis->ml demis))))          
