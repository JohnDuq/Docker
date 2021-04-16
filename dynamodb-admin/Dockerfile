FROM node
ENV DYNAMO_ENDPOINT=http://aws-localstack:4566
EXPOSE 4565
RUN npm install -g dynamodb-admin
ENTRYPOINT ["dynamodb-admin","--port","4565"]