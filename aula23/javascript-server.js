const express = require('express')
const app = express()
const port = process.argv[2] == undefined ? 3000 : process.argv[2];

var fs = require('fs');
var file = fs.readFileSync('index.html', "utf8");

app.get('/', (request, response) => {
    response.send(file);
})

app.get('/random', (request, response) => {
    response.send(""+Math.random());
})

app.listen(port, (err) => {
  if (err) {
    return console.log('something bad happened', err);
  }
  console.log(`server is listening on ${port}`);
})