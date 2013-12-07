module Localizacao where

import Data.List

distancia (x1, y1) (x2, y2) = (abs (x2 - x1), abs (y2 - y1))

proximidade pos amigo1 amigo2 = compare (distancia pos amigo1) (distancia pos amigo2)

maisProximo coordenadas posicaoAtual = take 3 (sortBy (proximidade posicaoAtual) coordenadas)