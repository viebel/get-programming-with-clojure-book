;; total amount 
;; shipping costs $10
;; discount based on number of items purchased
;; below 5 items - no discount
;; between 6 and 10 items - 15 % discount
;; between 11 and 20 items - 20 % discount
;; above 20 items - 30 % discount

(def shipping-cost 10)

(defn discount [num-of-items]
  (cond 
    (<= 6 num-of-items 10) 15
    (<= 11 num-of-items 20) 20
    (<= 21 num-of-items) 30
    true 0))

(defn reducted-price-ratio [num-of-items]
  (- 1 (/ (discount num-of-items)
          100)))

(defn total-amount [num-of-items item-price shipping?]
  (if shipping?
    (+ shipping-cost (* num-of-items item-price (reducted-price-ratio num-of-items)))
    (* num-of-items item-price (reducted-price-ratio num-of-items))))

(total-amount 6 9 false)
