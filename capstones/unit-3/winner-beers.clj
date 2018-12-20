; An american, a british and a french are sitting at a pub. After a couple of hours, each of them brags about the amount of beer he has drunk:
; The american guy says: "I have drunk x 20 ounce cans"
; The british guy replies: "I have drunk y pints"
; The french guy concludes: "I have drunk demis"

; Which one of them has drunk the most?

; Your mission is to write a function calc-most-drunk that receive three arguments x, y and z and returns a number corresponding to the guy that drank the most: 1 for the american, 2 for the british, 3 for the french.
; Bonus: return a string with the name of the winner and the qunatity of beers he drunk

(defn us->cl [num] num)
(defn en->cl [num] num)
(defn fr->cl [num] num)

(defn most-beer [american english french]
  (cond
    (> (us->cl american) (max (en->cl english) (fr->cl french))) 
    "american"
    (> (en->cl english) (max (us->cl american) (fr->cl french))) 
    "english"
    :else "french"))

(defn display-winner [winner qty]
   (str "The " winner " is the winner: he drunk " qty " cc of beers"))
  
(defn most-beer-with-quantity [american english french]
  (case (most-beer american english french)
    "american" (display-winner "american" (us->cl american))
    "english" (display-winner "english" (en->cl english))
    (display-winner "french" (fr->cl english))))          

(most-beer 3 4 5)
(most-beer-with-quantity 3 4 5)
