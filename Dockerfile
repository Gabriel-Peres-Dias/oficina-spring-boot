# Etapa 1: Construir o aplicativo com Maven
FROM maven:3.8.6 AS builder

WORKDIR /app

# Copia apenas o arquivo pom.xml para otimizar o cache
COPY pom.xml .

# Baixa as dependências do Maven (isso é feito separadamente para otimizar o cache)
RUN mvn dependency:go-offline

# Copia o restante do código-fonte para o diretório de trabalho
COPY src src

# Executa o comando "mvn package" para construir o aplicativo
RUN mvn package

# Etapa 2: Imagem final apenas com o OpenJDK 17
FROM openjdk:17

WORKDIR /app

# Copia o artefato construído da etapa anterior
COPY --from=builder /app/target/projeto_etb.jar .

# Opcional: Define o comando de entrada padrão para executar o aplicativo quando o contêiner for iniciado
CMD ["java", "-jar", "projeto_etb.jar"]
