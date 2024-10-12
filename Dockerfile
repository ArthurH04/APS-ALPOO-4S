# Usa uma imagem base do OpenJDK
FROM openjdk:17-jdk-slim

# Define o diretório de trabalho
WORKDIR /app
COPY src /app/src
COPY build.xml /app/build.xml

# Instala o Apache Ant
RUN apt-get update && \
    apt-get install -y --no-install-recommends \
    default-mysql-client \
    libxtst6 \
    libxext6 \
    libxrender1 \
    libfontconfig1 \
    libx11-6 \
    libxau6 \
    libxdmcp6 \
    ant \
    && rm -rf /var/lib/apt/lists/*

# Compila o projeto e cria o JAR
RUN ant jar

# Define o comando padrão para executar a aplicação
CMD ["java", "-jar", "dist/MovieMVC.jar"]