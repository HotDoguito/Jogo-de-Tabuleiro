# 🎲 Jogo de Tabuleiro em Java

> **Projeto desenvolvido para a disciplina de Programação Orientada a Objetos (POO)**
> 
> **Autores:**
> - 👨‍💻 [Theodorico Vale](https://github.com/The-TheoVale)
> - 👨‍💻 [Miguel Maia](https://github.com/MiguelmxDev)

---

## 📋 Sobre o Projeto

O **Jogo de Tabuleiro** é uma aplicação interativa desenvolvida em **Java** para ambiente de linha de comando (CLI). O projeto foi concebido para aplicar e demonstrar na prática os pilares fundamentais da **Programação Orientada a Objetos (POO)**, tais como **Encapsulamento**, **Herança**, **Polimorfismo**, **Interfaces** e o padrão de projeto **Strategy**.

Na partida, de **2 a 6 jogadores** competem em um tabuleiro composto por **40 casas**, buscando alcançar primeiro a linha de chegada. A dinâmica do jogo é enriquecida por comportamentos individuais na rolagem de dados (jogadores normais, sortudos e azarados) e por casas especiais no tabuleiro que concedem bônus, armadilhas e efeitos mágicos.

---

## 🚀 Funcionalidades & Regras

- 👥 **Suporte de 2 a 6 Jogadores**: Cada jogador seleciona uma cor exclusiva (`AZUL`, `VERMELHO`, `VERDE`, `AMARELO`, `CIANO` ou `BRANCO`).
- 🎲 **Mecânica de Dados Duplos**: Caso o jogador tire dados iguais ($d_1 = d_2$) e não esteja sob penalidade, ele ganha uma rodada extra imediatamente.
- 🛠️ **Modo Debug**: Opção configurável no início da partida para forçar o movimento dos jogadores para casas específicas, facilitando testes e demonstrações.
- 🏆 **Condição de Vitória**: O primeiro jogador a atingir ou ultrapassar a casa número 40 é declarado o vencedor.

---

## 🎭 Tipos de Jogadores (Padrão Strategy)

Cada jogador recebe aleatoriamente um perfil no início da partida, o que altera a distribuição probabilística da sua rolagem de dados:

| Tipo | Ícone | Comportamento na Rolagem de Dados |
| :--- | :---: | :--- |
| **Normal** | 🎲 | Rola 2 dados de 6 lados convencionais (soma entre 2 e 12). |
| **Sortudo** | 🍀 | Rola 2 dados com garantia de que a soma será sempre **maior ou igual a 7** ($\ge 7$). |
| **Azarado** | 💀 | Rola 2 dados com garantia de que a soma será sempre **menor ou igual a 6** ($\le 6$). |

---

## 🏠 Casas Especiais do Tabuleiro

O tabuleiro possui 40 posições com comportamentos polimórficos definidos por subclasses de `Casa`:

| Casa | Posições | Efeito |
| :--- | :---: | :--- |
| **Casa Normal** | *Demais casas* | Casa sem efeitos (sem bônus nem ônus). |
| **Pula Vez** (`CasaDontPlayNextRd`) | `10`, `25`, `38` | O jogador que cair nesta casa perde a próxima rodada. |
| **Casa da Sorte** (`CasaSorte`) | `5`, `15`, `30` | Avança 3 casas extras (efeito anulado se o jogador for do tipo *Azarado*). |
| **Casa Surpresa** (`CasaSurpresa`) | `13` | Sortear aleatoriamente uma nova personalidade para o jogador (*Sortudo*, *Azarado* ou *Normal*). |
| **Escolha um Jogador** (`CasaChoosePlayer`) | `17`, `27` | Permite escolher qualquer adversário para retornar à casa inicial (`0`). |
| **Casa Mágica** (`CasaMagica`) | `20`, `35` | Troca de posição instantaneamente com o jogador que estiver na última posição. |

---

## 🧩 Conceitos de POO Aplicados

1. **Encapsulamento**:
   - Atributos das classes (`posicao`, `jogadas`, `tipo`, `pularVez`, `tabuleiro`, `jogadores`) mantidos como `private`, expostos apenas via getters/setters controlados.
2. **Herança**:
   - Superclasse `Casa` estendida por subclasses especializadas: `CasaSorte`, `CasaSurpresa`, `CasaMagica`, `CasaDontPlayNextRd` e `CasaChoosePlayer`.
3. **Polimorfismo**:
   - Invocação dinâmica de métodos sobrescritos (`mensagemCasa` e `houseEffect`) a partir da lista polimórfica de casas em `Tabuleiro`.
4. **Interfaces & Strategy Pattern**:
   - A interface `TipoJogador` estabelece o contrato para rolagem de dados (`jogarDados()`), permitindo trocar o comportamento em tempo de execução.
5. **Composição e Agregação**:
   - `Jogo` possui uma lista de `Jogador` e um `Tabuleiro`.
   - `Tabuleiro` é composto por uma lista de instâncias da hierarquia `Casa`.

---

## 📁 Estrutura do Código

```text
src/
├── Main.java                # Ponto de entrada, configuração inicial de jogadores e cores
├── Jogo.java                # Controladora do loop da partida e troca de turnos
├── Tabuleiro.java           # Instanciação e mapeamento das 40 casas
├── Jogador.java             # Entidade que representa o participante
├── TipoJogador.java         # Interface da estratégia de rolagem de dados
├── JogadorNormal.java       # Implementação de rolagem regular
├── JogadorSortudo.java      # Implementação de rolagem favorável (soma >= 7)
├── JogadorAzarado.java      # Implementação de rolagem desfavorável (soma <= 6)
├── Casa.java                # Superclasse base para as casas do tabuleiro
├── CasaSorte.java           # Subclasse: avança 3 casas
├── CasaSurpresa.java        # Subclasse: altera o tipo do jogador
├── CasaMagica.java          # Subclasse: troca de lugar com o último colocado
├── CasaDontPlayNextRd.java  # Subclasse: faz o jogador pular a próxima vez
└── CasaChoosePlayer.java    # Subclasse: manda um adversário para o início
```

---

## 💻 Como Executar

### Pré-requisitos
- **Java Development Kit (JDK)** versão 17 ou superior.

### Passos para execução via Terminal

1. **Navegue até a pasta do projeto:**
   ```bash
   cd JogoTabuleiro
   ```

2. **Compile as classes Java:**
   ```bash
   javac -d bin src/*.java
   ```

3. **Execute o jogo:**
   ```bash
   java -cp bin Main
   ```

---

<p align="center">
  Desenvolvido com ☕ para a disciplina de <b>Programação Orientada a Objetos</b>.
</p>
