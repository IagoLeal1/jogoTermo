package gametemplate;

import java.io.*;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Termo extends Game {
    private GameData gameData;
    private File saveFile;

    public Termo() {
        saveFile = new File("save.txt");
    }

    @Override
    public void criaNovo() {
        String[] palavras = {
            "sagaz", "âmago", "negro", "termo", "êxito",
            "mexer", "nobre", "senso", "afeto", "algoz",
            "ética", "plena", "mútua", "tênue", "fazer",
            "assim", "vigor", "sutil", "aquém", "porém",
            "seção", "fosse", "sanar", "poder", "audaz",
            "ideia", "cerne", "inato", "moral", "sobre",
            "desde", "muito", "justo", "honra", "quiçá",
            "torpe", "sonho", "razão", "fútil", "etnia",
            "ícone", "anexo", "amigo", "égide", "tange",
            "lapso", "haver", "expor", "mútuo", "dengo",
            "tempo", "casal", "então", "hábil", "seara",
            "boçal", "ávido", "ardil", "pesar", "saber",
            "causa", "graça", "dizer", "genro", "óbice",
            "posse", "coser", "pária", "dever", "brado",
            "tenaz", "prole", "crivo", "sendo", "corja",
            "comum", "temor", "detém", "ainda", "ânimo",
            "ápice", "ânsia", "ceder", "estar", "digno",
            "pauta", "assaz", "xibiu", "culto", "mundo",
            "atroz", "fugaz", "censo", "gleba", "forte",
            "vício", "vulgo", "cozer", "valha", "denso",
            "neném", "revés", "pudor", "criar", "dogma",
            "saúde", "regra", "louco", "jeito", "mesmo",
            "atrás", "ordem", "clava", "round", "banal",
            "impor", "mercê", "pedir", "homem", "feliz",
            "todos", "apraz", "coisa", "usura", "tenro",
            "desse", "sábio", "juízo", "pífio", "servo",
            "limbo", "prosa", "forma", "presa", "falar",
            "viril", "ontem", "cunho", "reaça", "devir",
            "posso", "manso", "meiga", "certo", "vendo",
            "herói", "valor", "fluir", "ébrio", "mágoa",
            "sério", "acaso", "puder", "platô", "visar",
            "guisa", "falso", "lugar", "fácil", "temer",
            "legal", "garbo", "ímpio", "abrir", "afins",
            "cisma", "pleno", "bruma", "óbvio", "gerar",
            "obter", "matiz", "êxodo", "crise", "praxe",
            "burro", "linda", "fluxo", "senil", "vênia",
            "união", "havia", "tédio", "enfim", "ritmo",
            "tomar", "ajuda", "visão", "morte", "álibi",
            "olhar", "brega", "parvo", "levar", "gênio",
            "casta", "favor", "bravo", "pulha", "prumo",
            "vital", "reter", "valia", "reles", "parco",
            "vivaz", "grato", "falta", "laico", "tecer",
            "possa", "cabal", "sábia", "ameno", "ouvir",
            "noção", "ranço", "carma", "viver", "calma",
            "nicho", "passo", "achar", "força", "prime",
            "óbito", "outro", "noite", "fator", "selar",
            "façam", "rogar", "tendo", "pobre", "fardo",
            "único", "anelo", "coeso", "farsa", "ativo",
            "épico", "terra", "rever", "citar", "sinto",
            "dúbio", "cisão", "adiar", "sonso", "ciúme",
            "leigo", "sesta", "haste", "gente", "humor",
            "cesta", "tende", "deter", "claro", "sulco",
            "velho", "revel", "exato", "amplo", "atuar",
            "vemos", "árduo", "labor", "lavra", "feixe",
            "ponto", "igual", "ideal", "marco", "imune",
            "gesto", "papel", "líder", "débil", "fonte",
            "ótica", "hiato", "terno", "cauda", "ficar",
            "ambos", "senão", "capaz", "toada", "vácuo",
            "vazio", "remir", "sonsa", "varão", "jovem",
            "inata", "tanto", "tenra", "coçar", "velar",
            "xeque", "apoio", "caçar", "relva", "algum",
            "nossa", "fusão", "série", "horda", "leito",
            "advém", "farão", "pouco", "raiva", "probo",
            "doido", "entre", "vimos", "sente", "coesa",
            "chuva", "frase", "feito", "minha", "torço",
            "ciclo", "verso", "anuir", "botar", "rigor",
            "cruel", "massa", "brisa", "blasé", "ímpar",
            "dorso", "signo", "chata", "trama", "prece",
            "carro", "lazer", "moção", "maior", "credo",
            "fauna", "covil", "preso", "pegar", "casto",
            "morar", "furor", "peste", "ambas", "sorte",
            "seita", "flora", "dócil", "faina", "adeus",
            "livro", "vetor", "houve", "árido", "vírus",
            "setor", "senda", "liame", "comer", "meses",
            "manha", "pecha", "plano", "nunca", "peixe",
            "ardor", "ocaso", "beata", "aliás", "aceso",
            "vulto", "visse", "salvo", "banzo", "saiba",
            "vasto", "breve", "antro", "morro", "rezar",
            "pajem", "birra", "saída", "prado", "reger",
            "praia", "mudar", "junto", "ótimo", "avaro",
            "segue", "sinal", "motim", "parte", "campo",
            "áureo", "átomo", "serão", "lenda", "chulo",
            "grupo", "risco", "anais", "andar", "acima",
            "opção", "fugir", "agora", "brava", "nação",
            "treta", "parar", "leite", "rapaz", "fruir",
            "fitar", "antes", "vilão", "ídolo", "jazia",
            "prazo", "tenso", "puxar", "gerir", "alude",
            "áurea", "texto", "conta", "norma", "tirar",
            "tosco", "bando", "reino", "anciã", "época",
            "verbo", "malta", "exame", "índio", "psico",
            "oxalá", "arcar", "sinhá", "corpo", "estão",
            "avião", "filho", "preto", "prova", "aonde",
            "praga", "traga", "cheio", "quase", "venal",
            "festa", "voraz", "fatal", "quota", "certa",
            "átrio", "turba", "logro", "acesa", "manhã",
            "apego", "cópia", "fatos", "oásis", "fixar",
            "soldo", "sumir", "sarça", "ligar", "pompa",
            "coito", "nível", "nódoa", "caixa", "alado",
            "magia", "messe", "mente", "afora", "perda",
            "tocar", "dessa", "tinha", "solto", "virão",
            "fraco", "parca", "livre", "lindo", "verve",
            "apelo", "jirau", "lidar", "grave", "turva",
            "nosso", "glosa", "exijo", "firme", "opaco",
            "longe", "sabia", "vezes", "bater", "sexta",
            "doído", "faixa", "trupe", "parva", "pardo",
            "fenda", "elite", "astro", "salve", "navio",
            "grata", "alçar", "viria", "autor", "supra",
            "porta", "irmão", "ficha", "pique", "ético",
            "atual", "cânon", "bônus", "cioso", "reses",
            "deixa", "junco", "besta", "bicho", "douto",
            "macio", "retém", "calda", "abuso", "abriu",
            "pagão", "verba", "cousa", "curso", "judeu",
            "posto", "bioma", "privê", "locus", "caber",
            "molho", "supor", "rádio", "torso", "drops",
            "vídeo", "extra", "light", "desta", "culpa",
            "menos", "zelar", "vosso", "calão", "combo",
            "júlia", "asilo", "vinha", "ígneo", "órfão",
            "baixo", "gosto", "turvo", "chato", "ruína",
            "agudo", "suave", "advir", "super", "pisar",
            "aluno", "facho", "sítio", "estio", "ereto",
            "traço", "rouca", "turma", "ações", "pódio",
            "finda", "pilar", "peito", "chama", "amena",
            "lápis", "paira", "mosto", "meigo", "facto",
            "brabo", "piada", "cútis", "surja", "museu",
            "autos", "louça", "refém", "tento", "rumor",
            "local", "mesma", "feudo", "cocho", "acolá",
            "urgia", "ávida", "passa", "páreo", "geral",
            "optar", "tetra", "drama", "lasso", "clean",
            "metiê", "poema", "boato", "hobby", "folga",
            "coral", "medir", "forem", "teste", "poeta",
            "clima", "pacto", "ateia", "rubro", "crime",
            "golpe", "feroz", "ponha", "móvel", "busca",
            "monge", "cetro", "tacha", "lição", "aviso",
            "idoso", "açude", "amiga", "calmo", "cacho",
            "daqui", "vigia", "aroma", "penta", "monte", 
            "letal", "verde", "carta", "swing", "riste",
            "hoste", "ecoar", "pasmo", "plumo", "vetar",
            "briga", "tribo", "troça", "rival", "falha", 
            "conto", "fórum", "fazia", "ébano", "pedra",
             "roupa", "tarde", "plebe", "escol", "cover",
            "lesse", "súcia", "manga", "grama", "venha",
            "chefe", "casar", "artur", "finjo", "corso", 
            "saldo", "única", "fruto", "axila", "bença",
             "civil", "sósia", "ceifa","staff", "garra",
            "plaga", "itens", "macro", "vento", "cargo",
             "sarau", "átimo", "mangá", "úteis", "arado", 
            "farta", "berro", "ornar", "virar", "pinho",
             "nuvem", "perco", "troca", "légua", "magna", 
            "viram", "beijo", "catre", "bruta", "fosso",
             "vazão", "amada", "tiver", "seixo", "gíria", 
            "jejum", "volta", "traje", "órgão", "deste",
             "stand", "areia", "estro", "perto", "assar", 
            "tição", "bruto", "trato", "inter", "renda",
             "guria", "tutor", "mídia", "surto", "amado", 
            "porte", "canso", "gabar", "feita", "jogar",
             "tchau", "recém", "natal", "rural", "bazar", 
            "arfar", "silvo", "vedar", "nesse", "âmbar",
             "depor", "irado", "grota", "pomar", "cifra", 
            "close", "vadio", "todas", "rocha", "fossa",
             "bucho", "laudo", "odiar", "pavor", "régio", 
            "clero", "nesta", "negar", "aviar", "xucro",
             "visto", "vagar", "minar", "bolsa", "segar", 
            "mamãe", "canto", "densa", "etapa", "deram",
             "lesão", "logos", "molde", "santo", "cenho", 
            "ferpa", "cinto", "vista", "marca", "proto",
             "nessa", "tenha", "chula", "invés", "pasma", 
            "paiol", "horto", "sótão", "largo", "ruído",
             "cheia", "cerca", "morfo", "varoa", "velha", 
            "troco", "urdir", "burra", "penso", "ágape",
             "lesto", "calor", "verão", "coroa", "pugna", 
            "vasta", "salmo", "podar", "letra", "úbere",
             "símio", "final", "ufano", "fundo", "esgar", 
            "ceita", "mocho", "ileso", "trago", "frota",
             "linha", "narco", "jazer", "cível", "pólis", 
            "bulir", "úmido", "folha", "ardis", "piche",
             "apear", "dança", "preço", "resto", "troço", 
            "neste", "manto", "matar", "álamo", "misto",
            "peita", "queda", "redor", "cosmo", "áudio", 
            "monta", "seiva", "folia", "lábia", "banto",
             "mover", "barro", "chaga", "bolso", "barão", 
            "álbum", "sofia", "limpo", "pedro", "macho",
             "retro", "campa", "logia", "calvo", "gemer", 
            "justa", "porca", "punha", "axial", "louro",
             "venho", "lutar", "findo", "farol", "demão", 
            "arroz", "mimar", "chave", "nácar", "sabor",
             "fazes", "veloz", "canil", "bedel", "calça", 
            "enjoo", "salva", "rente", "baixa", "falsa",
             "firma", "lousa", "longo", "lucro", "vazia", 
            "torna", "coevo", "zumbi", "solta", "outra",
             "sigla", "ousar", "míope", "fugiu", "gueto", 
            "forro", "louca", "reler", "dados", "farto",
             "sexto", "nariz", "toque", "urgir", "subir", 
            "tumba", "disso", "corar", "valer", "fátuo",
             "vário", "quais", "penca", "custo", "mania", 
            "samba", "repor", "pagar", "sabiá", "xampu",
             "bruxa", "diabo", "modal", "cardo", "olhos", 
            "sugar", "lento", "versa", "corte", "hífen",
             "bugre", "sadio", "cacto", "passe", "harém", 
            "choça", "nesga", "ferir", "ultra", "obtém",
             "puído", "sócio", "quite", "usual"};
        
        Random rand = new Random();
        gameData = new GameData();
        gameData.palavraAdivinhar = palavras[rand.nextInt(palavras.length)];
        gameData.tentativas = 6;
        gameData.tentativasAnteriores = new StringBuilder();
        boolean ganhou = false;

        System.out.println("Bem-vindo ao Termo");
        System.out.println("Tente adivinhar a palavra. Ela tem " + gameData.palavraAdivinhar.length() + " letras.");

        Scanner scanner = new Scanner(System.in);

        while (gameData.tentativas > 0) {
            System.out.println("Tentativas restantes: " + gameData.tentativas); //Mostra as tentativas restantes

            String palavraDigitada;
            do {
                System.out.print("Digite uma palavra (" + gameData.palavraAdivinhar.length() + " letras): ");
                palavraDigitada = scanner.next();
                if (palavraDigitada.length() != gameData.palavraAdivinhar.length()) {
                    System.out.println("A palavra deve ter o mesmo tamanho da palavra a ser adivinhada.");
                }
            } while (palavraDigitada.length() != gameData.palavraAdivinhar.length());

            gameData.tentativasAnteriores.append(palavraDigitada).append("\n"); 

            for (int i = 0; i < gameData.palavraAdivinhar.length(); i++) {
                char letraAdivinhar = gameData.palavraAdivinhar.charAt(i);
                char letraDigitada = palavraDigitada.charAt(i);

                if (letraDigitada == letraAdivinhar) {
                    System.out.print("\u001B[32m" + letraDigitada + "\u001B[0m");
                } else if (palavraDigitada.contains(String.valueOf(letraAdivinhar))) {
                    System.out.print("\u001B[33m" + letraDigitada + "\u001B[0m");
                } else {
                    System.out.print("\u001B[31m" + letraDigitada + "\u001B[0m");
                }
            }

            System.out.println();

            if (palavraDigitada.equals(gameData.palavraAdivinhar)) {
                ganhou = true;
                break;
            } else {
                System.out.println("\u001B[31mPalavra incorreta!\u001B[0m"); // mostra: "palavra incorreta" pra cada jogada
                gameData.tentativas--;
            }

            // Salve o estado do jogo
            salvarJogo(gameData);
            
        }

        // Apague o arquivo de salvamento após o jogo terminar
        saveFile.delete();

        if (ganhou) {
            System.out.println("Parabéns! Você ganhou. A palavra era: " + gameData.palavraAdivinhar);
        } else {
            System.out.println("Suas tentativas acabaram. Tente novamente! A palavra era: " + gameData.palavraAdivinhar);
        }

        resetar();
    }

    @Override
    public void executa() {
    }

    @Override
    public void carrega() {
        if (saveFile.exists()) {
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(saveFile))) {
                gameData = (GameData) ois.readObject();
                System.out.println("Jogo carregado a partir do estado anterior.");
                System.out.println("Tentativas restantes: " + gameData.tentativas);
                if (gameData.tentativasAnteriores.length() > 0) {
                    System.out.println("Tentativas anteriores:");
                    System.out.println(gameData.tentativasAnteriores.toString());
                }
                // Continuar o jogo a partir do ponto onde o jogador parou
                continuarJogo();
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
                criaNovo(); // Se houver algum erro ao carregar o jogo, inicie um novo jogo
            }
        } else {
            criaNovo(); // Se não houver jogo salvo, inicie um novo jogo
        }
    }

    private static class GameData implements Serializable {
        String palavraAdivinhar;
        int tentativas;
        StringBuilder tentativasAnteriores;
    }

    private void salvarJogo(GameData gameData) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(saveFile))) {
            oos.writeObject(gameData);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void continuarJogo() {
        Scanner scanner = new Scanner(System.in);
    
        while (gameData.tentativas > 0) {
            System.out.println("Tentativas restantes: " + gameData.tentativas);
    
            String palavraDigitada;
            do {
                System.out.print("Digite uma palavra (" + gameData.palavraAdivinhar.length() + " letras): ");
                palavraDigitada = scanner.next();
                if (palavraDigitada.length() != gameData.palavraAdivinhar.length()) {
                    System.out.println("A palavra deve ter o mesmo tamanho da palavra a ser adivinhada.");
                }
            } while (palavraDigitada.length() != gameData.palavraAdivinhar.length());
    
            gameData.tentativasAnteriores.append(palavraDigitada).append("\n");
    
            for (int i = 0; i < gameData.palavraAdivinhar.length(); i++) {
                char letraAdivinhar = gameData.palavraAdivinhar.charAt(i);
                char letraDigitada = palavraDigitada.charAt(i);
    
                if (letraDigitada == letraAdivinhar) {
                    System.out.print("\u001B[32m" + letraDigitada + "\u001B[0m");
                } else if (palavraDigitada.contains(String.valueOf(letraAdivinhar))) {
                    System.out.print("\u001B[33m" + letraDigitada + "\u001B[0m");
                } else {
                    System.out.print("\u001B[31m" + letraDigitada + "\u001B[0m");
                }
            }
    
            System.out.println();
    
            if (palavraDigitada.equals(gameData.palavraAdivinhar)) {
                System.out.println("Parabéns! Você ganhou. A palavra era: " + gameData.palavraAdivinhar);
                break;
            } else {
                System.out.println("\u001B[31mPalavra incorreta!\u001B[0m");
                gameData.tentativas--;
            }
    
            // Salve o estado do jogo a cada jogada
            salvarJogo(gameData);
        }
    
        // Apague o arquivo de salvamento após o jogo terminar
        saveFile.delete();
    
        if (gameData.tentativas <= 0) {
            System.out.println("Suas tentativas acabaram. Tente novamente! A palavra era: " + gameData.palavraAdivinhar);
        }
        resetar();
}

     public void resetar(){

         Scanner teclado = new Scanner(System.in);

        System.out.println("Deseja jogar novamente?");
        System.out.println("1- Sim");
        System.out.println("2- Não (Sair)");

        int entrada = teclado.nextInt();

        switch (entrada) {
            case 1:
                criaNovo();
                break;
            case 2:
                System.out.println("Obrigado por Jogar!");
                return;
            default:
                throw new InputMismatchException("entrada inválida");
        }

       }

}
