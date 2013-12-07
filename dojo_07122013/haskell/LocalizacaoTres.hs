module LocalizacaoTres where

import Data.List

distancia (x1, y1) (x2, y2) = (abs (x2 - x1), abs (y2 - y1))

proximidade pos amigo1 amigo2 = compare (distancia pos amigo1) (distancia pos amigo2)

diferenteDe eu amigo = eu /= amigo

tresMaisProximos amigos amigo = take 3 (sortBy (proximidade amigo) (filter (diferenteDe amigo) amigos))

maisProximos amigos = map (tresMaisProximos amigos) amigos