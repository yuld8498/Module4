const jsonServer = require('json-server');
const server = jsonServer.create();
const router = jsonServer.router('c0422i1.json');
const middlewares = jsonServer.defaults();

const PORT = 3000;

server.use(middlewares);
server.use(router);
server.listen(PORT, () => {
  console.log('JSON Server is running' + PORT);
});
