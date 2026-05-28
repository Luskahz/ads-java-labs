oque vou precisar ver: 


algo precisa pegar o arquivo e e preciso ler o input
preciso separar ele em linhas e subir as linhas para ram 1 por 1 pra n explodir o buffer
preciso que o mapeamento das linhas seja feito por worker, pra processamento simultâneo de linhas

pra cada linha:
    preciso fazer o split da linha separando as palavras pelo caracter do espaço: " ".
    pra cada palavra encontrada eu jogo ela num hashmap com 3 informações: id, tamanhoCaracteres, palavra
    necessario implementar um filtro aqui na entrada do hashmap:
        o filtro deve inserir as palavras da seguinte forma:
            - a palavra n pode já existir no hashmap.
            - a palavra n deve ter caracteres especiais
            - a palavra n deve conter numeros
            - a palavra n deve conter mais de 5 letras
    return: 
        apartir daqui eu tenho 1 hashmap com todas as palavras validas extraidas do input. posso começar a subir essas palavras na árvore;

------ após este parte penso no restante
