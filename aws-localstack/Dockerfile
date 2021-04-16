FROM localstack/localstack-full
WORKDIR /docker-entrypoint-initaws.d
COPY ./commands/* .
ENV SERVICES=dynamodb,secretsmanager
EXPOSE 4566
EXPOSE 8080