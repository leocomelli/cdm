
import Test.HUnit
import LocalizacaoTres

testUmAmigo = TestCase (assertEqual "Um amigo" [[]] (maisProximos [(1, 2)]))
testDoisAmigos = TestCase (assertEqual "Dois amigos" [[(2, 4)], [(1, 2)]] (maisProximos [(1, 2), (2, 4)]))
testCincoAmigos = TestCase (assertEqual "Cinco amigos" [[(1, 2), (5, 4), (9, 9)],
   														[(2, 3), (1, 2), (9, 9)],
   														[(5, 4), (15, 16), (2, 3)],
   														[(2, 3), (5, 4), (9, 9)],
   														[(9, 9), (5, 4), (2, 3)]] 
   														(maisProximos [(2, 3), (5, 4), (9, 9), (1,2), (15,16)]))
tests = TestList [TestLabel "testUmAmigo" testUmAmigo,
				  TestLabel "testDoisAmigos" testDoisAmigos,
				  TestLabel "testCincoAmigos" testCincoAmigos]