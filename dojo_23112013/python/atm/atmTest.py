import unittest
from atm import ATM
from valorInvalidoException import ValorInvalidoException

class AtmTest(unittest.TestCase):

    def testObterMaiorNotaPossivel30(self):
        atm = ATM()
        nota = atm.obterMaiorNotaPossivel(30)
        self.assertEqual(nota, 20)
        
    def testObterMaiorNotaPossivel60(self):
        atm = ATM()
        nota = atm.obterMaiorNotaPossivel(60)
        self.assertEqual(nota, 50)
        
    def testObterMaiorNotaPossivel200(self):
        atm = ATM()
        nota = atm.obterMaiorNotaPossivel(200)
        self.assertEqual(nota, 100)
        
    def testObterMaiorNotaPossivel20(self):
        atm = ATM()
        nota = atm.obterMaiorNotaPossivel(20)
        self.assertEqual(nota, 20)
            
    def testNotaRetornadaIgual50(self):
        atm = ATM()
        notas = atm.contarNotas(50)
        self.assertListEqual(notas, [50])
        
    def testNotaRetornadaIgual30(self):
        atm = ATM()
        notas = atm.contarNotas(30)
        self.assertListEqual(notas, [20, 10])
        
    def testNotaRetornadaIgual80(self):
        atm = ATM()
        notas = atm.contarNotas(80)
        self.assertListEqual(notas, [50, 20, 10])
        
    def testNotaRetornadaIgual200(self):
        atm = ATM()
        notas = atm.contarNotas(200)
        self.assertListEqual(notas, [100, 100])
        
    def testValorNaoEhPossivel(self):
        atm = ATM()
        with self.assertRaises(ValorInvalidoException) : 
            atm.efetuarSaque(35)
            
    def testValorVazio(self):
        atm = ATM()
        with self.assertRaises(ValorInvalidoException) : 
            atm.efetuarSaque(None)
        
    def testEfetuarSaque50Reais(self):
        atm = ATM()
        mensagem = atm.efetuarSaque(50)
        padrao = "Entregar 1 nota(s) de R$ 50,00"
        self.assertEquals(mensagem, padrao)
        
    def testEfetuarSaque30Reais(self):
        atm = ATM()
        mensagem = atm.efetuarSaque(30)
        padrao = "Entregar 1 nota(s) de R$ 20,00 e 1 nota(s) de R$ 10,00"
        self.assertEquals(mensagem, padrao)
        
    def testEfetuarSaque80Reais(self):
        atm = ATM()
        mensagem = atm.efetuarSaque(80)
        padrao = "Entregar 1 nota(s) de R$ 50,00 e 1 nota(s) de R$ 20,00 e 1 nota(s) de R$ 10,00"
        self.assertEquals(mensagem, padrao)
            
def main():
        unittest.main()

if __name__ == '__main__':
        main()