
import Test.HUnit
import Localizacao

testUmaCoordenada = TestCase (assertEqual "Uma coordenada" [(1, 2)] (maisProximo [(1, 2)] (2, 3)))
testUmaCoordenadaDiferente = TestCase (assertEqual "Uma coordenada diferente" [(3, 2)] (maisProximo [(3, 2)] (2, 3)))
testDuasCoordenadas = TestCase (assertEqual "Duas coordenadas" [(8, 8), (1, 4)] (maisProximo [(1, 4), (8, 8)] (7, 9)))
testTresCoordenadas = TestCase (assertEqual "Tres coordenadas" [(5, 4), (2, 3), (1, 4)] (maisProximo [(1, 4), (5, 4), (2, 3)] (5, 3)))
testQuatroCoordenadas = TestCase (assertEqual "Quatro coordenadas" [(5, 4), (2, 3), (1, 4)] (maisProximo [(1, 4), (10, 10), (5, 4), (2, 3)] (5, 3)))

tests = TestList [TestLabel "testNenhumaCoordenada" testUmaCoordenada,
				  TestLabel "testUmaCoordenadaDiferente" testUmaCoordenadaDiferente,
				  TestLabel "testDuasCoordenadas" testDuasCoordenadas,
				  TestLabel "testTresCoordenadas" testTresCoordenadas,
				  TestLabel "testQuatroCoordenadas" testQuatroCoordenadas]