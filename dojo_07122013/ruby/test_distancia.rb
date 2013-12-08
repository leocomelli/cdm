require "test/unit"
require "distancia"

class TestDistancia < Test::Unit::TestCase

  # Testes para 'treinar a sintaxe'

  def testCriaInstancia

    distancia = Distancia.new()

    assert_not_nil(distancia)

  end

  def testMatrizFoiInicializadaCorretamente

    distancia = Distancia.new()

    assert_equal(10, distancia.matriz[0].length)
    assert_equal(10, distancia.matriz.length)
    

  end


  # Testes para o problema

  def testLatitudeInformadaEhMaiorQueOTotal
    distancia = Distancia.new(10, 10)
    assert_raise Exception do
      distancia.buscarAmigos(10,15)
    end
  end

  def testLatitudeInformadaEhMenorQueZero
    distancia = Distancia.new(10, 10)
    assert_raise Exception do
      distancia.buscarAmigos(15,-5)
    end
  end
  
  def testLongitudeInformadaEhMaiorQueOTotal
    distancia = Distancia.new(10, 10)
    assert_raise Exception do
      distancia.buscarAmigos(15,8)
    end
  end

  def testLongitudeInformadaEhMenorQueZero
    distancia = Distancia.new(10, 10)
    assert_raise Exception do
      distancia.buscarAmigos(-2,10)
    end
  end

  def testObterPosicaoDeTodosOsAmigos

    distancia = Distancia.new()
    lista = distancia.obterTodasAsPosicoesDeAmigos()
    
    esperado = [[2,2],[5,6],[3,0],[4,2],[7,3]].sort()

    assert_equal(esperado,lista)

  end
  
  def testCalcularPosicaoDoAmigoMaisProximo_0_e_0
  
    distancia = Distancia.new()
    
    maisProximo = distancia.calcularPosicaoDoAmigoMaisProximo(0, 0)
    
    assert_equal([3, 0], maisProximo)
  
  end
  
  def testCalcularPosicaoDoAmigoMaisProximo_5_e_4
  
    distancia = Distancia.new()
    
    maisProximo = distancia.calcularPosicaoDoAmigoMaisProximo(5, 4)
    
    assert_equal([5, 6], maisProximo)
  
  end
  
  def testObterListaDeAmigosMaisProximos_0_e_0
  
    distancia = Distancia.new()
    lista = distancia.obterListaDeAmigosMaisProximos(0, 0)
    
    esperado = [[3,0],[2,2],[4,2]]

    assert_equal(esperado,lista)   
  
  end
  
  def testObterListaDeAmigosMaisProximos_5_e_4
  
    distancia = Distancia.new()
    lista = distancia.obterListaDeAmigosMaisProximos(5, 4)
    
    esperado = [[5,6],[4,2],[7,3]]

    assert_equal(esperado,lista)   
  
  end

end
