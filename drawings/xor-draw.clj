; from "The joy of Clojure"

(def size 200)

(def frame (java.awt.Frame.))
(.setVisible frame true)
(.setSize frame (java.awt.Dimension. size size))

(defn f-values [f1 f2 f3 max-x max-y]
	(for [x (range max-x) y (range max-y)]
		[x y (f1 x y) (f2 x y) (f3 x y) ]))

(def gfx (.getGraphics frame))

(defn draw-values [f1 f2 f3 max-x max-y]
	(doseq [[x y v1 v2 v3] (f-values f1 f2 f3 max-x max-y)]            
		(.setColor gfx (java.awt.Color. v1 v2 v3))
		(.fillRect gfx x y 1 1)))

(defn plus-mod-256 [x y]
	(rem (+ x y) 256))

(defn mult-mod-256 [x y]
	(rem (* x y) 256))

(draw-values plus-mod-256 mult-mod-256 bit-xor size size)
