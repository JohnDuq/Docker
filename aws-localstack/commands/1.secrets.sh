aws secretsmanager create-secret --name SecretNameExample --description "Secret description Example" --secret-string file:///docker-entrypoint-initaws.d/itemSecretManager.json --endpoint-url http://localhost:4566