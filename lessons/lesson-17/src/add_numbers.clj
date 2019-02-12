(ns add-numbers)

(defn display-addition [a b]
  (println (str "The addition of " a " and " b " is: " (+ a b) ".")))

(defn -main [a b]
  (display-addition (read-string a) (read-string b)))

