class Distancia

  def initialize(linhas = 10, colunas = 10)

    @matriz = Array.new(linhas){Array.new(colunas)}

    @matriz[2][2] = true
    @matriz[5][6] = true
    @matriz[3][0] = true
    @matriz[4][2] = true
    @matriz[7][3] = true

  end

  def buscarAmigos(x, y)

    if y < 0 or y > @matriz.length 
      raise Exception
    end

    if x < 0 or x > @matriz[0].length 
      raise Exception
    end

  end

  def obterTodasAsPosicoesDeAmigos
    
    amigos=[]
        
    linhas = (@matriz.length) - 1
    colunas = (@matriz[0].length) -1
        
    for i in 0..linhas
      for j in 0..colunas
        
        if @matriz[i][j] != nil
         amigos.push([i,j])
        end    
      end
    end 
    return amigos.sort()
  end
  
  
  def calcularPosicaoDoAmigoMaisProximo(x, y, matriz = nil)
  
    if matriz == nil
      amigos = obterTodasAsPosicoesDeAmigos
    else
      amigos = matriz.clone
    end
    
    maisProximo = Array.new(2)  
    #distancia = 0
    distanciaAnterior = nil
    
    for amigo in amigos
    
      distancia = (x - amigo[0]).abs + (y - amigo[1]).abs
             
      if distancia > 0 and (distanciaAnterior == nil or distancia < distanciaAnterior)
        distanciaAnterior = distancia
        maisProximo = amigo
      end
    
    end
  
    return maisProximo
  end 
  
  
  def obterListaDeAmigosMaisProximos(x, y)
  
    lista = []
    amigos = obterTodasAsPosicoesDeAmigos
    
    while (lista.length < 3 and amigos.length > 0)
    
      amigo = calcularPosicaoDoAmigoMaisProximo(x, y, amigos)
      
      amigos.delete(amigo)
      
      lista.push(amigo)
    
    end
    
    return lista
  
  end
  
  def mostrarListaDeAmigos
  
    amigos = obterTodasAsPosicoesDeAmigos
    
    for amigo in amigos
      puts "Amigos a partir de #{amigo[0]},#{amigo[1]}"
      proximos = obterListaDeAmigosMaisProximos(amigo[0], amigo[1])
      for proximo in proximos
        puts "\t #{proximo[0]},#{proximo[1]}"
      end
    end
  
  end

  # METODO SOMENTE PARA ILUSTRAÇÃO
  def imprimirMatriz

    for i in matriz
      for j in i
        if j == true
          print 'X'
        else
          print '-'
        end
      end
      print "\n"
    end
    

  end

  attr_reader :matriz


end
