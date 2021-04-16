FROM node
EXPOSE 6380
RUN npm install -g redis-commander
ENTRYPOINT ["redis-commander", "--redis-host", "redis-cache","--port","6380"]