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
