import java.util.Scanner;

public class jogodavelha {
    private static int jog; 
	private static int[][] casa = new int[3][3]; 
	private static int linha, coluna, win; 
	private static Scanner leitor = new Scanner(System.in);
    public static <main> void desenha(int x, int y) { 
        if (casa[x][y] == 1) { 
            System.out.print("X"); 
        } else if (casa[x][y] == 2) { 
            System.out.print("O"); 
        } else { 
            System.out.print(" "); 
        } 
        public static main jogo() { 
            System.out.print("\n  1   2   3\n"); 
            
            System.out.print("1 "); 
            
            desenha(0, 0); 
          
            System.out.print("  | "); 
           
            desenha(0, 1); 
          
            System.out.print("  | "); 
          
            desenha(0, 2); 
           
            System.out.print("\n -----------\n2 "); 
           
            desenha(1, 0); 
           
            System.out.print("  | "); 
         
            desenha(1, 1); 
          
            System.out.print("  | "); 
         
            desenha(1, 2); 
          
            System.out.print("\n -----------\n3 "); 
            
            desenha(2, 0); 
          
            System.out.print("  | "); 
         
            desenha(2, 1); 
          
            System.out.print("  | "); 
           
            desenha(2, 2); 
        }
        public static void jogar (int jogador) { 
            if (jogador == 1) { 
                jog = 1; 
            }  else { 
                jog = 2; 
            } 
            System.out.println("\n\n Vez do Jogador " + jog);   
        }    
        
        System.out.print("Escolha a Linha (1,2,3):"); 
        // lendo a linha escolhida
        linha = leitor.nextInt(); 
        System.out.print("Escolha a Coluna (1,2,3):"); 
        // lendo a coluna escolhida 
        coluna = leitor.nextInt();
    }
    public static void jogar(int jogador) { 
        // inicializando contador da estrutura while
        int i = 0; 
        // definindo o jogador da vez
        if (jogador == 1) { 
            jog = 1; 
        } else { 
            jog = 2; 
        } 
        System.out.println("\n\n Vez do Jogador " + jog); 
        while (i == 0) { 
            linha = 0; // inicializando valor da linha 
            coluna = 0; // inicializando valor da coluna 
            while (linha < 1 || linha > 3) { 
                System.out.print("Escolha a Linha (1,2,3):"); 
                // lendo a linha escolhida 
                linha = leitor.nextInt(); 
                // Aviso de linha inválida, caso o jogador tenha                                              
                // escolhido linha menor que 1 ou maior que 3 
                if (linha < 1 || linha > 3) { 
                    System.out.println("Linha invalida! Escolha uma linha entre 1 e 3."); 
                } 
            } 
            while (coluna < 1 || coluna > 3) { 
                System.out.print("Escolha a Coluna (1,2,3):"); 
                // lendo a coluna escolhida 
                coluna = leitor.nextInt(); 
                if (coluna < 1 || coluna > 3) { 
                    System.out.println("Coluna invalida! Escolha uma coluna entre 1 e 3."); 
                } 
            } 
            // Ajusta índices para começar do zero 
            linha = linha - 1; 
            coluna = coluna - 1; 
            if (casa[linha][coluna] == 0) { 
                // se não estiver marcado 
                // marcar com o símbolo do jogador da vez 
                casa[linha][coluna] = jog; 
                i = 1; 
            } else { // se o campo escolhido já estivar marcado 
                System.out.println("Posição ocupada!"); 
            } 
        } 
    }
    public static void check() { 
        int i = 0; 
        //verificando se houve vencedor na Horizontal:          
        for (i = 0; i < 3; i++) { 
            if (casa[i][0] == casa[i][1] && casa[i][0] == casa[i][2]) { 
                if (casa[i][0] == 1) win = 1; 
                if (casa[i][0] == 2) win = 2; 
            } 
        } 
        //verificando se houve vencedor na Vertical:
        for (i = 0; i < 3; i++) { 
            if (casa[0][i] == casa[1][i] && casa[0][i] == casa[2][i]) { 
                if (casa[0][i] == 1) win = 1; 
                if (casa[0][i] == 2) win = 2; 
            } 
        } 
        //verificando se houve vencedor na Diagonal de cima para baixo: 
        if (casa[0][0] == casa[1][1] && casa[0][0] == casa[2][2]) { 
            if (casa[0][0] == 1) win = 1; 
            if (casa[0][0] == 2) win = 2; 
        } 
        //verificando se houve vencedor na Diagonal de baixo para cima: 
        if (casa[0][2] == casa[1][1] && casa[0][2] == casa[2][0]) { 
            if (casa[0][2] == 1) win = 1; 
            if (casa[0][2] == 2) win = 2; 
        } 
    }
    public static void main(String[] args) { 
        int i = 0; 
        // percorre todo o tabuleiro, nas nove posições: 
        for (i = 0; i < 9; i++) { 
            jogo();// chama a rotina jogo(), que desenha o tabuleiro 
            if (i % 2 == 0) { 
                jogar(2); 
            } else { 
                jogar(1); 
            }
            // chama a rotina check (), para ver se alguém ganhou 
            check();
            if (win == 1 || win == 2) { 
                // sai do laço antes de completar o tabuleiro, 
                // se alguém tiver vencido 
                i = 10; 
            } 
        } 
        // chama a rotina jogo(), para desenhar novamente o tabuleiro 
        jogo(); 
        // verifica se houve vencedor 
        System.out.println(); 
        if (win == 1 || win == 2) { 
            // informa o vencedor 
            System.out.println("Jogador " + win + " é o ganhador!");
        } else { 
            // se não houve vencedor 
            System.out.println("Não houve vencedor! O jogo foi empate!!"); 
        } 
    }
    private static void jogo() {
    }
}
