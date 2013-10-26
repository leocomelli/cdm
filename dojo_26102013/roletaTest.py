import unittest
from roleta import RoletaRomana

class  RoletaRomanaTestCase(unittest.TestCase):
	"""Testes para a Roleta"""

	def testarPessoasEhMaiorQueZero(self):
		
		with self.assertRaises(Exception):
			RoletaRomana(0, 2, 1)
		
	def testarPassosEhMaiorQueZero(self):

		with self.assertRaises(Exception):
			RoletaRomana(5, 0, 2)

	def testarPassosEhMenorQuePessoas(self):
		
		with self.assertRaises(Exception):
			RoletaRomana(2, 5, 3)

	def testarInicialEhMaiorQueZero(self):
		
		with self.assertRaises(Exception):
			RoletaRomana(2, 5, 0)

	def testarInicialEhMenorQuePessoas(self):
		
		with self.assertRaises(Exception):
			RoletaRomana(2, 5, 1)

	def testarObterPosicaoIdealDezPessoas(self):

		roleta = RoletaRomana(10, 2, 5)
		self.assertEqual(4, roleta.obterPosicaoIdeal())

	def testarObterPosicaoIdealCincoPessoas(self):
		
		roleta = RoletaRomana(5, 2, 1)
		self.assertEqual(5, roleta.obterPosicaoIdeal())

	def testarObterPosicaoIdealCincoPessoasInicioTres(self):

		roleta = RoletaRomana(5, 2, 3)
		self.assertEqual(2, roleta.obterPosicaoIdeal())

	def testarObterPosicaoIdealQuarentaPessoas(self):

		roleta = RoletaRomana(40, 3, 5)
		self.assertEqual(4, roleta.obterPosicaoIdeal())

	def testarObterPosicaoIdealQuarentaPessoas_10_Em_10(self):

		roleta = RoletaRomana(40, 10, 3)
		self.assertEqual(2, roleta.obterPosicaoIdeal())

	def testarObterPosicaoIdealMilEQuarentaPessoas(self):
		roleta = RoletaRomana(1040, 33, 4)
		self.assertEqual(3, roleta.obterPosicaoIdeal())

def main():
	unittest.main()

if __name__ == '__main__':
	main()