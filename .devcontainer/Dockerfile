# Imagem base com JDK 17
FROM eclipse-temurin:17-jdk

# Instalar Maven, Git e ferramentas básicas
RUN apt-get update && apt-get install -y \
    maven \
    git \
    curl \
    unzip \
    && rm -rf /var/lib/apt/lists/*

# Definir diretoria de trabalho
WORKDIR /workspace

# Verificar versões instaladas
RUN java --version && mvn --version && git --version