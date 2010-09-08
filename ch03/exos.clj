; ex 2

(defn stable-union [col1 col2]
    (if (empty? col2)
        col1        
        (if (contains? (set col1) (first col2))
            (stable-union col1 (rest col2))
            (stable-union (cons (first col2) col1) (rest col2)))))

; beurk
; (distint (concat ...)) instead !

(stable-union '(:a :b :c) '(:b :a :d))