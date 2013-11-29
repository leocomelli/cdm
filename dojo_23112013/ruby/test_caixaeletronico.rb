
require_relative 'caixaeletronico'
require 'test/unit'

class TestCaixaEletronico < Test::Unit::TestCase

    def test_dez
        caixa = CaixaEletronico.new({ 10 => 5, 20 => 5 })
        saque_obtido = caixa.saque(10)
        saque_esperado = Saque.new({ 10 => 1 })
        assert_equal(saque_esperado, saque_obtido)
    end

    def test_vinte
        caixa = CaixaEletronico.new
        saque_obtido = caixa.saque(20)
        saque_esperado = Saque.new({ 20 => 1 })
        assert_equal(saque_esperado, saque_obtido)    
    end

    def test_trinta
    	caixa = CaixaEletronico.new
    	saque_obtido = caixa.saque(30)
        saque_esperado = Saque.new({ 20 => 1, 10 => 1 })
        assert_equal(saque_esperado, saque_obtido)
    end

    def test_duzentos_setenta
    	caixa = CaixaEletronico.new
    	saque_obtido = caixa.saque(270)
        saque_esperado = Saque.new({ 100 => 2, 50 => 1, 20 => 1 })
        assert_equal(saque_esperado, saque_obtido)
    end

    def test_oitenta
    	caixa = CaixaEletronico.new
    	saque_obtido = caixa.saque(80)
        saque_esperado = Saque.new({ 50 => 1, 20 => 1, 10 => 1 })
        assert_equal(saque_esperado, saque_obtido)
    end

    def test_cinquenta_sem_notas_de_cinquenta
    	caixa = CaixaEletronico.new({ 100 => 2, 10 => 7 })
    	saque_obtido = caixa.saque(50)
        saque_esperado = Saque.new({ 10 => 5 })
        assert_equal(saque_esperado, saque_obtido)
    end

    def test_saque_nao_possivel
    	caixa = CaixaEletronico.new({ 100 => 2 })
    	saque_obtido = caixa.saque(50)
        saque_esperado = nil
        assert_equal(saque_esperado, saque_obtido)
    end

end