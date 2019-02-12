(ns hello-name-twice-or-once)

(defn display-name [my-name my-num]
  (if (>= my-num 2)
    (println (str my-name "," my-name))
    (println my-name)))

(defn -main [my-name my-num-str]
  (display-name my-name (read-string my-num-str)))

