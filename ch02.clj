
(defn count-a [l]
    (if (empty? l)
        0
        (if (= (first l) 'a)
        (+ 1 (count-a (rest l)))
        (count-a (rest l)))))
        
(count-a nil)
(count-a '(a a a))
(count-a '(oo ll ee))

(defn summit [l]
    (reduce (fn [acc x] (if x (+ acc x) acc))
        0
        l))
        
(summit '(1 2 3 4))
(summit '(1 2 nil 4))
(summit nil)
(summit '())
