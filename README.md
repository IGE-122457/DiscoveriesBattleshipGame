# Battleship

---

NOTA: O TSoeiro19 é o IGE-122488

##  Parte 1 – Especificação de Requisitos  
### E.3. Considere que é o Product Owner dessa app. Em seu entender, que requisitos adicionais lhe faltam? Por outras palavras, qual deverá ser o Product Backlog?


Como **Product Owner**, além das regras básicas do jogo, identificam-se os seguintes requisitos adicionais necessários para completar o produto:

- Como jogador, quero **posicionar os meus navios de forma válida**, garantindo um jogo justo.
- Como jogador, quero que o sistema **valide os tiros**, impedindo coordenadas inválidas ou repetidas.
- Como jogador, quero **ver claramente o resultado de cada tiro** (água, acerto ou navio afundado).
- Como jogador, quero **visualizar o estado da frota adversária** e identificar os navios já afundados.
- Como jogador, quero que o sistema **controle automaticamente os turnos e as rondas**.
- Como jogador, quero que o jogo **detete o fim da partida e anuncie o vencedor**.
- Como utilizador, quero **reiniciar ou iniciar um novo jogo facilmente**.
- Como utilizador, quero **mensagens de erro claras** sempre que ocorre uma jogada inválida.
- Como utilizador, quero **consultar o histórico de jogadas**, para acompanhar o progresso do jogo.

---

##  Parte 2 –  Reflexão 
### C.1. Reflita: Quais as diferenças entre trabalhar via web e via IDE? Em que situações é preferível cada abordagem?

Trabalhar **via web** é mais simples e acessível, não requer instalação local e é adequado para projetos pequenos, aprendizagem ou colaboração rápida. No entanto, oferece menos funcionalidades avançadas.

Trabalhar **via IDE** proporciona um ambiente de desenvolvimento completo, com ferramentas de apoio à escrita de código, depuração, testes e documentação, sendo mais indicado para projetos de média ou grande dimensão.

A escolha entre as duas abordagens depende da **complexidade do projeto** e do **nível de controlo e produtividade pretendidos**.

---

## 🚀 Projeto: Grupo dos Fixes

Este repositório contém o desenvolvimento de um jogo de estratégia naval focado na era dos Descobrimentos.

---

## 👥 Equipa

| Número | Nome Completo        | Curso                              |
|------:|---------------------|------------------------------------|
| 122457 | António Namniyek   | Informática e Gestão de Empresas   |
| 122478 | Gonçalo Silva     | Informática e Gestão de Empresas   |
| 122482 | Leonardo Teodoro  | Informática e Gestão de Empresas   |
| 122488 | Tiago Soeiro      | Informática e Gestão de Empresas   |

---

## 🚢 Tipos de Navios

No jogo, as unidades disponíveis baseiam-se na frota histórica portuguesa:

- **Nau** – Navio de grande porte, resistente e com elevada capacidade de carga.
- **Caravela** – Veloz e manobrável, ideal para exploração e navegação costeira.
- **Galeão** – Unidade militar poderosa, fortemente armada para combate naval.

---

## 📜 Regras do Jogo

1. **Posicionamento:** Cada jogador coloca a sua frota num tabuleiro de 10×10.
2. **Turnos:** Os jogadores alternam disparos, indicando coordenadas (ex.: A5, B2).
3. **Objetivo:** Ganha o jogador que afundar todos os navios da frota adversária.
4. **Restrições:** Os navios não se podem sobrepor nem ultrapassar os limites do tabuleiro.

---

## 📚 Referências Históricas

- [A Caravela – Wikipedia](https://pt.wikipedia.org/wiki/Caravela)
- [As Naus da Carreira da Índia – Wikipedia](https://pt.wikipedia.org/wiki/Nau)

---

*Basic academic version of the Battleship game to build upon.*
