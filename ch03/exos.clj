; ex 2
; make union (no duplication of lists)
(defn stable-union [col1 col2]
    (if (empty? col2)
        col1        
        (if (contains? (set col1) (first col2))
            (stable-union col1 (rest col2))
            (stable-union (cons (first col2) col1) (rest col2)))))

; beurk
; (distint (concat ...)) instead !

(stable-union '(:a :b :c) '(:b :a :d))

; ex 3
; count nb occurences in list
(defn occurences1 [l]
    (let [elts (distinct l)]        
        (for [elt elts]
        [elt (count (filter #(= % elt) l))])))
 
(defn occurences [l] 
    (sort-by (fn [[v occ]] occ) >
    (for [elt (distinct l)]
        [elt (count (filter #(= % elt) l))])))
                   
(occurences [:a :b :a :a :d :c :c :c])

; ex 5
; shift each element by a number that is increased by one at each step 
(defn pos+ [col]
    (map - col (range (count col))))
(pos+ [7 6 3 7])

    