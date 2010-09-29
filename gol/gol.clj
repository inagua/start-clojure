
(def test-grid
	[
	[0 0 0 0 0]
	[0 0 1 0 0]
	[0 0 1 0 0]
	[0 0 1 0 0]
	[0 0 0 0 0] ])

(defn print-grid [grid]
	(doseq [line grid]
		(println line)))

(defn around-and-center [grid x y]
	(let [
		begin-x (max (- x 1) 0) 
	 	end-x 	(min (+ x 2) (count (grid y))) 
		begin-y (max (- y 1) 0) 
 		end-y 	(min (+ y 2) (count grid))]	
	(for 
		[i (range begin-x end-x)
		j  (range begin-y end-y) ]
	[ i j ] )))

(defn around [grid x y]
	(filter #(not= [x y] %) (around-and-center grid x y)))

(defn next [current neighbours]
	(cond
		(< neighbours 2) 0
		(= neighbours 2) current
		(= neighbours 3) 1
		(> neighbours 3) 0))

(defn count-alive [grid x y] 
	(reduce + 0 (map (fn [[x y]] ((grid y) x)) (around grid x y))))

(defn next-gen [grid]
	(partition (count (grid 0))
		(map (fn [[x y]] 
			(next ((grid y) x) (count-alive grid x y)))
				(for [j (range (count grid))
					i (range (count (grid j)))]			
				[i j] ))))

(print-grid test-grid)
(print-grid (next-gen test-grid))
(print-grid (next-gen (next-gen test-grid)))
;(print-grid ((comp next-gen next-gen) test-grid))	

